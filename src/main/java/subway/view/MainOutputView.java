package subway.view;

import subway.domain.Line;

import java.util.List;

public class MainOutputView extends OutputView {
    private static String MAIN_VIEW = "메인 화면\n";
    private static String DIVIDING_LINE = "---";
    private static String SUBWAY_MAP = "지하철 노선도";

    public static void printMainMenu(List<String> menuList) {
        printMenu(MAIN_VIEW, menuList);
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
}
