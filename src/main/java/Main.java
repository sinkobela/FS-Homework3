import domain.Gym;
import domain.GymMember;
import domain.Subscription;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GymMember bela = new GymMember("Sinko Bela", LocalDate.of(1995,11,3));
        GymMember mark = new GymMember("Mark Markovic", LocalDate.of(1992,11,1));
        GymMember stefan = new GymMember("Sefan Bulzan", LocalDate.of(1985,6,15));
        GymMember ana = new GymMember("Ana Pop", LocalDate.of(2020,7,22));
        GymMember marcel = new GymMember("Marcel", LocalDate.of(2000,3,30));

        Subscription subscription1 = new Subscription(bela, Duration.ofHours(60));
        Subscription subscription2 = new Subscription(mark, Duration.ofHours(10));
        Subscription subscription3 = new Subscription(stefan, Duration.ofHours(500));
        Subscription subscription4 = new Subscription(ana, Duration.ofHours(44));
        Subscription subscription5 = new Subscription(marcel, Duration.ofHours(120));

        Gym gym = new Gym(List.of(subscription1, subscription2, subscription3, subscription4, subscription5));

        System.out.println("Total time: " + (subscription1.getTotalTime()).toHours());
        System.out.println("Time spent: " + (subscription1.getTimeSpent()).toHours());
        subscription1.setTimeSpent(Duration.ofHours(5));
        System.out.println("Total time: " + (subscription1.getTotalTime()).toHours());
        subscription1.addToTotalTime(Duration.ofHours(80));
        System.out.println("Total time: " + (subscription1.getTotalTime()).toHours());
        System.out.println("Time spent: " + (subscription1.getTimeSpent()).toHours());

        System.out.println("Average age is: " + gym.getAvgAge());
        System.out.println("Maximum age is: " + gym.getMaxAge());
        System.out.println("Minimum age is: " + gym.getMinAge());
        System.out.println("Total remaining time for all members: " + (gym.getTotalTime()).toHours());
        System.out.println(gym.getInfoAboutMember("Sinko Bela"));

    }
}
