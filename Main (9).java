import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map.Entry;

class Main {
    public static void main(String[] args) {

        HashMap<String, Integer> token = new HashMap<String,Integer>();
        token.put("+",1);
        token.put("-",2);
        token.put("*",3);
        token.put("/",4);
        token.put("%",5);
        token.put("(",6);
        token.put(")",7);
        token.put(":=",8);
        token.put("=",9);
        token.put("<",10);
        token.put(">",11);
        token.put("<=",12);
        token.put(">=",13);
        token.put("&",14);
        token.put("|",15);
        // name.put("IDENT",16); 
        // name.put("INT_LIT",17);
        // name.put("FP_LIT",18);
HashMap<String, Integer> name = new HashMap<String,Integer>();
        name.put("ADD_OP",1);
        name.put("SUB_OP",2);
        name.put("MULT_OP",3);
        name.put("DIV_OP",4);
        name.put("MODULO",5);
        name.put("LEFT_PAREN",6);
        name.put("RIGHT_PAREN",7);
        name.put("ASSIGN_OP",8);
        name.put("EQUAL",9);
        name.put("LESS_THAN",10);
        name.put("GREATER_THAN",11);
        name.put("LESS_EQUAL",12);
        name.put("GREATER_EQUAL",13);
        name.put("LOGICAL_AND",14);
        name.put("LOGICAL_OR",15);
         name.put("IDENT",16); 
        name.put("INT_LIT",17);
        name.put("FP_LIT",18);
        
        LinkedList<Integer> list = new LinkedList<Integer>();
     
        File file=new File("file.txt");     //Creation of File Descriptor for input file
      
 try {
      Scanner scanner = new Scanner(file).useDelimiter(" ");;
            while (scanner.hasNextLine()) {
                String string = scanner.next();
                 if(token.containsKey(string)){
                 list.addLast(token.get(string)); 
                }else{
                    if (isIdentifier(string)){
                        list.addLast(16);
                    }else if (isIntegerLiteral(string)){
                        list.addLast(17);
                    }else if(isFloatingPointLiteral(string)){
                        list.addLast(18);
                    }
                }}
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // String theName=" ";
      for (Integer tokenNum : list) {
          if (name.containsValue(tokenNum)){
              
               System.out.println(getKey(name,tokenNum) + " => "+ tokenNum);
          }
   
}

    }
    public static String getKey( HashMap<String, Integer> name, Integer tokenNum ) {
        String theKey="";
  for(Entry<String, Integer> entry: name.entrySet()) {

      if(entry.getValue() == tokenNum) {
       theKey= entry.getKey();
}
  }
        return theKey;
    }

public static boolean isIntegerLiteral(String number) {
      String numberRegex = "[0-9]|[1-9][0-9]*|[0-7]+|(0[xX][0-9a-fA-F]+)(i64|I64|u|U|l|L)?";
      Pattern pattern = Pattern.compile(numberRegex);
      Matcher matcher = pattern.matcher(number);
      return matcher.matches();
  }

public static boolean isFloatingPointLiteral(String number) {
    String numberRegex = "[+-]?([0-9]*.[0-9]+|[0-9]+.)([eE][+-]?[0-9]+)?[LlFf]?|[+-]?[0-9]+[Ee][+-]?[0-9]+[LlFf]?";
    Pattern pattern = Pattern.compile(numberRegex);
    Matcher matcher = pattern.matcher(number);
    return matcher.matches();
}
public static boolean isIdentifier(String number) {
    String numberRegex = "[_]?([a-zA-Z]+[_]?[a-zA-Z]*)";
    Pattern pattern = Pattern.compile(numberRegex);
    Matcher matcher = pattern.matcher(number);
    return matcher.matches();
}
}
