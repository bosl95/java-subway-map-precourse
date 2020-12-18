package subway.utils;

import subway.utils.exception.InvalidLineNameException;
import subway.utils.exception.InvalidMenuInputException;
import subway.utils.exception.InvalidStationNameException;

import java.util.regex.Pattern;

public class InputValidator {
    private static String MENU_PATTERN = "^[0-9]|Q|B$";
    private static String STATION_NAME_PATTERN = "^[가-힣]+역";
    private static String LINE_NAME_PATTERN = "^[0-9가-힣]+선";

    public void invalidMenu(String menu) {
        if (!Pattern.matches(MENU_PATTERN, menu)) {
            throw new InvalidMenuInputException();
        }
    }

    public void invalidStationName(String station) {
        if (!Pattern.matches(STATION_NAME_PATTERN, station)) {
            throw new InvalidStationNameException();
        }
    }

    public void invalidLineName(String line) {
        if (!Pattern.matches(LINE_NAME_PATTERN, line)) {
            throw new InvalidLineNameException();
        }
    }
}
