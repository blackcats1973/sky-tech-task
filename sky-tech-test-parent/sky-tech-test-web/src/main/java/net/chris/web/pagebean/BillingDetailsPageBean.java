package net.chris.web.pagebean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.chris.web.actionhandler.BillingActionHandler;
import net.chris.web.viewbean.billing.BillDetailsViewBean;

/**
 * Page bean used for the billing details page.
 * 
 * @author Chris Hern
 * 
 */
@ManagedBean
@ViewScoped
public class BillingDetailsPageBean {

    @ManagedProperty(value = "#{billingActionHandler}")
    private BillingActionHandler billingActionHandler;

    private BillDetailsViewBean billDetailsViewBean;

    @PostConstruct
    public void init() {

        this.billDetailsViewBean = billingActionHandler.getBillDetailsPageBean();
    }

    /**
     * @param billingActionHandler
     *            the billingActionHandler to set
     */
    public void setBillingActionHandler(BillingActionHandler billingActionHandler) {
        this.billingActionHandler = billingActionHandler;
    }

    /**
     * @return the billDetailsViewBean
     */
    public BillDetailsViewBean getBillDetailsViewBean() {
        return billDetailsViewBean;
    }

    /**
     * @return the billingActionHandler
     */
    public BillingActionHandler getBillingActionHandler() {
        return billingActionHandler;
    }
}
