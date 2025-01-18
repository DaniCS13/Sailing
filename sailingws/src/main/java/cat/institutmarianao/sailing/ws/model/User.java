package cat.institutmarianao.sailing.ws.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/* JPA */
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING) // Valor para diferenciar si es
																					// cliente o admin

/* Lombok */
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class User implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Values for role - MUST be constants (can not be enums) */
	public static final String ADMIN = "ADMIN";
	public static final String CLIENT = "CLIENT";

	public enum Role {
		ADMIN, CLIENT
	}

	public static final int MIN_USERNAME = 2;
	public static final int MAX_USERNAME = 25;
	public static final int MIN_PASSWORD = 10;

	/* Validation */
	/* JPA */
	@Id
	@Column(name = "username", length = MAX_USERNAME, nullable = false, unique = true)
	/* Lombok */
	@EqualsAndHashCode.Include
	protected String username;

	/* Validation */
	/* JPA */
	@Column(name = "password")
	protected String password;

	/* Validation */
	/* JPA */
	@Enumerated(EnumType.STRING)
	@Column(name = "role", insertable = false, updatable = false, nullable = false)
	protected Role role;

	abstract @NotBlank
	public String getUsername();

	public abstract Object getPassword();

	public void setPassword(Object password2) {
		// TODO Auto-generated method stub
		
	}
}
