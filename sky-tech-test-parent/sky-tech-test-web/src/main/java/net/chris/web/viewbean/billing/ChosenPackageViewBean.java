package net.chris.web.viewbean.billing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChosenPackageViewBean implements Serializable {

    private static final long serialVersionUID = -6752217049285626862L;

    private List<SubscriptionViewBean> subscriptions = new ArrayList<SubscriptionViewBean>();
    private Double total;

    /**
     * 
     * @return The subscriptions
     */
    public List<SubscriptionViewBean> getSubscriptions() {
        return subscriptions;
    }

    /**
     * 
     * @param subscriptions
     *            The subscriptions
     */
    public void setSubscriptions(List<SubscriptionViewBean> subscriptions) {
        this.subscriptions = subscriptions;
    }

    /**
     * 
     * @return The total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *            The total
     */
    public void setTotal(Double total) {
        this.total = total;
    }
}
