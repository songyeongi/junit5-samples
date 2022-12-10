package com.example.project;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyFirstJUnitJupiterTests {

    /**
     * 첫 번째 테스트 케이스
     */
    private final Calculator calculator = new Calculator();

    @Test
    void addition() {
        assertEquals(2, calculator.add(1,1));
    }

    /**
     * 매개 변수가 있는 테스트를 사용하면 다른 인수를 사용하여 테스트를 여러 번 실행
     * @ParameterizedTest
     * @ValueSource
     * @param candidate
     */
    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    void palindromes(String candidate) {
//        assertTrue(StringUtils.isPalindrome(candidate));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void testWithValueSource(int argument) {
        assertTrue(argument > 0 && argument < 4);
    }
    @ParameterizedTest
    @NullAndEmptySource //@NullSource + @EmptySource
    @ValueSource(strings = { "", " ", "\t", "\n"})
    void nullEmptyAndBlankStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }

    /**
     * 반복 횟수를 지정하고 메서드에 주석을 추가하여 지정된 횟수만큼 테스트를 반복
     * @RepeatedTest
     */
    @RepeatedTest(10)
    void repeatedTest() {

    }
    @RepeatedTest(5)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        assertEquals(5, repetitionInfo.getTotalRepetitions());
    }
    @RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Details...")
    void customDisplayNameWithLongPattern(TestInfo testInfo) {
        assertEquals("Details... :: repetition 1 of 1",
                testInfo.getDisplayName());
    }
}
