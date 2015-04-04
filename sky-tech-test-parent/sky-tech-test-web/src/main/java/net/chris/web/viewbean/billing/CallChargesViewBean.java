package net.chris.web.viewbean.billing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CallChargesViewBean implements Serializable {

    private static final long serialVersionUID = -7311127988175771791L;

    private List<CallViewBean> calls = new ArrayList<CallViewBean>();
    private Double total;

    /**
     * 
     * @return The calls
     */
    public List<CallViewBean> getCalls() {
        return calls;
    }

    /**
     * 
     * @param calls
     *            The calls
     */
    public void setCalls(List<CallViewBean> calls) {
        this.calls = calls;
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
