package core.dao;

import core.entity.CoTransaction;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class TransactionDao extends AbstractDao<CoTransaction> {

}
