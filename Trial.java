import java.util.ArrayList;
import java.util.Collection;
class TrialClass{
    public static void main(String[] args) {
        // System.out.println("Hello git");
        // System.out.println("new");.

        ArrayList<String> i= new ArrayList<>();
        
        i.add("item1");
        i.add("item2");
        i.add("item3");
        
        String a [] = {"item1", "item2", "item3"};
        
        for (String item : i) {
            System.out.print(item + " ");
        }

        for (String item1 : a) {
            System.out.print(item1 + " ");
        }

        int integerArray[] = {5,2,2,0};
        System.out.println();
        int index =0 ;
        for (int integer : integerArray) {
            System.out.println(integer +  " " + index++);
           
        }
      
    }
}