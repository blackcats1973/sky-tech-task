/**
 * 
 */
package net.chris.web.actionhandler;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.chris.integration.billing.dto.BillDetails;
import net.chris.integration.facade.BillingFacade;
import net.chris.web.converter.IntegrationConverterService;
import net.chris.web.spring.ApplicationContextProvider;
import net.chris.web.viewbean.billing.BillDetailsViewBean;

/**
 * Action handler for handling bill operations.
 * 
 * @author Chris Hern
 * 
 */
@ManagedBean(name = "billingActionHandler")
@ViewScoped
public class BillingActionHandler {

    private BillingFacade billingFacade;
    private IntegrationConverterService converterService;

    @PostConstruct
    public void init() {

        billingFacade = ApplicationContextProvider.getApplicationContext().getBean(BillingFacade.class);
        converterService = ApplicationContextProvider.getApplicationContext().getBean(IntegrationConverterService.class);
    }

    /**
     * Get the {@link BillDetailsViewBean} containing the billing details.
     * 
     * @return {@link BillDetailsViewBean} containing billing details.
     */
    public BillDetailsViewBean getBillDetailsPageBean() {

        final BillDetails billDetails = billingFacade.getBillDetails();

        return converterService.convert(billDetails, BillDetailsViewBean.class);
    }

}
