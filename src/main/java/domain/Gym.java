package domain;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Gym {

    private final List<Subscription> subscriptions;

    public Gym(List<Subscription> subscriptions) {
        this.subscriptions = Optional.ofNullable(subscriptions)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public List<GymMember> getGymMembers() {
        return subscriptions.stream()
                .map(Subscription::getGymMember)
                .collect(Collectors.toList());
    }

    public List<LocalDate> getAges() {
        return getGymMembers().stream()
                .map(GymMember::getBirthDate)
                .collect(Collectors.toList());
    }

    public int getAvgAge() {
        List<Integer> years = getAges().stream()
                .map(LocalDate::getYear)
                .collect(Collectors.toList());

        int sum = 0;
        for (Integer i : years) {
            sum += i;
        }
        return LocalDate.now().getYear() - (sum / years.size());
    }

    public int getMaxAge() {
        LocalDate max = getAges().stream()
                .min(LocalDate::compareTo)
                .get();

        return Period.between(max, LocalDate.now()).getYears();
    }

    public int getMinAge() {
        LocalDate min = getAges().stream()
                .max(LocalDate::compareTo)
                .get();

        return Period.between(min, LocalDate.now()).getYears();
    }

    public Duration getTotalTime() {
        List<Duration> times = subscriptions.stream()
                .map(Subscription::getTotalTime)
                .collect(Collectors.toList());

        long total = 0;
        for (Duration duration : times) {
            total += duration.getSeconds();
        }
        return Duration.ofSeconds(total);
    }

    public String getInfoAboutMember(String name) {
        String result = "Cannot find gym member with this name: " + name;
        for (Subscription subscription : subscriptions) {
            if (subscription.getGymMember().getName().equalsIgnoreCase(name)) {
                result =  "domain.Gym member: " + name + ", birt date: " + subscription.getGymMember().getBirthDate()
                        + ", total time: " + (subscription.getTotalTime()).toHours() + ", time spent: " + (subscription.getTimeSpent()).toHours();
            }
        }
        return result;
    }


}
