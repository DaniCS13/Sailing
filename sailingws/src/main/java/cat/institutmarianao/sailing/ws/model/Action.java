package cat.institutmarianao.sailing.ws.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/* JPA annotations */
/* Mapping JPA Indexes */
/* JPA Inheritance strategy is single table */
/*
 * Maps different JPA objects depDONEing on his type attribute (Opening,
 * Assignment, Intervention or Close)
 */
@Entity
@Table(name = "actions")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
/* Lombok */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Action implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Values for type - MUST be constants */
	public static final String BOOKING = "BOOKING";
	public static final String RESCHEDULING = "RESCHEDULING";
	public static final String CANCELLATION = "CANCELLATION";
	public static final String DONE = "DONE";

	public enum Type {
		BOOKING, RESCHEDULING, CANCELLATION, DONE
	}

	/* Validation */
	/* JPA */
	@Id
	@Column(name = "id", nullable = false, unique = true)
	/* Lombok */
	@EqualsAndHashCode.Include
	protected Long id;

	/* Validation */
	/* Lombok */
	@NonNull
	/* JPA */
	@Enumerated(EnumType.STRING) // Guarda el tipo como un string en la base de datos
	@Column(name = "type", insertable = false, updatable = false, nullable = false, length = 31)
	protected Type type;

	/* Validation */
	/* JPA */
	@ManyToOne
	@JoinColumn(name = "performer_username", nullable = false)
	protected User performer;

	/* JPA */
	@Column(name = "date", nullable = false)
	protected Date date = new Date();

	/* Validation */
	/* JPA */
	@ManyToOne
	@JoinColumn(name = "trip_id", nullable = false)
	/* JSON */
	protected Trip trip;

	@Column(name = "comments", length = 255)
	private String comments;
}