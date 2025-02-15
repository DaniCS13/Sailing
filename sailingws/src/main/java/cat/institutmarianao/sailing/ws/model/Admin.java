package cat.institutmarianao.sailing.ws.model;

import java.io.Serializable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/* JPA annotations */
@Entity
/* An employee is identified in the user table with role=EMPLOYEE */
@DiscriminatorValue(User.ADMIN)
/* Lombok */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Admin extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public @NotBlank String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
}
