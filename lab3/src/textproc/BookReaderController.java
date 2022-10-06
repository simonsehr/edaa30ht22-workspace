package textproc;
import java.awt.*;
import javax.swing.*;
import java.util.Map.Entry;
import java.awt.event.*;  



public class BookReaderController {

    JRadioButton b1, b2;
    JButton b;


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


        //Knappar
        b1 = new JRadioButton("Alphabetic");
        b2 = new JRadioButton("Frequency");
        ButtonGroup group = new ButtonGroup();
        group.add(b1);
        group.add(b2);

        b1.addActionListener(e -> listModel.sort(
            (x, y) -> ((Entry<String, Integer>) x).getKey().compareTo(((Entry<String, Integer>) y).getKey())));
        b2.addActionListener(e -> listModel
            .sort((x, y) -> -(((Entry<String, Integer>) x).getValue() - ((Entry<String, Integer>) y).getValue()))); 


        JPanel panel = new JPanel();
        JButton Exit = new JButton("Exit");

        //Lägger till knappar i panelen
        panel.add(b1);
        panel.add(b2);

        b1.addActionListener( (n) -> { System.out.println("Alphabetical"); } );
        b2.addActionListener( (n) -> { System.out.println("Frequency"); } );

        //Sökfält och sökfältsknapp
        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Search");
        panel.add(searchField);
        panel.add(searchButton);



        pane.add(scrollPane, BorderLayout.NORTH);
        pane.add(panel, BorderLayout.CENTER);

        //program exit-knapp
        panel.add(Exit);

        //Stänger systemet vid tryck av exitknapp
        Exit.addActionListener((n) -> { System.exit(0); });
 

        frame.pack();
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){    
        if(b1.isSelected()){    
        System.out.println("Alphabetic");        
        }    
        if(b2.isSelected()){    
        System.out.println("Frequency");    
        }    
        }  

}
