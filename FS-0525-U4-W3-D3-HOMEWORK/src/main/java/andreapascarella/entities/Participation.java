package andreapascarella.entities;

import andreapascarella.enums.StateType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "participations")
public class Participation {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn
    private Person person;

    @ManyToOne()
    private Event event;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StateType state;
}
