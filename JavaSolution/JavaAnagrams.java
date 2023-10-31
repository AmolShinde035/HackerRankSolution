import java.io.*;
import java.util.*;

public class Solution {
        public static boolean IsAnagram(String s, String s1){
            boolean b=false;
            s=s.toLowerCase();
            s1=s1.toLowerCase();
            char[] chars=s.toCharArray();
            char[] chars1=s1.toCharArray();
            Arrays.sort(chars);
            Arrays.sort(chars1);
            b=Arrays.equals(chars,chars1);
            return b;
        }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc =new Scanner(System.in);
        String s=sc.next();
        String s1=sc.next();
        System.out.print(IsAnagram(s,s1)?"Anagrams":"Not Anagrams");
    }
}
