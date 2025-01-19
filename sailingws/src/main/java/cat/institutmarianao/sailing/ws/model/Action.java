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
@Entity
@Table(name = "actions")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
/* Lombok */
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Action implements Serializable {

    private static final long serialVersionUID = 1L;

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
    @EqualsAndHashCode.Include
    protected Long id;

    /* Validation */
    @NonNull
    /* JPA */
    @Enumerated(EnumType.STRING)
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
    protected Trip trip;

    @Column(name = "comments", length = 255)
    private String comments;

    // Constructor con Action.Type
    public Action(Type type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
