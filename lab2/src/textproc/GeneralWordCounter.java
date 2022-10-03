package textproc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GeneralWordCounter implements TextProcessor{

    private Map<String, Integer> map = new HashMap<String, Integer>();
    private Set<String> stopwords;


    public GeneralWordCounter(Set<String> stopwords){
        this.stopwords = stopwords;
    }


    public void process(String w){
        

    }

    public void report(){
        
    }


    
}
