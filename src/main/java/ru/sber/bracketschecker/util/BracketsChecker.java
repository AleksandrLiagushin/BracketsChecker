package ru.sber.bracketschecker.util;

import java.util.HashMap;
import java.util.Map;

public class BracketsChecker {

    public static boolean isCorrect(String text) {
        int counter = 0;
        Map<Character, Character> brackets = Map.of(
                '(', ')',
                '[', ']',
                '{', '}'
        );
        Map<Integer, Map<Character, Boolean>> bracketsRow = new HashMap<>();

        for (char c : text.toCharArray()) {
            if (brackets.containsValue(c) && counter == 0) {
                return false;
            }

            if (!brackets.containsKey(c) && counter == 0) {
                continue;
            }

            if (brackets.containsKey(c)) {
                bracketsRow.put(++counter, Map.of(c, false));
            }

            if (!brackets.containsKey(c) && (Character.isLetter(c) || Character.isDigit(c))) {
                if (bracketsRow.get(counter).containsValue(true)) {
                    continue;
                }
                Character key = (Character) bracketsRow.get(counter).keySet().toArray()[0];
                bracketsRow.replace(counter, Map.of(key, true));
            }

            if (brackets.containsValue(c)) {
                Character key = (Character) bracketsRow.get(counter).keySet().toArray()[0];
                if (brackets.get(key) != c) {
                    return false;
                }
                if (bracketsRow.get(counter).containsValue(false)) {
                    return false;
                }
                bracketsRow.remove(counter);
                counter--;
            }
        }

        return bracketsRow.size() == 0;
    }
}
