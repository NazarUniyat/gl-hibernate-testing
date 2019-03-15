package DAO;

import Examples.WorkerExamples;
import entity.Department;
import entity.Workers;
import entity.enums.Availability;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class WorkersDAOTest {

    private static Logger log = LogManager.getLogger(WorkersDAOTest.class);

    private static final SessionFactory sessionFactory;
    private  Session session;


    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable th) {
            System.err.println("Initial SessionFactory creation failed" + th);
            throw new ExceptionInInitializerError(th);
        }
    }
    @AfterAll
    public static void closeSessionFactory() {
        sessionFactory.close();
    }

    @BeforeEach
    public void startSession() {
        session = sessionFactory.openSession();
    }

    @AfterEach
    public void closeSession() {
        session.close();
    }


    @Test
    void getWorkersByDepartmentIdAndAvailabilityHQL() {
        WorkersDAO workersDAO = new WorkersDAO(session);
        WorkerExamples.createFewWorkers(session);
        List<Workers> workersByDepartmentIdAndAvailabilityHQL = workersDAO
                .getWorkersByDepartmentIdAndAvailabilityHQL(1, Availability.PART_TIME);
        assertEquals(2,workersByDepartmentIdAndAvailabilityHQL.size());
    }

    @Test
    void getWorkersByDepartmentIdAndAvailabilityHQLNegative() {
        WorkersDAO workersDAO = new WorkersDAO(session);
        WorkerExamples.createFewWorkers(session);
        List<Workers> workersByDepartmentIdAndAvailabilityHQL = workersDAO
                .getWorkersByDepartmentIdAndAvailabilityHQL(1, Availability.PART_TIME);
        assertNotEquals(true,workersByDepartmentIdAndAvailabilityHQL.size()!=2);
    }

    @Test
    void getWorkersByDepartmentIdAndAvailabilityJPA() {
        WorkersDAO workersDAO = new WorkersDAO(session);
        WorkerExamples.createFewWorkers(session);
        List<Workers> workersByDepartmentIdAndAvailabilityJPA = workersDAO
                .getWorkersByDepartmentIdAndAvailabilityJPA(1, Availability.PART_TIME);
        assertEquals(2,workersByDepartmentIdAndAvailabilityJPA.size());
    }

    @Test
    void getWorkersByDepartmentIdAndAvailabilityJPANegative() {
        WorkersDAO workersDAO = new WorkersDAO(session);
        WorkerExamples.createFewWorkers(session);
        List<Workers> workersByDepartmentIdAndAvailabilityJPA = workersDAO
                .getWorkersByDepartmentIdAndAvailabilityJPA(1, Availability.PART_TIME);
        assertNotEquals(true,workersByDepartmentIdAndAvailabilityJPA.size()!=2);
    }



}