package core.service;

import core.dao.NumberDao;
import core.entity.CoNumber;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;


@Stateless
@LocalBean
public  class NumberService {
    @EJB
    NumberDao numberDao;

    public List<CoNumber> findAll(){
        return numberDao.findAll();
    }


    public double Calculator(){
        List<CoNumber> all =findAll();
        double unit =0;
        double numbers=0;

        for (CoNumber number :all){
            numbers=numbers+number.getNumber();
            unit=unit+number.getUnit();
        }

         double avg = numbers/unit;
        return avg;
    }
}
