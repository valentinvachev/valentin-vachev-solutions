package Solutions;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(solution(input));
    }

    public static boolean solution(String input) {
        Map<Character, Character> bracketsPairsReversed = new HashMap<>() {{
            put('}', '{');
            put(')', '(');
            put(']', '[');
        }};

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int index = 0; index < input.length(); index++) {
            char currentChar = input.charAt(index);

            if (currentChar == '{' || currentChar == '(' || currentChar == '[') {
                stack.push(currentChar);
            } else if (currentChar == '}' || currentChar == ']' || currentChar == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                char lastCharStack = stack.pop();

                if (bracketsPairsReversed.get(currentChar) != lastCharStack) {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }
}
