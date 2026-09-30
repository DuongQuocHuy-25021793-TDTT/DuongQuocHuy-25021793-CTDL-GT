import java.util.Scanner;
import java.util.Stack;

public class W3_tailop_25021777 {


    private static int pref(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    private static boolean isRightAssociative(char ch) {
        return ch == '^';
    }

    public static String infixToPostfix(String e) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < e.length(); i++) {
            char c = e.charAt(i);

            if (Character.isWhitespace(c)) {
                continue;
            }

            if (Character.isLetterOrDigit(c)) {
                result.append(c).append(" ");
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            else {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    int p1 = pref(c);
                    int p2 = pref(stack.peek());

                    if (p2 > p1 || (p1 == p2 && !isRightAssociative(c))) {
                        result.append(stack.pop()).append(" ");
                    } else {
                        break;
                    }
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Biểu thức không hợp lệ !";
            }
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Infix: ");
        String infix = scanner.nextLine();

        String postfix = infixToPostfix(infix);

        System.out.println("Postfix: " + postfix);

        scanner.close();
    }
}