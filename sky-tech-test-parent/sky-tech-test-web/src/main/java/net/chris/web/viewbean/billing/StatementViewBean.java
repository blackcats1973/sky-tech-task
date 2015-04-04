package net.chris.web.viewbean.billing;

import java.io.Serializable;

public class StatementViewBean implements Serializable {

    private static final long serialVersionUID = 7343551728344249752L;

    private String generated;
    private String due;
    private PeriodViewBean period;

    /**
     * 
     * @return The generated
     */
    public String getGenerated() {
        return generated;
    }

    /**
     * 
     * @param generated
     *            The generated
     */
    public void setGenerated(String generated) {
        this.generated = generated;
    }

    /**
     * 
     * @return The due
     */
    public String getDue() {
        return due;
    }

    /**
     * 
     * @param due
     *            The due
     */
    public void setDue(String due) {
        this.due = due;
    }

    /**
     * 
     * @return The period
     */
    public PeriodViewBean getPeriod() {
        return period;
    }

    /**
     * 
     * @param period
     *            The period
     */
    public void setPeriod(PeriodViewBean period) {
        this.period = period;
    }
}
