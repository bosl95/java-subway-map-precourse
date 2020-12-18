package subway.view;

import subway.domain.Line;

import java.util.List;

public class LineOutputView extends OutputView {
    private static String LINE_VIEW = "노선 관리 화면\n";
    private static String INPUT_REGISTER_LINE = "등록할 노선 이름을 입력하세요.\n";
    private static String SUCCESS_REGISTER_LINE = "지하철 노선이 등록되었습니다.\n";
    private static String INPUT_FIRST_STATION = "등록할 노선의 상행 종점역의 이름을 입력하세요.\n";
    private static String INPUT_LAST_STATION = "등록할 노선의 하행 종점역의 이름을 입력하세요.\n";
    private static String INPUT_DELETE_LINE = "삭제할 노선 이름을 입력하세요.\n";
    private static String SUCCESS_DELETE_LINE = "지하철 노선이 삭제되었습니다.\n";

    public void printAll(List<Line> lines) {

    }

    public void printLineMenu(List<String> menuList) {
        printMenu(LINE_VIEW, menuList);
    }

    public void inputRegisterLine() {
        menuSymbol();
        stringBuilder.append(INPUT_REGISTER_LINE);
        print();
    }

    public void successRegister() {
        infoSymbol();
        stringBuilder.append(SUCCESS_REGISTER_LINE);
        print();
    }

    public void inputFirstStations() {
        menuSymbol();
        stringBuilder.append(INPUT_FIRST_STATION);
        print();
    }

    public void inputLastStations() {
        menuSymbol();
        stringBuilder.append(INPUT_LAST_STATION);
        print();
    }

    public void inputDeleteLine() {
        menuSymbol();
        stringBuilder.append(INPUT_DELETE_LINE);
        print();
    }

    public void successDelete() {
        infoSymbol();
        stringBuilder.append(SUCCESS_DELETE_LINE);
        print();
    }
}
