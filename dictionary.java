import java.util.*;
import java.io.File;
public class Dictionary {
    public static void main(String args[]) throws Exception{
        HashMap<String, String> dataSet = new HashMap<String, String>();
        File file = new File(args[0]); 
        Scanner scan = new Scanner(file); 
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if (line == "") continue;
            line=line.replaceAll("\"", "");
            String[] parts = line.split(" ", 2);
            int len = parts.length;
            String value = dataSet.get(parts[0]);
            if (value == null && len >1)  {
                dataSet.put(parts[0], parts[1]);
            } else if (value != null && len >1) {
                value += parts[1];
                dataSet.replace(parts[0], value);
            }
        }
        
        scan.close();
        switch (args[1]){
            case "find":{
                // finds a word
                String target = args[2];
                String value = dataSet.get(target);  
                System.out.println(value);
                break;
            }
            case "edit":{
                // implement edit 
                String target = args[2];
                String value = dataSet.get(target);
                System.out.println("Old Definition: "+ value);
                Scanner n = new Scanner(System.in);
                String s = n.nextLine();
                dataSet.replace(target, value, s);
                n.close();
                break;
            }
            case "list":{
                // lists all the words and their meanings. 
                dataSet.forEach((key,value) -> System.out.println(key + " = " + value));
                break;
            }

        }
    }
    
}
