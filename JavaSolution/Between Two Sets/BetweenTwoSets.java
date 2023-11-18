import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
         int lcmA = listLcm(a);
        int upper = Collections.min(b);
        if(lcmA<=0){
            return 0;
        }
        if(lcmA>upper){
            return 0;
        }
        int count=0;
        for(int i=lcmA;i<=upper;i++){
            if(aCompat(i, a) && bCompat(i, b)){
                count++;
            }
        }
        
        return count;
    }
    
    static int gcd(int a, int b){
         if (b == 0)
        return a;
    return gcd(b, a % b);
//         int temp=y;
//         if(x<y){
//             y=x;
//             x=temp;
//         }
        
//         while(y!=0){
//             temp=y;
//             if(y==0)
//                 return x;
//             y=x%y;
//             x=temp;
//         }
//         return x;
    }
    
    static int lcm(int x, int y){
        return (x*y)/gcd(x,y);
    }
    
    static int listLcm(List<Integer> a){
        int result=1;
        for(int i=0;i<a.size();i++){
            result = lcm(result, a.get(i));
        }
        return result;
    }
    
    public static boolean aCompat(int num, List<Integer> a){
        for(int i=0;i<a.size();i++){
            if(num%a.get(i)!=0){
                return false;
            }
        }
        return true;
    }
    
    public static boolean bCompat(int num, List<Integer> b){
        for(int i=0;i<b.size();i++){
            if(b.get(i)%num!=0){
                return false;
            }
        }
        return true;
    

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
