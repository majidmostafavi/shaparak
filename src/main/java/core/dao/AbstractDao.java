package core.dao;

import core.entity.BaseEntity;
import core.utils.exception.SaveRecordException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T extends BaseEntity> {

    @PersistenceContext(unitName = "spsds")
    protected EntityManager em;

    public T update(T entity) {
        try {
            return em.merge(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean delete(T entity) {
        try {
            em.remove(em.merge(entity));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public T create(T entity) throws SaveRecordException {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception e) {
            new SaveRecordException();
        }
        return null;
    }

    public T find(T entity, Object primaryKey) {
        try {
            return (T) em.find(entity.getClass(), primaryKey);
        } catch (Exception e) {
            return null;
        }
    }

    public long maximumId(String query, boolean isNamedQuery) {
        try {
            return ((long) (isNamedQuery ? em.createNamedQuery(query).getSingleResult()
                    : em.createQuery(query).getSingleResult())) + 1;
        } catch (Exception e) {
            return 1;
        }
    }

    public List<T> findAll(String query, boolean isNamedQuery) {
        try {
            return isNamedQuery ? em.createNamedQuery(query).getResultList()
                    : em.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Object findGeneral(Class clazz, Serializable id){
        return em.find(clazz, id);
    }
}