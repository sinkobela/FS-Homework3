package report;

import domain.Gym;
import domain.Subscription;

import java.util.List;

public interface SubscriptionProvider {
    List<Subscription> readSubscriptions(Gym gym);
}
