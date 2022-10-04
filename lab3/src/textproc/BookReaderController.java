package textproc;
import java.awt.*;
import javax.swing.*;
import java.util.Map.Entry;



public class BookReaderController {


    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 1000, 500));
    }

    private void createWindow(GeneralWordCounter counter, String title, int width, int height) {


        SortedListModel listModel = new SortedListModel(counter.getWordList());
        JList<SortedListModel> myList = new JList<SortedListModel>(listModel);
        //myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        JFrame frame = new JFrame(title);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();



        JScrollPane scrollPane = new JScrollPane(myList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(width, height));

        //JRadioButton sortAlphabetical = new JRadioButton("Alphabetically sorted");
        //JRadioButton sortFrequency = new JRadioButton("Frequency sorted");

        JPanel panel = new JPanel();
        JButton Alphabetical = new JButton("Alphabetic");
        JButton Frequency = new JButton("Frequency");

        Alphabetical.setSelected(true);
        
        panel.add(Alphabetical);
        panel.add(Frequency);








        


        pane.add(scrollPane, BorderLayout.NORTH);
        pane.add(panel, BorderLayout.CENTER);
 

        //frame.setSize(1000, 1000);
        frame.pack();
        frame.setVisible(true);




    }
}
