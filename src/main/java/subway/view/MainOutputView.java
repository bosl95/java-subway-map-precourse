package subway.view;

import subway.domain.Line;

import java.util.List;

public class MainOutputView extends OutputView {
    private static String MAIN_VIEW = "메인 화면\n";
    private static String MENU_ONE = "1. 역 관리\n";
    private static String MENU_TWO = "2. 노선 관리\n";
    private static String MENU_THREE = "3. 구간 관리\n";
    private static String MENU_FOUR = "4. 지하철 노선도 출력\n";
    private static String MENU_QUITE = "Q. 종료\n";
    private static String SELECT_MENU = "원하는 기능을 선택하세요.\n";
    private static String QUITE_MESSAGE = "프로그램이 종료됩니다.\n";
    private static String DIVIDING_LINE = "---";
    private static String SUBWAY_MAP = "지하철 노선도";

    public static void printMainMenu() {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(MAIN_VIEW);
        stringBuilder.append(MENU_ONE);
        stringBuilder.append(MENU_TWO);
        stringBuilder.append(MENU_THREE);
        stringBuilder.append(MENU_FOUR);
        stringBuilder.append(MENU_QUITE);
        print();
    }

    public static void quiteProgram() {
        stringBuilder.append(INFO_SYMBOL);
        stringBuilder.append(QUITE_MESSAGE);
        print();
    }

    public static void printSubwayMap(List<Line> informSubwayMap) {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(SUBWAY_MAP);
        informSubwayMap.stream().forEach(line -> {
            stringBuilder.append(INFO_SYMBOL+line.getName());
            stringBuilder.append(INFO_SYMBOL+DIVIDING_LINE);
            line.informStations().stream().forEach(station -> stringBuilder.append(INFO_SYMBOL+station));
            stringBuilder.append(NEW_LINE);
        });
        print();
    }

    public void selectMainMenu() {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(SELECT_MENU);
        print();
    }
}
