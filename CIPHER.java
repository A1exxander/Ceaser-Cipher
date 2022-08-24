import javax.swing.*;
import java.lang.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MainFrame extends JFrame{

    private String text;
    private int offset;

    private JLabel Ttext;
    private JTextField TFText;
    private JButton CIPHER;
    private JPanel MainFrame;
    private JLabel Toffset;
    private JTextField TBoffset;

    MainFrame(){

        setTitle("Ceaser Cipher");
        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(MainFrame);
        setVisible(true);

        CIPHER.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                text = TFText.getText();
                offset = Integer.parseInt(TBoffset.getText());
                encodeString();

            }
        });

    }
    
    public String encodeString(){
        
        char cyper = ' ';
        String encodedString = "";
        
        
           for (int i = 0; i < text.length(); i++) // Iterate thru the string array
           {
           
           cyper = text.charAt(i); // take letter in spot i

           if (cyper >= 97 && cyper <=122) // If chars ascii value matches the value of a lowercase char ( between 97 and 122 )
           cyper = (char)(((cyper - 97 + offset) % 26) + 97); //  If Cypher is above 26 ( how many letters are in the alphabet ) it will wrap around, starting at 0

           
           else if ( cyper >= 65 && cyper <=90 ) // If chars ascii value matches the ascii value of an uppercase char
           
           cyper = (char)(((cyper -65 + offset) % 26)+65); // Why subtract and add 65? The reason why is because 65 is the start of the uppercase alphabet, by subtracting 65 and moduling 26, 0 would be start of the alphabet. If you were to module without subtracting the 65, you would be moduling the 65 from the ascii value, not the actual alphabet
            // If you didnt subtract the 65 and say you moduled letter B, you would be moduling 67, which is outside the alphabet, we need to module a value from 0-26 and B is 2. Not doing this would result is a logical error. Your remainder would be 5, not 2   
      
           encodedString = encodedString.concat("" + cyper); // Concats a string to encodedString. Takes whatevers stored in encodedString and adds Cyper to the end of it each loop. If you wanted to concat a hardcoded string each line, you could put it inside the ""
           
           }
       
       return encodedString;
       
       }

    private void printText() {

        if (text == null) {
            return;
        }

        else {           
            JOptionPane.showMessageDialog(null, encodeString());
        }
    }
    public static void main(String[] args){

        MainFrame MF = new MainFrame();

    }

}
