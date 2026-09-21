package org.example.lab1;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CheckPairs {
    public static boolean isBalabce(String str){
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        for (int i = 0; i < str.length(); i++){
            char current = str.charAt(i);

            if (pairs.containsKey(current)) {
                if (stack.isEmpty()) {
                    return  false;
                }

                char top = stack.peek();

                if (top == pairs.get(current)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            else {
                stack.push(current);
            }
        }
        return stack.isEmpty();
    }
}
