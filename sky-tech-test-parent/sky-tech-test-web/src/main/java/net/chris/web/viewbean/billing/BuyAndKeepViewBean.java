package net.chris.web.viewbean.billing;

import java.io.Serializable;

public class BuyAndKeepViewBean implements Serializable {

    private static final long serialVersionUID = 4462892439360558223L;

    private String title;
    private Double cost;

    /**
     * 
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *            The title
     */
    public void setTitle(String title) {
        this.title = title;
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
