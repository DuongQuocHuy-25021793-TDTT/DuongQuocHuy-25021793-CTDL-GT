package week11;
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

class Result1 {

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Integer> freqArr = new HashMap<>();
        for (int x : arr) {
            freqArr.put(x, freqArr.getOrDefault(x, 0) + 1);
        }

        Map<Integer, Integer> freqBrr = new HashMap<>();
        for (int x : brr) {
            freqBrr.put(x, freqBrr.getOrDefault(x, 0) + 1);
        }

        Set<Integer> missing = new TreeSet<>();
        for (Map.Entry<Integer, Integer> entry : freqBrr.entrySet()) {
            int val = entry.getKey();
            int countBrr = entry.getValue();
            int countArr = freqArr.getOrDefault(val, 0);
            if (countBrr > countArr) {
                missing.add(val);
            }
        }

        return new ArrayList<>(missing);
    }

}

class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result1.missingNumbers(arr, brr);

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