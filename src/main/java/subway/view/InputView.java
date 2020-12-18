package subway.view;

import subway.utils.InputValidator;
import subway.utils.exception.InvalidMenuInputException;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);
    InputValidator inputValidator = new InputValidator();

    public String selectMenu() {
        try {
            String menu = scanner.nextLine();
            inputValidator.invalidMenu(menu);
            return menu;
        } catch (InvalidMenuInputException e) {
            throw new NullPointerException();
        }
    }
}
