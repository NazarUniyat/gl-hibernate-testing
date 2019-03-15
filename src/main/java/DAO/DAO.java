package DAO;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public interface DAO<T,ID extends Serializable> {

    T save (T entity);
    void deleteById(ID id);
    T findById(ID id);
    List<T> findAll();
}
