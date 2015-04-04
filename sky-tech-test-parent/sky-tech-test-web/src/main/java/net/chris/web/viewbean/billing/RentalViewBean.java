package net.chris.web.viewbean.billing;

import java.io.Serializable;

public class RentalViewBean implements Serializable {

    private static final long serialVersionUID = -1714233320494703554L;

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
