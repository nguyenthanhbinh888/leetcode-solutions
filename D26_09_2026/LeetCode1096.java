package D26_09_2026;

import java.util.*;

public class LeetCode1096 {

    static String s;
    static int index;

    public static List<String> braceExpansionII(String expression) {
        s = expression;
        index = 0;

        Set<String> result = parseExpression();

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    // Xử lý phép OR: a,b
    private static Set<String> parseExpression() {
        Set<String> result = parseTerm();

        while (index < s.length() && s.charAt(index) == ',') {
            index++;

            Set<String> next = parseTerm();

            result.addAll(next);
        }

        return result;
    }

    // Xử lý phép nối: ab, {a,b}c,...
    private static Set<String> parseTerm() {
        Set<String> result = new HashSet<>();
        result.add("");

        while (index < s.length()
                && s.charAt(index) != '}'
                && s.charAt(index) != ',') {

            Set<String> next = parseFactor();

            Set<String> temp = new HashSet<>();

            for (String a : result) {
                for (String b : next) {
                    temp.add(a + b);
                }
            }

            result = temp;
        }

        return result;
    }

    // Xử lý chữ cái hoặc {...}
    private static Set<String> parseFactor() {
        Set<String> result = new HashSet<>();

        if (s.charAt(index) == '{') {
            index++; // bỏ {

            result = parseExpression();

            index++; // bỏ }
        } else {
            result.add(String.valueOf(s.charAt(index)));
            index++;
        }

        return result;
    }

    public static void main(String[] args) {

        String expression = "{a,b}{c,{d,e}}";

        List<String> result = braceExpansionII(expression);

        System.out.println(result);
    }
}