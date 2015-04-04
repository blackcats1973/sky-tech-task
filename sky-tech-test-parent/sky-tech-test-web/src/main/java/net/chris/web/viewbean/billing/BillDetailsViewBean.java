package net.chris.web.viewbean.billing;

import java.io.Serializable;

public class BillDetailsViewBean implements Serializable {

    private static final long serialVersionUID = 8713670606231121551L;

    private StatementViewBean statement;
    private Double total;
    private ChosenPackageViewBean chosenPackage;
    private CallChargesViewBean callCharges;
    private SkyStoreViewBean skyStore;

    /**
     * 
     * @return The statement
     */
    public StatementViewBean getStatement() {
        return statement;
    }

    /**
     * 
     * @param statement
     *            The statement
     */
    public void setStatement(StatementViewBean statement) {
        this.statement = statement;
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

    /**
     * 
     * @return The chosenPackage
     */
    public ChosenPackageViewBean getChosenPackage() {
        return chosenPackage;
    }

    /**
     * 
     * @param chosenPackage
     *            The package
     */
    public void setChosenPackage(ChosenPackageViewBean chosenPackage) {
        this.chosenPackage = chosenPackage;
    }

    /**
     * 
     * @return The callCharges
     */
    public CallChargesViewBean getCallCharges() {
        return callCharges;
    }

    /**
     * 
     * @param callCharges
     *            The callCharges
     */
    public void setCallCharges(CallChargesViewBean callCharges) {
        this.callCharges = callCharges;
    }

    /**
     * 
     * @return The skyStore
     */
    public SkyStoreViewBean getSkyStore() {
        return skyStore;
    }

    /**
     * 
     * @param skyStore
     *            The skyStore
     */
    public void setSkyStore(SkyStoreViewBean skyStore) {
        this.skyStore = skyStore;
    }
}
