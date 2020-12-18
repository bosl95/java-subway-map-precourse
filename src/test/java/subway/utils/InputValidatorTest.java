package subway.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.utils.exception.InvalidMenuInputException;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @DisplayName("잘못된 메뉴 입력")
    @Test
    void invalid_input_main_menu() {
        assertThrows(InvalidMenuInputException.class,
                () -> inputValidator.invalidMenu("$"));
        assertThrows(InvalidMenuInputException.class,
                () -> inputValidator.invalidMenu("-1"));
        assertThrows(InvalidMenuInputException.class,
                () -> inputValidator.invalidMenu("d"));
    }

    @DisplayName("올바른 메뉴 입력")
    @Test
    void valid_input_main_menu() {
        assertDoesNotThrow(() -> inputValidator.invalidMenu("1"));
        assertDoesNotThrow(() -> inputValidator.invalidMenu("Q"));
        assertDoesNotThrow(() -> inputValidator.invalidMenu("B"));
    }
}