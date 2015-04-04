package net.chris.web.viewbean.billing;

import java.io.Serializable;

public class CallViewBean implements Serializable {

    private static final long serialVersionUID = 6958632648231419756L;

    private String called;
    private String duration;
    private Double cost;

    /**
     * 
     * @return The called
     */
    public String getCalled() {
        return called;
    }

    /**
     * 
     * @param called
     *            The called
     */
    public void setCalled(String called) {
        this.called = called;
    }

    /**
     * 
     * @return The duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * 
     * @param duration
     *            The duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
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
