package subway.view;

import subway.domain.Line;

import java.util.List;

public class LineOutputView extends OutputView {
    private static String LINE_VIEW = "노선 관리 화면\n";

    public void printAll(List<Line> lines) {

    }

    public void printLineMenu(List<String> menuList) {
        printMenu(LINE_VIEW, menuList);
    }
}
