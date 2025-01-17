package cat.institutmarianao.sailing.ws.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

//cambiar
/* Validation */
@NotBlank
/* JPA annotations */
@Entity
@DiscriminatorValue(Action.BOOKING)
/* Lombok */
@Data
@EqualsAndHashCode(callSuper = true)
public class Booking extends Action {
	private static final long serialVersionUID = 1L;

	public Booking() {
		super(Type.BOOKING);
	}
}
