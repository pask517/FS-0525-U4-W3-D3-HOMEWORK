package andreapascarella;

import andreapascarella.dao.EventsDAO;
import andreapascarella.dao.LocationsDAO;
import andreapascarella.dao.ParticipationDAO;
import andreapascarella.dao.PersonDAO;
import andreapascarella.entities.Event;
import andreapascarella.entities.Location;
import andreapascarella.entities.Participation;
import andreapascarella.entities.Person;
import andreapascarella.enums.EventType;
import andreapascarella.enums.GenderType;
import andreapascarella.enums.StateType;
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
        PersonDAO pd = new PersonDAO(em);
        ParticipationDAO pad = new ParticipationDAO(em);

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

        Person andrea = new Person("Andrea", "Pascarella", "andreapascarella@ciao.org", LocalDate.of(1999, 12, 27), GenderType.MALE);
        Person roberto = new Person("Roberto", "Di Lallo", "robertodilallo@ciao.org", LocalDate.of(2004, 8, 6), GenderType.MALE);
        Person benedetta = new Person("Benedetta", "Di Giulio", "benedettadigiulio@ciao.org", LocalDate.of(2002, 10, 21), GenderType.FEMALE);

        //pd.savePerson(andrea);
        //pd.savePerson(roberto);
        //pd.savePerson(benedetta);

        Event pupoFromDB = ed.findById("4d965922-0300-4638-b478-55b3cc479d0e");
        Event gigiFromDB = ed.findById("fd1bc990-12e7-40de-9713-18644e703cb4");
        Event interFromDB = ed.findById("70347284-a017-4711-9c0c-0fb8aecae569");

        Person andreaFromDB = pd.findById("671f92ef-f747-4844-9d87-90b00e690356");
        Person robertoFromDB = pd.findById("e56c666f-77f9-4d9c-a12e-2cffde707bca");
        Person benedettaFromDB = pd.findById("39a641d6-8439-4ac1-81b0-df563eef648c");

        Participation participation = new Participation(StateType.DA_CONFERMARE, andreaFromDB, pupoFromDB);
        Participation participation1 = new Participation(StateType.CONFERMATA, robertoFromDB, pupoFromDB);
        Participation participation2 = new Participation(StateType.CONFERMATA, andreaFromDB, gigiFromDB);


        //pad.saveParticipation(participation);
        //pad.saveParticipation(participation1);
        //pad.saveParticipation(participation2);
        
        em.close();
        emf.close();
    }

}
