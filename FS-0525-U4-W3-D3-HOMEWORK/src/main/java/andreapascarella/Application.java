package andreapascarella;

import andreapascarella.dao.EventsDAO;
import andreapascarella.dao.LocationsDAO;
import andreapascarella.entities.Event;
import andreapascarella.entities.Location;
import andreapascarella.enums.EventType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("FS-0525-U4-W3-D3-HOMEWORKpu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventsDAO ed = new EventsDAO(em);
        LocationsDAO ld = new LocationsDAO(em);

        Location roma = new Location("Colosseo", "Roma");
        Location verona = new Location("Arena", "Verona");
        Location milano = new Location("San Siro", "Milano");

        //ld.saveLocation(roma);
        //ld.saveLocation(verona);
        //ld.saveLocation(milano);

        Location romaFromDB = ld.findById("9be696a7-2f65-456b-b71e-91490801ccac");
        Location veronaFromDB = ld.findById("79fa57bd-3b7f-4bfa-9350-c6cbc8d5c324");
        Location milanoFromDB = ld.findById("ea41fe2d-0b42-4ea5-935f-5e37e4fa025d");

        Event event = new Event("Concerto Pupo", LocalDate.of(2026, 10, 10), "Bellissimo", EventType.PUBLIC, 100, romaFromDB);
        Event event1 = new Event("Concerto Gigi D'Alessio", LocalDate.of(2026, 8, 22), "Stupendo", EventType.PRIVATE, 200, veronaFromDB);
        Event event2 = new Event("Inter-Juventus", LocalDate.of(2026, 2, 15), "Bella partita", EventType.PRIVATE, 200, milanoFromDB);

        //ed.saveEvent(event);
        //ed.saveEvent(event1);
        //ed.saveEvent(event2);

        System.out.println(romaFromDB.getEvents());
    }
}
