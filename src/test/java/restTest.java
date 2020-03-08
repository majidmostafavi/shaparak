
import com.fasterxml.jackson.core.JsonProcessingException;
import core.entity.CoTransaction;
import core.utils.RESTfulClientUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jpos.util.TPS;

import java.util.ArrayList;
import java.util.List;


public class restTest {

    public static void main(String[] args) {


    try {
        List<Integer> longList = new ArrayList<>();
        for (int i=0 ;i<=1000000;i++) {
            longList.add(i);
        }
        longList.parallelStream().forEach(integer -> {
            CoTransaction transaction = new CoTransaction();
            transaction.setSender("majid");
            transaction.setReceiver("rihana");
            transaction.setAmount(integer);
            String test2 = "";
            try {
                test2 = RESTfulClientUtil.restFullService("http://localhost:8080/shaparak/request", "/movementRequest", new ObjectMapper().writeValueAsString(transaction));
            } catch (JsonProcessingException e) {
                System.out.println(">>> " + integer);
            }

            System.out.println(">>> " + test2);
        });
//            System.out.println(">>> " + test2);
    } catch (Exception e) {
        e.printStackTrace();
    }

    }

}
