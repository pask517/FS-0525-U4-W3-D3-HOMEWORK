package andreapascarella;

import andreapascarella.entities.Event;
import andreapascarella.enums.EventType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FS-0525-U4-W3-D3-HOMEWORKpu");
        EntityManager em = emf.createEntityManager();



        Event event= new Event("Concerto Pupo", LocalDate.of(2026,10,10),"Bellissimo", EventType.PUBLIC,100,);
    }
}
