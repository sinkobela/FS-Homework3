package report;

import domain.Gym;
import domain.GymMember;
import domain.Subscription;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class SubscriptionReportGenerator {
    private final SubscriptionProvider subscriptionProvider;
    private final Gym gym;

    public SubscriptionReportGenerator(SubscriptionProvider subscriptionProvider, Gym gym) {
        this.subscriptionProvider = subscriptionProvider;
        this.gym = gym;
    }

    public void generateReport(String output) {
        List<Subscription> subscriptions = subscriptionProvider.readSubscriptions(gym);
//        writeReport(Map<String, List<String>>, output);
    }

    private Map<String, List<String>> getMapOfMembersByColor()  {
        return getCategorizedList().stream()
                .collect(groupingBy())

    }

    private List<String> getGymMemberNames() {
        return getCategorizedList().stream()
                .map(CategorizeGymMembers::getSubscription)
                .map(Subscription::getGymMember)
                .map(GymMember::getName)
                .collect(toList());
    }

    private List<CategorizeGymMembers> getCategorizedList() {
        return subscriptionProvider.readSubscriptions(gym).stream()
                .map(CategorizeGymMembers::new)
                .collect(Collectors.toList());
    }

}
