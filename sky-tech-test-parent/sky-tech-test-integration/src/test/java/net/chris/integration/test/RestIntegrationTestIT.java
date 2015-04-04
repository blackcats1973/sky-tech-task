/**
 * 
 */
package net.chris.integration.test;

import static org.fest.assertions.Assertions.assertThat;
import net.chris.integration.billing.dto.BillDetails;
import net.chris.integration.facade.BillingFacade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Integration test which actually invokes a REST endpoint via the facade and ensures we get a valid response back.
 * 
 * @author Chris Hern
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-rest-integration-context.xml" })
public class RestIntegrationTestIT {

    @Autowired
    private BillingFacade billingFacade;

    @Test
    public void testRestIntegration() {
        // arrange

        // act
        final BillDetails billDetails = billingFacade.getBillDetails();

        // assert
        assertThat(billDetails).isNotNull();
        assertThat(billDetails.getStatement().getGenerated()).isNotNull();
    }
}
