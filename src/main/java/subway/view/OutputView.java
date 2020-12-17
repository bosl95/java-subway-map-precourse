package subway.view;

public class OutputView {
    public static StringBuilder stringBuilder = new StringBuilder();
    protected static String MENU_SYMBOL = "## ";

    static void print() {
        System.out.println(stringBuilder.toString());
        resetStringBuilder();
    }

    private static void resetStringBuilder() {
        stringBuilder.setLength(0);
    }
}
