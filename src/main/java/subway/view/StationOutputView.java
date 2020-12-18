package subway.view;

import subway.domain.Station;

import java.util.List;

public class StationOutputView extends OutputView {
    private static String STATION_VIEW = "역 관리 화면\n";
    private static String STATION_LIST = "역 목록";
    private static String INPUT_REGISTER_STATION = "등록할 역 이름을 입력하세요.\n";
    private static String SUCCESS_REGISTER_STATION = "지하철 역이 등록되었습니다.\n";
    private static String INPUT_DELETE_STATION = "삭제할 역 이름을 입력하세요.\n";

    public void printStationMenu(List<String> menuList) {
        printMenu(STATION_VIEW, menuList);
    }

    public void inputRegisterStation() {
        menuSymbol();
        stringBuilder.append(INPUT_REGISTER_STATION);
        print();
    }

    public void successRegister() {
        infoSymbol();
        stringBuilder.append(SUCCESS_REGISTER_STATION);
        print();
    }

    public void printStations(List<Station> stations) {
        menuSymbol();
        stringBuilder.append(STATION_LIST);
        stations.stream()
                .forEach(station -> {
                    infoSymbol();
                    stringBuilder.append(station.getName());
                });
        stringBuilder.append(NEW_LINE);
        print();
    }

    public void inputDeleteStation() {
        menuSymbol();
        stringBuilder.append(INPUT_DELETE_STATION);
        print();
    }
}
