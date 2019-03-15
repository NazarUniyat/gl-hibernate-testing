package DAO;

import Examples.WorkerExamples;
import entity.Department;
import entity.Workers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentDAOTest {

    private static Logger log = LogManager.getLogger(DepartmentDAOTest.class);

    private static final SessionFactory sessionFactory;
    private Session session;


    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable th) {
            System.err.println("Initial SessionFactory creation failed" + th);
            throw new ExceptionInInitializerError(th);
        }
    }

    @AfterAll
    public static void closeSessionFactory(){
        sessionFactory.close();
    }

    @BeforeEach
    public void startSession(){
        session = sessionFactory.openSession();
    }

    @AfterEach
    public void closeSession(){
        session.beginTransaction();
        List<Workers> fromWorkers =session.createQuery("from Workers ").list();
        List<Department> fromDepartment = session.createQuery("from Department").list();
        for (Workers fromWorker : fromWorkers) {
            session.delete(session.load(Workers.class,fromWorker.getId()));
        }
        for (Department department : fromDepartment) {
            session.delete(session.load(Department.class,department.getIdDepartment()));
        }
        session.getTransaction().commit();
        session.close();
    }

    @Test
    void getAllActiveDeparmentsJPA() {
        DepartmentDAO departmentDAO = new DepartmentDAO(session);
        WorkerExamples.createFewWorkers(session);
        List<Department> allActiveDeparmentsJPA = departmentDAO.getAllActiveDeparmentsJPA();
        assertEquals(2, allActiveDeparmentsJPA.size());
    }

    @Test
    void getAllActiveDeparmentsJPANegative() {
        DepartmentDAO departmentDAO = new DepartmentDAO(session);
        WorkerExamples.createFewWorkers(session);
        List<Department> allActiveDeparmentsJPA = departmentDAO.getAllActiveDeparmentsJPA();
        assertNotEquals(true, allActiveDeparmentsJPA.size()!=2);
    }


    @Test
    void getAllActiveDeparmentsHQl() {
        DepartmentDAO departmentDAO = new DepartmentDAO(session);
        WorkerExamples.createFewWorkers(session);
        List<Department> allActiveDeparmentsHQL = departmentDAO.getAllActiveDeparmentsHQl();
        assertEquals(2, allActiveDeparmentsHQL.size());
    }

    @Test
    void getAllActiveDeparmentsHQlNegative() {
        DepartmentDAO departmentDAO = new DepartmentDAO(session);
        WorkerExamples.createFewWorkers(session);
        List<Department> allActiveDeparmentsHQL = departmentDAO.getAllActiveDeparmentsHQl();
        assertNotEquals(true, allActiveDeparmentsHQL.size()!=2);
    }





}