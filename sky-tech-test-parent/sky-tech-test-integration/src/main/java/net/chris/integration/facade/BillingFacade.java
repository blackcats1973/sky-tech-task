/**
 * 
 */
package net.chris.integration.facade;

import net.chris.integration.billing.dto.BillDetails;

/**
 * Facade defining all billing operations.
 * 
 * @author Chris Hern
 * 
 */
public interface BillingFacade {

    /**
     * Retrieve the billing details.
     * 
     * @return Bill details in the form of a {@link BillDetails} object.
     */
    BillDetails getBillDetails();
}
