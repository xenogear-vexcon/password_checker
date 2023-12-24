package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Map;

class PasswordCheckerTest {
    @ParameterizedTest
    @CsvSource(value={
            "pass, 2, true",
            "passs, 2, false"

    })
    void validateCorrectRepeatsParametrized(String password, int maxRepeats, boolean expected) {
        PasswordChecker passChecker = new PasswordChecker(2, maxRepeats);
        boolean result = passChecker.correctRepeats(password);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value={
            "password, 3, 2, true",
            "passsword, 3, 2, false",
            "psss, 5, 3, false"

    })
    void validatePasswordParametrized(String password, int minLength, int maxRepeats, boolean expected) {
        PasswordChecker passChecker = new PasswordChecker(minLength, maxRepeats);
        boolean result = passChecker.verify(password);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value={
            "Apas2swordz, true",
            "apasssw1ordz, false",
            "ApsssZ, false"

    })
    void validatePasswordPatternParametrized(String password, boolean expected) {
        PasswordChecker passChecker = new PasswordChecker(3, 5);
        boolean result = passChecker.validatePass(password);
        Assertions.assertEquals(expected, result);
    }


    //hamcrest
//    @Test
//    void validatePasswordPattern(){
//        Map<String, Boolean> map = Map.of(
//                "Apas2swordz", true,
//                "apasssw1ordz", false,
//                "ApsssZ", false
//        );
//        PasswordChecker passChecker = new PasswordChecker(3, 5);
//        for(Map.Entry<String, Boolean> entry: map.entrySet()) {
//            boolean result = passChecker.validatePass(entry.getKey());
//            assertThat(entry.getValue(), equalTo(result));
//        }
//    }
//
//    @Test
//    void validateCorrectRepeats(){
//        Map<String, Boolean> map = Map.of(
//                "pass", true,
//                "passs", false
//        );
//        PasswordChecker passChecker = new PasswordChecker(2, 2);
//        for(Map.Entry<String, Boolean> entry: map.entrySet()) {
//            boolean result = passChecker.correctRepeats(entry.getKey());
//            assertThat(entry.getValue(), equalTo(result));
//        }
//    }
}