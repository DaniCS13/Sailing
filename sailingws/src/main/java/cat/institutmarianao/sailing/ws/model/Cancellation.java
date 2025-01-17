package cat.institutmarianao.sailing.ws.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

/* Validation */
@NotBlank
/* JPA annotations */
@Entity
@DiscriminatorValue(Action.CANCELLATION)
/* Lombok */
@Data
@EqualsAndHashCode(callSuper = true)
public class Cancellation extends Action {
	private static final long serialVersionUID = 1L;

	public Cancellation() {
		super(Type.CANCELLATION);
	}
}
