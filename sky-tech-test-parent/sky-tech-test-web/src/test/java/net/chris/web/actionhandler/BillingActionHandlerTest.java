/**
 * 
 */
package net.chris.web.actionhandler;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import net.chris.integration.billing.dto.BillDetails;
import net.chris.integration.facade.BillingFacade;
import net.chris.integration.testdata.builder.BillDetailsTestDataBuilder;
import net.chris.web.converter.IntegrationConverterService;
import net.chris.web.spring.ApplicationContextProvider;
import net.chris.web.viewbean.billing.BillDetailsViewBean;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.context.ApplicationContext;

/**
 * Unit tests for {@link BillingActionHandler}.
 * 
 * @author Chris Hern
 * 
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ApplicationContextProvider.class)
public class BillingActionHandlerTest {

    @Mock
    private BillingFacade billingFacade;

    @Mock
    private IntegrationConverterService converterService;

    private BillingActionHandler actionHandler;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(ApplicationContextProvider.class);

        actionHandler = new BillingActionHandler();
    }

    @Test
    public void testGetBillDetailsPageBean() throws Exception {
        // arrange
        final BillDetails billDetails = BillDetailsTestDataBuilder.aBillDetails();
        final BillDetailsViewBean convertedPageBean = mock(BillDetailsViewBean.class);
        final ApplicationContext applicationContext = mock(ApplicationContext.class);

        when(ApplicationContextProvider.getApplicationContext()).thenReturn(applicationContext);
        when(applicationContext.getBean(BillingFacade.class)).thenReturn(billingFacade);
        when(applicationContext.getBean(IntegrationConverterService.class)).thenReturn(converterService);
        when(billingFacade.getBillDetails()).thenReturn(billDetails);
        when(converterService.convert(billDetails, BillDetailsViewBean.class)).thenReturn(convertedPageBean);

        actionHandler.init();

        // act
        final BillDetailsViewBean actionHandlerPageBean = actionHandler.getBillDetailsPageBean();

        // assert
        assertThat(actionHandlerPageBean).isEqualTo(convertedPageBean);
    }
}
