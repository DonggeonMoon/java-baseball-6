package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    @Test
    void throwExceptionIfInputIsAlphabet() {
        String alphabetInput = "abc";
        command(alphabetInput);
        assertThatThrownBy(() -> Application.main(new String[]{})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwExceptionIfInputIsKorean() {
        final String koreanInput = "가나다";
        command(koreanInput);
        assertThatThrownBy(() -> Application.main(new String[]{})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwExceptionIfInputIsShorterThanThree() {
        final String shortNumbers = "23";
        command(shortNumbers);
        assertThatThrownBy(() -> Application.main(new String[]{})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwExceptionIfInputIsLongerThanThree() {
        final String longNumbers = "23553";
        command(longNumbers);
        assertThatThrownBy(() -> Application.main(new String[]{})).isInstanceOf(IllegalArgumentException.class);
    }

    private static void command(String... args) {
        System.setIn(
                new ByteArrayInputStream(
                        String.join("\n", args).getBytes()
                ));
    }

    @AfterEach
    void closeScanner() {
        Console.close();
    }
}
