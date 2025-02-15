package cat.institutmarianao.sailing.ws.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/* Validation */
@NotBlank
/* JPA annotations */
@Entity
@DiscriminatorValue(Action.RESCHEDULING)
/* Lombok */
@Data
@EqualsAndHashCode(callSuper = true)
public class Rescheduling extends Action {
    private static final long serialVersionUID = 1L;

    /* Validation */
    /* JPA */
    @Column(name = "new_date")
    @Temporal(TemporalType.DATE)
    private Date newDate;

    /* Validation */
    /* JPA */
    @Column(name = "new_departure")
    @Temporal(TemporalType.TIME)
    private Date newDeparture;

    public Rescheduling() {
        super(Type.RESCHEDULING);
    }
}
