package subway.view;

public class MainOutputView extends OutputView {
    private static String MAIN_VIEW = "메인 화면\n";
    private static String MENU_ONE = "1. 역 관리\n";
    private static String MENU_TWO = "2. 노선 관리\n";
    private static String MENU_THREE = "3. 구간 관리\n";
    private static String MENU_FOUR = "4. 지하철 노선도 출력\n";
    private static String MENU_QUITE = "Q. 종료\n";

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
}
