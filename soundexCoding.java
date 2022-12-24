// This is NARA VARIANT version of soundex!
/* $Title: Soundex Coding;      $Author: Jina Pak;
   $Course/Section - CPSC1150-3;        $St.# - 100377523;
*/
import java.util.Scanner;
/**
 * This class is to generate codes of a phonetic index from English names. 
 */
public class soundexCoding {
    
    public static void main(String[] args){
      
        youWantToStartOrStop();
        
    }
    /**
     This method asks whether a user wants to start the program or stop the program. 
     It will ask a user to type a valid input if a user types an invaild input. 
     */
    private static void youWantToStartOrStop()
    {
        Scanner keyboard = new Scanner(System.in);
        final char EXIT = 'E';
        final char START = 'S';
    
        char answer;

        System.out.println("Hello there, if you want to start this program, please type 'S', otherwise, if you want to exit this program, please type 'E'.");
        answer = keyboard.next().toUpperCase().charAt(0);
  
        while (answer == 'S'){
            askingNames();
            System.out.println("Want to start again? Type 'S' if you want to play the program again, or type 'E' to exit the program.");
            answer = keyboard.next().toUpperCase().charAt(0);

        }

        while (answer != 'S' && answer != 'E')
        {
            System.out.println("Only 'S' and 'E' work in this program, type either 'S' or 'E'. ('S'tart / 'E'xit) ");
            answer = keyboard.next().toUpperCase().charAt(0);

            while (answer == 'S'){
                
                askingNames();
                System.out.println("Want to start again? Type 'S' if you want to play the program again, or type 'E' to exit the program.");
                answer = keyboard.next().toUpperCase().charAt(0);
    
            }
        }


        System.out.println("Thank you for using Soundex program.");
        

    }

    /**
     * This method "askingNames" get two different(including same spelled) names respectively.
     * <p>
     * Also, it contains other methods to generate soundex codes. </p>
     */
    private static void askingNames(){

        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the first name you want to compare to the second name. A name should be longer than 3 letters. "); 
        String firstName = keyboard.nextLine().toLowerCase();
        System.out.println("Enter the second name you want to compare to the first name. A name should be longer than 3 letters. ");
        String secondName = keyboard.nextLine().toLowerCase();
        
        convertName(firstName);
        convertName(secondName);

        String firstResult = convertName(firstName);
        String secondResult = convertName(secondName);

        if (firstResult.equals(secondResult)){
            System.out.println("Those two names " + firstName + " " + firstResult + " and " + secondName + " " + secondResult + " sound same.");
        }

        else
            System.out.println("Those two names " + firstName + " " + firstResult + " and " + secondName + " " + secondResult + " don't sound same.");

        
    }  
    
    /**
     * This method, convertName has several other methods to yield an intended input.
     * @param name gets a user input(a name) in this case in the upper level method, "askingNames".
     * @return the soundex of the user input.
     */
    private static String convertName(String name){
       
        getFirstLetter(name);
        
        editName(name);

        overwriteLetter(name);

        naraVariant(overwriteLetter(name));
        
        removeNine(name);

        return trunOrConcat(name);

    }

    

    /**
     * Here is a part that has several methods and modify numbers along the criteria for the number. 
     * @param name gets the string from the "askingNames" 
     * @return gives us a modified number(string)
     */
    private static String editName(String name){
        
        
        
        getNumber(name);
        
        
        return removeDoubledLetter(removeInitialDuplicates(getNumber(name)));
    }

    /**
     * This method gets a parameter and only leaves the first english letter of it.
     * @param name is the same parameter like other methods
     * @return gives the first letter of a parameter.
     */

    private static char getFirstLetter(String name){
        
        char fLetter = name.toUpperCase().charAt(0);
        
        
        //System.out.println(fLetter);
        return fLetter;
    
    }

    /**
     * In this method, each letter of a string(a parameter) becomes an indicator of the pre-assigned value, and the result will be saved in the variable, "resultNum".
     * @param name is the same parameter. I'll omit the description about all parameters below since whenever a method gets a parameter, the value of the parameter will always be the same value 
     * @return gives a value of "resultNum" a result of the transition from letter to numbers
     */
    private static String getNumber(String name){
        final int zero = 0;
        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        final int nine = 9;
        int index = 0;
        String resultNum = "";
         

        while (index < name.length()){
            if (name.charAt(index) == 'a'||name.charAt(index) == 'e'||name.charAt(index) == 'i'||name.charAt(index) == 'o'||name.charAt(index) == 'u'||name.charAt(index) == 'y')
            {
                resultNum += zero;
            }

            else if (name.charAt(index) == 'b'||name.charAt(index) == 'p'||name.charAt(index) == 'f'||name.charAt(index) == 'v'){
                resultNum += one;
            }

            else if (name.charAt(index) == 'c'||name.charAt(index) == 's'||name.charAt(index) == 'k'||name.charAt(index) == 'g'||name.charAt(index) == 'j'||name.charAt(index) == 'q'||name.charAt(index) == 'x'||name.charAt(index) == 'z'){
                resultNum += two;
            }

            else if (name.charAt(index) == 'd'||name.charAt(index) == 't'){
                resultNum += three;
            }

            else if (name.charAt(index) == 'l')
            {
                resultNum += four;
            }

            else if (name.charAt(index) == 'm'||name.charAt(index) == 'n')
            {
                resultNum += five;
            }

            else if (name.charAt(index) == 'r'){
                resultNum += six;
            }

            else {
                resultNum += nine;
            }

            index ++;


            
        }
        //System.out.println(resultNum);
        return resultNum;
    }

 
    /**
     * This method edit a initial part of the string. When first three characters are the same, those charcters will be deleted except the very first one. 
     * @param convertedNum
     * @return
     */

    private static String removeInitialDuplicates(String convertedNum)
    {
        if (convertedNum.charAt(0) == convertedNum.charAt(1)){
            
            convertedNum = convertedNum.charAt(0) + convertedNum.substring(2);

            if (convertedNum.charAt(0) == convertedNum.charAt(1)){

                convertedNum = convertedNum.charAt(0) + convertedNum.substring(2);

            }
        }

        

        //System.out.println(convertedNum);
        return convertedNum;
    }

    /**
     * If the same number characters exist and if it is a production of multiplication of 2, the first character will be deleted.
     * @param truncatedName
     * @return gives a edited result without any repeated digits. 
     */

    private static String removeDoubledLetter(String truncatedName){
        
        int index = 0;
        String forConvenience = truncatedName;
    
        while (index < forConvenience.length()-1){
            if (forConvenience.charAt(index) == forConvenience.charAt(index+1)){
                 
                forConvenience = forConvenience.substring(0, index) + forConvenience.substring(index+1);
                //System.out.println(forConvenience);
                index--;
                
            }

           

            index ++;
        }

        return forConvenience;
    }

    /**
     * This method will overwrite the first letter saved earlier of this program on the edited number string from a method "editName".
     * Also, it moves all zeros from the string.
     * @param name
     * @return a form : ex) A23839
     */

    private static String overwriteLetter(String name){

        
        char initial = getFirstLetter(name);
        String editedNum = editName(name);
       

        String result = Character.toString(initial) + editedNum.substring(1).replaceAll("0", "");
        //System.out.println(result);
        


        return result;
    }

    /**
     * In this method, NARA variant rule will be applied.
     * @param name
     * @return NARA variant version of a soundex code.
     */
    private static String naraVariant(String name){

        String variation = name;
        int index = 0;
       

        while (index < variation.length()-1){
            if (variation.charAt(index) == '9'){
                if (variation.charAt(index-1) == variation.charAt(index+1)){
                    variation = variation.substring(0, index) + variation.substring(index+2);
                    index --;
                }
            }

            index++;
        }


        return variation;
    }

    /**
     * This method removes all nine from a string.
     * @param name
     * @return a fined value without 9
     */
    private static String removeNine(String name){

        String withoutNine = naraVariant(overwriteLetter(name)).replaceAll("9", "");

        return withoutNine;
    }

    /**
     * A string processed all previous steps(methods) will be truncated or concatenated to become 4 characters in total.
     * @param name
     * @return 4-character soundex
     */

    private static String trunOrConcat(String name){
        
        String finale = removeNine(name);
        //System.out.println("here is that " + finale);
        String result = "";
        if (finale.length() <= 4){

            int zeroNum = 4 - finale.length();
            while (zeroNum > 0){
                
                finale += "0";
                zeroNum--;
            } 
            
            result = finale;
            //System.out.println("look at this " + result);

        }

        
        else
        {

            result = finale.substring(0, 4);
            //System.out.println("look at this else loop's " + result);
            
        }

        //System.out.println(result);
        
        return result;
    }


}
