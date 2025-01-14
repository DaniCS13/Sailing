package cat.institutmarianao.sailing.ws.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/* Validation */
/* JPA annotations */
@Entity
@Table(name = "actions")
/* Lombok */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Rescheduling extends Action {
	private static final long serialVersionUID = 1L;

	/* Validation */
	/* JPA */
	@Column(name = "new_date")
	private Date newDate;

	/* Validation */
	/* JPA */
	@Column(name = "new_departure")
	private Date newDeparture;
}
