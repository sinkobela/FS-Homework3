package report;

import domain.Gym;
import domain.Subscription;

import java.util.List;

public class MemorySubscriptionProvider implements SubscriptionProvider {

    @Override
    public List<Subscription> readSubscriptions(Gym gym) {
        return gym.getSubscriptions();
    }
}
