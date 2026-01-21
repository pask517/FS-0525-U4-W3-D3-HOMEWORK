package andreapascarella.entities;


import andreapascarella.enums.GenderType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    @OneToMany(mappedBy = )
    private List<Participation> participations;

     public Person(){
     }

     public Person(String name,String surname,String email,LocalDate birthDate,GenderType genderType){
         this.name=name;
         this.surname=surname;
         this.email=email;
         this.birthDate=birthDate;
         this.genderType=genderType;
     }

}
