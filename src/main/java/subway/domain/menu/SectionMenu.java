package subway.domain.menu;

import subway.controller.section.SectionController;
import subway.utils.exception.InvalidMenuInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum SectionMenu {
    REGISTER("1", "1. 구간 등록\n", SectionController::register),
    DELETE("2", "2. 구간 삭제\n", SectionController::delete),
    BACK("B", "B. 돌아가기\n", null);

    private String button;
    private String menu;
    private Runnable runnable;

    SectionMenu(String button, String menu, Runnable runnable) {
        this.button = button;
        this.menu = menu;
        this.runnable = runnable;
    }

    public static List<String> list() {
        return Arrays.stream(SectionMenu.values())
                .map(sectionMenu -> sectionMenu.menu)
                .collect(Collectors.toList());
    }

    public void run() {
        if (!Objects.equals(this, BACK)) {
            runnable.run();
        }
    }

    public static SectionMenu findMenu(String name) {
        return Arrays.stream(SectionMenu.values())
                .filter(menu -> Objects.equals(menu.button, name))
                .findAny()
                .orElseThrow(() -> new InvalidMenuInputException());
    }
}
