package report;

import java.util.Optional;
import java.util.stream.Stream;

public enum GymMemberType {
    RED(10),
    YELLOW(30),
    GREEN(Long.MAX_VALUE);

    private final long time;


    GymMemberType(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public static Optional<GymMemberType> getType(long time) {
        return Stream.of(values())
                .filter(val -> val.getTime() >= time)
                .findFirst();
    }
}
