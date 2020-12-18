package subway.view;

import java.util.List;

public class SectionOutputView extends OutputView {
    private static String SECTION_VIEW = "구간 관리 화면\n";
    private static String INPUT_REGISTER_LINE = "노선 이름을 입력하세요.\n";
    private static String INPUT_REGISTER_STATION = "역 이름을 입력하세요.\n";
    private static String INPUT_REGISTER_ORDER = "순서를 입력하세요.\n";
    private static String SUCCESS_REGISTER_SECTION = "구간이 등록되었습니다.\n";
    private static String INPUT_DELETE_LINE_OF_SECTION = "삭제할 구간의 노선을 입력하세요.\n";
    private static String INPUT_DELETE_STATION_OF_SECTION = "삭제할 구간의 역을 입력하세요.\n";
    private static String SUCCESS_DELETE_SECTION = "구간이 삭제되었습니다.\n";
    private static String LINE_LIST = "노선 목록";

    public void printSectionMenu(List<String> menuList) {
        printMenu(SECTION_VIEW, menuList);
    }
}
