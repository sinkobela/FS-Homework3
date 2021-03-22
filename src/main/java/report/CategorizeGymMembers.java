package report;

import domain.GymMember;
import domain.Subscription;

public class CategorizeGymMembers {
    private final Subscription subscription;
    private final String category;

    public CategorizeGymMembers(Subscription subscription) {
        this.subscription = subscription;
        this.category = setCategory();
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public String getCategory() {
        return category;
    }

    private String setCategory() {
        return GymMemberType.getType(subscription.getTotalTime().toHours()).toString();
    }

}
