package DAO;

import entity.Workers;
import entity.enums.Availability;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class WorkersDAO implements DAO<Workers,Integer> {
    private static Logger log = LogManager.getLogger(WorkersDAO.class);

    private Session session;

    public WorkersDAO(Session session) {
        this.session = session;
    }

    @Override
    public Workers save(Workers entity) {
        session.saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void deleteById(Integer integer) {
        session.delete(session.load(Workers.class,integer));
    }

    @Override
    public Workers findById(Integer integer) {
        return session.load(Workers.class,integer);
    }

    @Override
    public List<Workers> findAll() {
        return session.createQuery("from Workers ").list();
    }

    public List<Workers> getWorkersByDepartmentIdAndAvailabilityHQL(Integer id, Availability availability){
        Query query = session
                .createQuery("from Workers as w where w.departmentId.idDepartment=:departmentId " +
                        "and w.availability = :availability");
        query.setParameter("departmentId",id);
        query.setParameter("availability",availability);
        return query.list();
    }

    public List<Workers> getWorkersByDepartmentIdAndAvailabilityJPA(Integer id, Availability availability){
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Workers> query = criteriaBuilder.createQuery(Workers.class);
        Root<Workers> root = query.from(Workers.class);
        query.select(root);
        query.where(
                criteriaBuilder.equal(root.get("departmentId"),id),
                criteriaBuilder.equal(root.get("availability"),availability)
        );
        return session.createQuery(query).getResultList();
    }

    public void deleteAll(){
        session.createQuery("delete from Workers ");
    }

}
