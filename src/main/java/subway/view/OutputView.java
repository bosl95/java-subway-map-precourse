package subway.view;

import java.util.List;

public class OutputView {
    public static StringBuilder stringBuilder = new StringBuilder();
    protected static String MENU_SYMBOL = "\n## ";
    protected static String INFO_SYMBOL = "\n[INFO] ";
    protected static String NEW_LINE = "\n";
    protected static String SELECT_MENU = "원하는 기능을 선택하세요.\n";

    static void print() {
        System.out.print(stringBuilder.toString());
        resetStringBuilder();
    }

    private static void resetStringBuilder() {
        stringBuilder.setLength(0);
    }

    public void selectMenu() {
        menuSymbol();
        stringBuilder.append(SELECT_MENU);
        print();
    }

    protected static void menuSymbol() {
        stringBuilder.append(MENU_SYMBOL);
    }

    protected void infoSymbol() {
        stringBuilder.append(INFO_SYMBOL);
    }

    protected static void printMenu(String VIEW_NAME, List<String> menuList) {
        menuSymbol();
        stringBuilder.append(VIEW_NAME);
        menuList.forEach(menu -> stringBuilder.append(menu));
        print();
    }
}
