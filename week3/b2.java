package week3;
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

class b2 {

    public static String isBalanced(String s) {
        if (s == null || s.length() % 2 != 0) {
            return "NO";
        }
        Stack<Character> stack = new Stack<>();
        for ( char c : s.toCharArray()){
            if ( c == '(' ||  c == '{' || c == '[' ){
                stack.push(c);

            }
            else {
                if ( stack.isEmpty()){
                    return "NO";
                }
                char top = stack.pop();
                if (( c == ')' && top != '(') ||
                        ( c == '}' && top != '{') ||
                        ( c == ']' && top != '[')) {
                    return "NO";
                }
            }
        }
        if ( stack.isEmpty()){
            return "YES";
        }
        else {
            return "NO";
        }
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = b2.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
