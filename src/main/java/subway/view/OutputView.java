package subway.view;

public class OutputView {
    public static StringBuilder stringBuilder = new StringBuilder();
    protected static String MENU_SYMBOL = "## ";
    protected static String INFO_SYMBOL = "## ";
    protected static String NEW_LINE = "\n";

    static void print() {
        System.out.print(stringBuilder.toString());
        resetStringBuilder();
    }

    private static void resetStringBuilder() {
        stringBuilder.setLength(0);
    }
}
