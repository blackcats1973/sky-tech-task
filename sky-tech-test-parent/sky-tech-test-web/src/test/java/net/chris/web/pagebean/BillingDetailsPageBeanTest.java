/**
 * 
 */
package net.chris.web.pagebean;

import static org.mockito.Mockito.verify;
import net.chris.web.actionhandler.BillingActionHandler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit tests for {@link BillingDetailsPageBean}.
 * 
 * @author Chris Hern
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class BillingDetailsPageBeanTest {

    @Mock
    private BillingActionHandler billingActionHandler;

    @InjectMocks
    private BillingDetailsPageBean pageBean = new BillingDetailsPageBean();

    @Test
    public void testInit() {
        // arrange

        // act
        pageBean.init();

        // assert
        verify(billingActionHandler).getBillDetailsPageBean();
    }
}
