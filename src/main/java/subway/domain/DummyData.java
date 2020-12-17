package subway.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DummyData {
    public static void load() {
        station_load();
        line_load();
    }

    private static void station_load() {
        List<String> stationNames = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        StationRepository.addAll(stationNames.stream()
                .map(name -> StationRepository.from(name))
                .collect(Collectors.toList()));
    }

    private static void line_load() {
        LineRepository.addAll(
                Arrays.asList(LineRepository.valueOf("2호선", Arrays.asList("교대역", "강남역", "역삼역")),
                        LineRepository.valueOf("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")),
                        LineRepository.valueOf("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역")))
        );
    }
}
