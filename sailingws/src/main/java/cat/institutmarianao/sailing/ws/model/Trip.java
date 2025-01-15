package cat.institutmarianao.sailing.ws.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* JPA annotations */
@Entity
@Table(name = "trips")
/* Lombok */
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Trip implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int MAX_DESCRIPTION = 500;

	public static final String RESERVED = "RESERVED";
	public static final String RESCHEDULED = "RESCHEDULED";
	public static final String CANCELLED = "CANCELLED";
	public static final String DONE = "DONE";

	public enum Status {
		RESERVED, RESCHEDULED, CANCELLED, DONE
	}

	/* Validation */

	/* JPA */
	@Id
	@Column(name = "id", nullable = false, unique = true)
	/* Lombok */
	@EqualsAndHashCode.Include
	/* JSON */
	private Long id;

	/* JPA */
	@ManyToOne // Relación con TripType (muchos a uno)
	@JoinColumn(name = "type_id", nullable = false)
	private TripType type;

	/* Validation */
	/* JPA */
	@ManyToOne // Relación con Client (muchos a uno)
	@JoinColumn(name = "client_username", nullable = false)
	private Client client;

	/* JPA */
	/* JPA */
	@Column(name = "places", nullable = false)
	private int places;

	/* Validation */

	/* JPA */
	@OneToMany // Relación con Action (uno a muchos)
	@JoinColumn(name = "trip_id")
	private List<@Valid Action> tracking;

	/* JPA */

	/* Hibernate */
	@Formula("(SELECT CASE a.type WHEN '" + Action.BOOKING + "' THEN '" + Trip.RESERVED + "' WHEN '"
			+ Action.RESCHEDULING + "' THEN '" + Trip.RESCHEDULED + "' WHEN '" + Action.CANCELLATION + "' THEN '"
			+ Trip.CANCELLED + "' WHEN '" + Action.DONE + "' THEN '" + Trip.DONE + "' ELSE NULL END FROM actions a "
			+ " WHERE a.date=( SELECT MAX(last_action.date) FROM actions last_action "
			+ " WHERE last_action.trip_id=a.trip_id AND last_action.trip_id=id ))")
	// Lombok
	@Setter(AccessLevel.NONE)
	private Status status;

	/* Validation */

	/* JPA */
	@Column(name = "date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;

	/* JPA */
	@Column(name = "departure", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date departure;
}
