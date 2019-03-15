package entity;

import DAO.DepartmentDAO;
import DAO.WorkersDAO;
import entity.enums.Availability;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.List;


public class Main {

    public static void main(String[] args) {

//        Department department = new Department().builder()
//                .name("ASD")
//                .status(true)
//                .build();
//        Workers workers = new Workers().builder()
//                .age(100)
//                .availability(Availability.FULL_TIME)
//                .departmentId(department)
//                .fullName("ASD")
//                .build();

        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        DepartmentDAO departmentDAO = new DepartmentDAO(session);
        WorkersDAO workersDAO = new WorkersDAO(session);


//        departmentDAO.save(department);
//        workersDAO.save(workers);

//        departmentDAO.deleteById(3);
////
//        System.out.println(workersDAO.findAll());
//        System.out.println(departmentDAO.findAll());

//        System.out.println(workersDAO.getWorkersByDepartmentIdAndAvailabilityHQL(3,Availability.PART_TIME));
//        System.out.println(workersDAO.getWorkersByDepartmentIdAndAvailabilityJPA(3, Availability.PART_TIME));

//        System.out.println(departmentDAO.getAllActiveDeparmentsJPA());
        session.getTransaction().commit();
        HibernateUtils.closeConnection();


    }
}
