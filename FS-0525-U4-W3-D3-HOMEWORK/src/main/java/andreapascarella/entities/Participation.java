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

    @Column(nullable = false)
    private Person person;

    @Column(nullable = false)
    private Event event;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StateType state;
}
