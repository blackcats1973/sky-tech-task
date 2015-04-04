package net.chris.web.viewbean.billing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SkyStoreViewBean implements Serializable {

    private static final long serialVersionUID = 6223152599258051628L;

    private List<RentalViewBean> rentals = new ArrayList<RentalViewBean>();
    private List<BuyAndKeepViewBean> buyAndKeep = new ArrayList<BuyAndKeepViewBean>();
    private Double total;

    /**
     * 
     * @return The rentals
     */
    public List<RentalViewBean> getRentals() {
        return rentals;
    }

    /**
     * 
     * @param rentals
     *            The rentals
     */
    public void setRentals(List<RentalViewBean> rentals) {
        this.rentals = rentals;
    }

    /**
     * 
     * @return The buyAndKeep
     */
    public List<BuyAndKeepViewBean> getBuyAndKeep() {
        return buyAndKeep;
    }

    /**
     * 
     * @param buyAndKeep
     *            The buyAndKeep
     */
    public void setBuyAndKeep(List<BuyAndKeepViewBean> buyAndKeep) {
        this.buyAndKeep = buyAndKeep;
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
