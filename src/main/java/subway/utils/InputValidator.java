package subway.utils;

import subway.utils.exception.InvalidMenuInputException;

import java.util.regex.Pattern;

public class InputValidator {
    private static String MAIN_MENU_PATTERN = "^[1-4]|Q$";

    public void invalidMainMenu(String menu) {
        if (!Pattern.matches(MAIN_MENU_PATTERN, menu)) {
            throw new InvalidMenuInputException();
        }
    }
}
