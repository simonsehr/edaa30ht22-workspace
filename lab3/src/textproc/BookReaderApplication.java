package textproc;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BookReaderApplication {

    public static void main(String[] args) throws FileNotFoundException {
  
    Scanner s = new Scanner(new File("./lab2/nilsholg.txt"), "UTF-8");
    s.findWithinHorizon("\uFEFF", 1);
    s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

    Scanner sw = new Scanner(new File("./lab2/undantagsord.txt"), "UTF-8");
    sw.useDelimiter(" "); 
    

    Set<String> words = new HashSet<String>();

    while(sw.hasNext()){
        String word = sw.next().toLowerCase();
        words.add(word);
    }

    BookReaderController bc = new BookReaderController(null);

}
}
