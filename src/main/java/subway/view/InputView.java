package subway.view;

import subway.utils.InputValidator;
import subway.utils.exception.InvalidMenuInputException;
import subway.utils.exception.InvalidStationNameException;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static InputValidator inputValidator = new InputValidator();

    public static String selectMenu() {
        try {
            String menu = scanner.nextLine();
            inputValidator.invalidMenu(menu);
            return menu;
        } catch (InvalidMenuInputException e) {
            throw new NullPointerException();
        }
    }

    public static String inputStation() {
        try {
            String station = scanner.nextLine();
            inputValidator.invalidStationName(station);
            return station;
        } catch (InvalidStationNameException e) {
            throw new NullPointerException();
        }
    }
}
