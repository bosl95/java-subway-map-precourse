package subway.view;

import subway.utils.InputValidator;
import subway.utils.exception.InvalidLineNameException;
import subway.utils.exception.InvalidMenuInputException;
import subway.utils.exception.InvalidStationNameException;
import subway.utils.exception.OrderNotNumberException;

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
        String station = scanner.nextLine();
        inputValidator.invalidStationName(station);
        return station;
    }

    public static String inputLine() {
        String line = scanner.nextLine();
        inputValidator.invalidLineName(line);
        return line;
    }

    public static String inputOrder() {
        try {
            String order = scanner.nextLine();
            inputValidator.invalidOrder(order);
            return order;
        } catch (OrderNotNumberException e) {
            throw new NullPointerException();
        }
    }
}
