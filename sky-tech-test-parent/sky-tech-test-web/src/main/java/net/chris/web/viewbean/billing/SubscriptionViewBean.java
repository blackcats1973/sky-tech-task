package net.chris.web.viewbean.billing;

import java.io.Serializable;

public class SubscriptionViewBean implements Serializable {

    private static final long serialVersionUID = 1883456129087448990L;

    private String type;
    private String name;
    private Double cost;

    /**
     * 
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *            The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *            The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return The cost
     */
    public Double getCost() {
        return cost;
    }

    /**
     * 
     * @param cost
     *            The cost
     */
    public void setCost(Double cost) {
        this.cost = cost;
    }
}
