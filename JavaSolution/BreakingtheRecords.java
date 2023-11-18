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
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
        int size=scores.size();
        int min=scores.get(0);
        int max=scores.get(0);
        int min_count=0;
        int max_count=0;

        List<Integer> myList = new ArrayList<>();

        for(int i=1;i<size;i++)
        {
            if(scores.get(i)<min)
            {
                min=scores.get(i);
                min_count++;
            }
            else if(scores.get(i)>max)
            {
                max=scores.get(i);
                max_count++;
            }

            else if(scores.get(i)==min && scores.get(i)==max)
            {
                min_count+=0;
                max_count+=0;

            }
        }
        myList.add(max_count);
        myList.add(min_count);

        return myList;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
