package Hot100.Easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidBracket20 {
    public boolean isValid(String s) {
/*        int Left = 0,Right = 0;
        if (s.length() % 2 == 1) {
            return false;
        }
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                Left ++;
            } else {
                Right ++;
            }
        }
        if (Left != Right) {
            return false;
        }
        else {*/
        Deque<Character> Stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
            try {
                for (int i = 0; i < chars.length; i++) {

                    if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                        Stack.addLast(chars[i]);
                    } else {
                        if (chars[i] == ')') {
                            if (!(Stack.removeLast() == '(')) {
                                return false;
                            }
                        }
                        if (chars[i] == '}') {
                            if (!(Stack.removeLast() == '{')) {
                                return false;
                            }
                        }
                        if (chars[i] == ']') {
                            if (!(Stack.removeLast() == '[')) {
                                return false;
                            }
                        }
                    }
                }
            }
            catch (Exception e) {
                return false;
            }
        //}
        return Stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidBracket20().isValid("()[]{}"));
    }
}
