package subway.domain.menu;

import subway.controller.Line.LineController;
import subway.utils.exception.InvalidMenuInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum LineMenu {
    REGISTER("1", "1. 노선 등록\n", LineController::register),
    DELETE("2", "2. 노선 삭제\n", LineController::delete),
    PRINT("3", "3. 노선 조회\n", LineController::print),
    BACK("B", "B. 돌아가기\n", null);

    private String button;
    private String menu;
    private Runnable runnable;

    LineMenu(String button, String menu, Runnable runnable) {
        this.button = button;
        this.menu = menu;
        this.runnable = runnable;
    }

    public static List<String> list() {
        return Arrays.stream(LineMenu.values())
                .map(lineMenu -> lineMenu.menu)
                .collect(Collectors.toList());
    }

    public static LineMenu findMenu(String name) {
        return Arrays.stream(LineMenu.values())
                .filter(menu -> Objects.equals(menu.button, name))
                .findAny()
                .orElseThrow(() -> new InvalidMenuInputException());
    }

    public void run() {
        if (!Objects.equals(this, BACK)) {
            runnable.run();
        }
    }
}
