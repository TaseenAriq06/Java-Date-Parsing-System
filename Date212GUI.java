import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.TreeMap;

public class Date212GUI extends JFrame {    // GUI extends JFrame so that the GUI can become a window 
    private JTextArea leftArea;             // shows unsorted dates on the left
    private JTextArea rightArea;            // show sorted dates on the right 

    public Date212GUI(){                    // constructor sets up the window layout, size, and menu bar
        super("Date212 Display");    // call JFrame constructor to make a title 
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(1,2));

        leftArea = new JTextArea();
        rightArea = new JTextArea();
        leftArea.setEditable(false);
        rightArea.setEditable(false);

        add(new JScrollPane(leftArea));
        add(new JScrollPane(rightArea));

        createMenuBar();                    // build the menu bar to hold items like Open, Quit, and File
        setVisible(true);
    }
    public void createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem quitItem = new JMenuItem("Quit");

        openItem.addActionListener(new ActionListener() {       // Open uses FileChooser to look through your files and processes in Project 3 file
            public void actionPerformed(ActionEvent e){
                JFileChooser chooser = new JFileChooser();
                int result = chooser.showOpenDialog(Date212GUI.this);

                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = chooser.getSelectedFile();

                    Project4.processFile(selectedFile.getPath(), Date212GUI.this);  // Project3 file handles and validates if it can be used and sorted in the GUI window
                }
            }
        });
        quitItem.addActionListener(new ActionListener(){        // terminate the program when clicking 'Quit'
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        fileMenu.add(openItem);
        fileMenu.add(quitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }
    // display the unsorted lists on the left, and the treemap sorted dates on the right
    public void displayLists(UnsortedDate212List unsortedList, TreeMap<Date212, Object> sortedMap) {
        leftArea.setText("");       
        rightArea.setText("");

        leftArea.append("Unsorted List:\n\n");
        rightArea.append("Sorted List (TreeMap):\n\n");

        leftArea.append(unsortedList.toString());       // display the unsorted dates (original order)

        Object[] arr = sortedMap.keySet().toArray();    // sorted unique dates that are valid into sorted dates using TreeMap keys
        for (int i = 0; i < arr.length; i++) {
            Date212 d = (Date212) arr[i];
            rightArea.append(d.toString() + "\n");
        }
    }
    public static JFrame initialize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }
    public static void printDatesToJFrame(JFrame jf, UnsortedDate212List unsortedList, SortedDate212List sortedList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printDatesToJFrame'");
    }
}
