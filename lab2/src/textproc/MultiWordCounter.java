package textproc;

import java.util.HashMap;
import java.util.Map;

public class MultiWordCounter implements TextProcessor{


    private Map<String, Integer> map = new HashMap<String, Integer>();


    public MultiWordCounter(String[] a){
        for(String b : a){
            this.map.put(b, 0);
        }
    }

    public void process(String w){
        
        for(String key : map.keySet()){
            int nbr = map.get(key);
            if(key.equals(w)){
                map.replace(key, nbr += 1);
            }

        }

    }

    public void report(){

        for(String key : map.keySet()){
            System.out.println(key + " Förekommer: " +  map.get(key)+ " Gånger");
        }

    }
    
}
