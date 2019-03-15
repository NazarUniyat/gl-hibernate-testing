package DAO;

import entity.Department;
import entity.Workers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class DepartmentDAO implements DAO<Department,Integer> {

    private static Logger log = LogManager.getLogger(DepartmentDAO.class);

    private Session session;
    public DepartmentDAO(Session session) {
        this.session = session;
    }


    @Override
    public Department save(Department entity) {
        session.saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void deleteById(Integer integer) {
       session.delete(session.load(Department.class,integer));
    }

    @Override
    public Department findById(Integer integer) {
        return session.load(Department.class,integer);
    }

    @Override
    public List<Department> findAll() {
        return  session.createQuery("from Department ").list();
    }

    public List<Department> getAllActiveDeparmentsHQl(){
        return (List<Department>) session.
                createQuery("from Department where status = true").list();
    }


    public List<Department> getAllActiveDeparmentsJPA(){
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Department> query = criteriaBuilder.createQuery(Department.class);
        Root<Department> root = query.from(Department.class);
        query.select(root);
        query.where(
                criteriaBuilder.equal(root.get("status"),true)
        );
        return session.createQuery(query).getResultList();
    }

}
