package Examples;

import entity.Department;
import entity.Workers;
import entity.enums.Availability;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class WorkerExamples {


    public static void createFewWorkers(Session session){

        Department xxx = new Department().builder().name("XXX").status(true).build();
        Department yyy= new Department().builder().name("YYY").status(true).build();

        Workers johni_j = new Workers().builder()
                .age(11)
                .availability(Availability.PART_TIME)
                .fullName("Johni_J")
                .departmentId(xxx)
                .build();
        Workers johni_d = new Workers().builder()
                .age(12)
                .availability(Availability.PART_TIME)
                .fullName("Johni_D")
                .departmentId(xxx)
                .build();
        Workers johni_k = new Workers().builder()
                .age(13)
                .availability(Availability.FULL_TIME)
                .fullName("Johni_K")
                .departmentId(yyy)
                .build();

        session.beginTransaction();
        session.save(xxx);
        session.save(yyy);

        session.save(johni_d);
        session.save(johni_j);
        session.save(johni_k);
        session.getTransaction().commit();



    }
}
