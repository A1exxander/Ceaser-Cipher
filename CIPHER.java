import java.util.Scanner;

public class CIPHER

{
           public static void main(String[] args)     {
           
           Scanner KB = new Scanner(System.in);
           String text = "";  
           int offset = 0;
           
           text = inputString();
           offset = inputOffset();
                      
           System.out.println("Encoded String : " + encoder(text,offset));
                    
                    
       }
       
       public static String inputString()
       {
         Scanner KB = new Scanner(System.in);
         System.out.println("Enter a string you'd like to be encoded");
         String text = KB.nextLine();
         return text;
         //System.out.println("Now enter an offset "); // Beter in its own method!
         //offset = KB.nextInt();           
       }
       
       public static int inputOffset()
       {
         Scanner KB = new Scanner(System.in);
         System.out.println("Enter a string you'd like to be encoded");
         int offset = KB.nextInt();
         return offset;        
       }

       
       public static String encoder(String text, int offset)
       {
        
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
       
}
