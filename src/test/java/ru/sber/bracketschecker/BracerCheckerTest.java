package ru.sber.bracketschecker;

import org.junit.jupiter.api.Test;
import ru.sber.bracketschecker.util.BracketsChecker;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BracerCheckerTest {

    @Test
    public void BracketChecker_shouldReturnBoolean() {
        String trueText1 = "([{abc}abc]abc)";
        String trueText2 = "([{abc}(abc)abc]abc)";
        String trueText3 = "([{abc}abc]abc)[abc]";
        String trueText4 = "{abc}([{abc}abc]abc)";
        String trueText5 = "22(abc{abc}[abc] (23))";
        String falseText1 = "()";
        String falseText2 = "abc(2)()";
        String falseText3 = "abc((abc)";
        String falseText4 = "abc(23))";
        String falseText5 = "abc((23))";
        String falseText6 = "abc{(abc)";
        String falseText7 = "abc[]";
        String falseText8 = "abc{}";
        String falseText9 = "abc[abc]]";
        String falseText10 = "abc{abc}}";
        assertAll("BracketsChecker test",
                () -> assertTrue(BracketsChecker.isCorrect(trueText1)),
                () -> assertTrue(BracketsChecker.isCorrect(trueText2)),
                () -> assertTrue(BracketsChecker.isCorrect(trueText3)),
                () -> assertTrue(BracketsChecker.isCorrect(trueText4)),
                () -> assertTrue(BracketsChecker.isCorrect(trueText5)),
                () -> assertFalse(BracketsChecker.isCorrect(falseText1)),
                () -> assertFalse(BracketsChecker.isCorrect(falseText2)),
                () -> assertFalse(BracketsChecker.isCorrect(falseText3)),
                () -> assertFalse(BracketsChecker.isCorrect(falseText4)),
                () -> assertFalse(BracketsChecker.isCorrect(falseText5)),
                () -> assertFalse(BracketsChecker.isCorrect(falseText6)),
                () -> assertFalse(BracketsChecker.isCorrect(falseText7)),
                () -> assertFalse(BracketsChecker.isCorrect(falseText8)),
                () -> assertFalse(BracketsChecker.isCorrect(falseText9)),
                () -> assertFalse(BracketsChecker.isCorrect(falseText10))
        );

    }
}
