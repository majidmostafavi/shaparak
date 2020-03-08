package core.utils;


/**
 * Created by majid on 5/29/17.
 */

public interface Enumable {
    String getKey();
    String getLabel();
     default int getOrdinal(String s){
         return 0;
     }
}
