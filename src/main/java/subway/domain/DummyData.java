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

    }
}
