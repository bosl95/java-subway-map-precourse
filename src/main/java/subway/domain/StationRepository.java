package subway.domain;

import subway.utils.exception.AlreadyRegisterStationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static Station from(String name) {
        return new Station(name);
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private static boolean alreadyRegister(String name) {
        return stations.stream()
                .anyMatch(station -> Objects.equals(station.getName(), name));
    }

    public static void registerStation(String station) {
        if (alreadyRegister(station)) {
            throw new AlreadyRegisterStationException();
        }
        addStation(from(station));
    }
}
