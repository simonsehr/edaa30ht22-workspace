package textproc;
import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.*;



public class BookReaderController {


    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 1000, 500));
    }

    private void createWindow(GeneralWordCounter counter, String title, int width, int height) {


        SortedListModel listModel = new SortedListModel(counter.getWordList());
        JList<SortedListModel> myList = new JList<SortedListModel>(listModel);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();



        JScrollPane scrollPane = new JScrollPane(myList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //scrollPane.setPreferredSize(new Dimension(width, height));

        //JRadioButton sortAlphabetical = new JRadioButton("Alphabetically sorted");
        //JRadioButton sortFrequency = new JRadioButton("Frequency sorted");

        JPanel panel = new JPanel();
        JButton Alphabetical = new JButton();
        panel.add(Alphabetical);
        


        pane.add(scrollPane, BorderLayout.NORTH);
        pane.add(panel, BorderLayout.CENTER);
 


        frame.pack();
        frame.setVisible(true);




    }
}
