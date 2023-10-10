import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n1,n2,n3,n4,n5;
       n1=sc.nextInt();
       n2=sc.nextInt();
       n3=sc.nextInt();
       n4=sc.nextInt();
       n5=sc.nextInt();
       
       Prime ob=new Prime();
        ob.checkPrime(n1);
        ob.checkPrime(n1,n2);
        ob.checkPrime(n1,n2,n3);
        ob.checkPrime(n1,n2,n3,n4,n5);    
    }
}

class Prime{
    public void checkPrime(int... arr){
        //to iterate arr
        for(int i=0;i<arr.length;i++){
            boolean f=true;
         //to check arr element is prime or not
            if(arr[i]<2){
             f=false;
             continue;
            }
            else
            {
                for(int j=2;j<arr[i];j++){
                    if(arr[i]%j==0){
                        f=false;
                        break;
                    }
                }
            }
            
         if(f){
             System.out.print(arr[i]+" ");
         }
        }
         System.out.println();            
    }
}
