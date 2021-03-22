package domain;

import java.time.Duration;
import java.util.Objects;

public class Subscription {
    private final GymMember gymMember;
    private Duration totalTime;
    private Duration timeSpent;

    public Subscription(GymMember gymMember, Duration totalTime) {
        this.gymMember = gymMember;
        this.totalTime = totalTime;
        this.timeSpent = Duration.ZERO;
    }

    public GymMember getGymMember() {
        return gymMember;
    }

    public Duration getTotalTime() {
        if (timeSpent != null) {
            return (totalTime.minus(timeSpent));
        } else {
            return totalTime;
        }
    }

    public Duration getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Duration timeSpent) {
        this.timeSpent = timeSpent;
    }

    public void addToTotalTime(Duration timeToAdd) {
        this.totalTime = this.totalTime.plus(timeToAdd);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(gymMember, that.gymMember) && Objects.equals(totalTime, that.totalTime) && Objects.equals(timeSpent, that.timeSpent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gymMember, totalTime, timeSpent);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "gymMember=" + gymMember +
                ", totalTime=" + totalTime +
                ", timeSpent=" + timeSpent +
                '}';
    }
}
