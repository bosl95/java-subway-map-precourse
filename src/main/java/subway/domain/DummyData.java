package subway.domain;

import java.util.Arrays;

public class DummyData {
    public static void load() {
        station_load();
        line_load();
    }

    private static void station_load() {
        StationRepository.addStation(Station.from("교대역"));
        StationRepository.addStation(Station.from("강남역"));
        StationRepository.addStation(Station.from("역삼역"));
        StationRepository.addStation(Station.from("남부터미널역"));
        StationRepository.addStation(Station.from("양재역"));
        StationRepository.addStation(Station.from("양재시민의숲역"));
        StationRepository.addStation(Station.from("매봉역"));
    }

    private static void line_load() {
        LineRepository.addLine(Line.from("2호선", Arrays.asList("교대역", "강남역", "역삼역")));
        LineRepository.addLine(Line.from("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")));
        LineRepository.addLine(Line.from("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역")));
    }
}
