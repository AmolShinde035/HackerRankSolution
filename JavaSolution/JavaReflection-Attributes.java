public class Solution {

        public static void main(String[] args){
        Student s1=new Student();
        Class c=s1.getClass();
        Method[] methods = c.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method s:methods){
            methodList.add(s.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
        }
/*only run in java 7*/
    }
