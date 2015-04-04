package net.chris.web.viewbean.billing;

import java.io.Serializable;

public class PeriodViewBean implements Serializable {

    private static final long serialVersionUID = -4535499703448381504L;

    private String from;
    private String to;

    /**
     * 
     * @return The from
     */
    public String getFrom() {
        return from;
    }

    /**
     * 
     * @param from
     *            The from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * 
     * @return The to
     */
    public String getTo() {
        return to;
    }

    /**
     * 
     * @param to
     *            The to
     */
    public void setTo(String to) {
        this.to = to;
    }
}
