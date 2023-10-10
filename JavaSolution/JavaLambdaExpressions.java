import java.io.*;
import java.util.*;
interface PerformOperation {
 boolean check(int a);
}
class MyMath {
 public static boolean checker(PerformOperation p, int num) {
  return p.check(num);
 }

   PerformOperation isOdd(){
       return x->x%2!=0;
   }
    PerformOperation isPrime() { 
    return n ->  
        {
            boolean flag= true;
            for(int i=2;i*i<=n;i++)
            {
                if(n%i==0){
                    flag=false;
                    break;
                }
            }
         return flag;
        };
    }
   
    PerformOperation isPalindrome(){
       return x->{
        int n=x;
        int rev=0;
        while(n>0){
            int rem=n%10;
            rev=rev*10+rem;
            n/=10;
        }
        if(x==rev)
         return true;
        else 
            return false;
        
       };
   }
}
public class Solution {

 public static void main(String[] args) throws IOException {
  MyMath ob = new MyMath();
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int T = Integer.parseInt(br.readLine());
  PerformOperation op;
  boolean ret = false;
  String ans = null;
  while (T--> 0) {
   String s = br.readLine().trim();
   StringTokenizer st = new StringTokenizer(s);
   int ch = Integer.parseInt(st.nextToken());
   int num = Integer.parseInt(st.nextToken());
   if (ch == 1) {
    op = ob.isOdd();
    ret = ob.checker(op, num);
    ans = (ret) ? "ODD" : "EVEN";
   } else if (ch == 2) {
    op = ob.isPrime();
    ret = ob.checker(op, num);
    ans = (ret) ? "PRIME" : "COMPOSITE";
   } else if (ch == 3) {
    op = ob.isPalindrome();
    ret = ob.checker(op, num);
    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

   }
   System.out.println(ans);
  }
 }
}
