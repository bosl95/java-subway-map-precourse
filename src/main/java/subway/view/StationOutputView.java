package subway.view;

import java.util.List;

public class StationOutputView extends OutputView {
    private static String STATION_VIEW = "역 관리 화면\n";

    public void printStationMenu(List<String> menuList) {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(STATION_VIEW);
        menuList.forEach(menu -> stringBuilder.append(menu));
        print();
    }
}
