package cat.institutmarianao.sailing.ws.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/* JPA annotations */
@Entity
@Table(name = "trip_types")
/* Lombok */
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TripType implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String GROUP = "GROUP";
	public static final String PRIVATE = "PRIVATE";

	public enum Category {
		GROUP, PRIVATE
	}

	/* Validation */
	/* JPA */
	@Id
	@Column(name = "id", nullable = false, unique = true)
	/* Lombok */
	@EqualsAndHashCode.Include
	private Long id;

	/* Validation */
	/* JPA */
	@Column(name = "title", nullable = false, length = 255)
	private String title;

	/* Validation */
	/* JPA */
	@Enumerated(EnumType.STRING) // Para persistir el valor del enum como una cadena en la base de datos
	@Column(name = "category", nullable = false)
	private Category category;

	/* Validation */
	@Column(name = "description", length = 255)
	private String description;

	/* Validation */
	@Column(name = "price", nullable = false)
	private double price;

	/* JPA */
	@ElementCollection // Para almacenar una lista de fechas en una tabla separada (si es necesario)
	@CollectionTable(name = "trip_type_departures", joinColumns = @JoinColumn(name = "trip_type_id"))
	@Column(name = "departure")
	private List<Date> departures;

	/* Validation */
	@Column(name = "duration", nullable = false)
	private int duration;

	/* Validation */
	/* JPA */
	@Column(name = "max_places", nullable = false)
	private int maxPlaces;
}
