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

    public void printSectionMenu(List<String> menuList) {
        printMenu(SECTION_VIEW, menuList);
    }

    public void inputRegisterLineOfSection() {
        menuSymbol();
        stringBuilder.append(INPUT_REGISTER_LINE);
        print();
    }

    public void inputRegisterStationOfSection() {
        menuSymbol();
        stringBuilder.append(INPUT_REGISTER_STATION);
        print();
    }

    public void inputRegisterOrderOfSection() {
        menuSymbol();
        stringBuilder.append(INPUT_REGISTER_ORDER);
        print();
    }

    public void successRegisterSection() {
        printInfo(SUCCESS_REGISTER_SECTION);
    }

    private void printInfo(String message) {
        infoSymbol();
        stringBuilder.append(message);
        print();
    }
}
