package cat.institutmarianao.sailing.ws.model;

import java.io.Serializable;

import cat.institutmarianao.sailing.ws.validation.groups.OnUserCreate;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/* JPA annotations */
@Entity
/* An employee is identified in the user table with role=EMPLOYEE */
@DiscriminatorValue(User.CLIENT)
/* Lombok */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Client extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int MIN_FULL_NAME = 3;
	public static final int MAX_FULL_NAME = 100;

	/* Validation */
	@NotBlank(groups = OnUserCreate.class)
	/* JPA */
	@Column(name = "full_name", length = MAX_FULL_NAME, nullable = false)
	protected String fullName;

	/* Validation */
	@NotNull(groups = OnUserCreate.class)
	@Column(name = "phone")
	protected String phone;
}
