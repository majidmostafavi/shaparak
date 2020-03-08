package core.dao;

import core.entity.CoNumber;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class NumberDao extends AbstractDao<CoNumber> {


    public List<CoNumber> findAll() {
        return em.createNamedQuery("findAllNumber.list").getResultList();

    }
}
