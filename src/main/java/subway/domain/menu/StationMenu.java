package subway.domain.menu;

import subway.controller.*;
import subway.utils.exception.InvalidMenuInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum StationMenu {
    REGISTER("1", "1. 역 등록\n", StationController::register),
    DELETE("2", "2. 역 삭제\n", StationController::delete),
    PRINT("3", "3. 역 조회\n", StationController::print),
    BACK("B", "B. 돌아가기\n", null);

    private String button;
    private String menu;
    private Runnable runnable;

    StationMenu(String button, String menu, Runnable runnable) {
        this.button = button;
        this.menu = menu;
        this.runnable = runnable;
    }

    public static StationMenu fineMenu(String name) {
        return Arrays.stream(StationMenu.values())
                .filter(menu -> Objects.equals(menu.button, name))
                .findAny()
                .orElseThrow(() -> new InvalidMenuInputException());
    }

    public static List<String> list() {
        return Arrays.stream(StationMenu.values())
                .map(stationMenu -> stationMenu.menu)
                .collect(Collectors.toList());
    }

    public boolean isRunning() {
        return !Objects.equals(StationMenu.BACK, this);
    }

    public static StationMenu setRunningState() {
        return StationMenu.REGISTER;    // just for running state
    }

    public void run() {
        if (isRunning()) {
            runnable.run();
        }
    }
}
