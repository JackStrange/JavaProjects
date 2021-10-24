import java.util.ArrayList;
import java.util.Arrays;

public class radix{

    public static void main(String[] args){
        ArrayList<String> sorted_array = radix10(args);
        printArrayList(sorted_array);
    }

    public static ArrayList<String> radix10(String[] nums){
        // Creating 10 buckets for radix base-10 sort
        ArrayList<ArrayList<String>> bucket = new ArrayList<ArrayList<String>>();
        for(int i=0; i<10; i++){
            bucket.add(new ArrayList<String>());
        }

        // Getting the maximum number size
        int max_len = 0;
        
        for(String num:nums){
            if(num.length() > max_len){
                max_len = num.length();
            }
        }

        // Converting the argument string into an ArrayList for easier modification
        ArrayList<String> array = new ArrayList<String>(Arrays.asList(nums));
        printArrayList(array);

        // Perform the following algorithm for every digit, right to left=
        for(int i = 0; i < max_len; i++){
            for(String num:array){
                // The digit's default is 0
                int currentDigit = 0;
                if (num.length() > i){
                    currentDigit = Integer.parseInt(Character.toString(num.charAt(num.length()-i-1)));
                }

                // Put the num in its corresponding bucket
                bucket.get(currentDigit).add(num);
            }

            // Join all the buckets together into the array and repeat
            array.clear();
            for(int b=0; b<10; b++){
                array.addAll(bucket.get(b));
                bucket.get(b).clear();
            }
        }

        return array;

    }

    public static void printArrayList(ArrayList<String> array){
        System.out.print("{ ");
        for(String item:array){
            System.out.print(item);
            if(array.indexOf(item) < array.size() -1){
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }
}