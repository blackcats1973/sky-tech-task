/**
 * 
 */
package net.chris.web.converter.billing;

import static org.fest.assertions.Assertions.assertThat;
import net.chris.integration.billing.dto.BillDetails;
import net.chris.integration.testdata.builder.BillDetailsTestDataBuilder;
import net.chris.web.viewbean.billing.BillDetailsViewBean;

import org.junit.Before;
import org.junit.Test;

/**
 * Junit tests for {@link BillingDetailsConverter}.
 * 
 * @author Chris Hern
 * 
 */
public class BillingDetailsConverterTest {

    private BillingDetailsConverter converter;

    @Before
    public void setup() {

        converter = new BillingDetailsConverter();
    }

    @Test
    public void testConvert() throws Exception {
        // arrange
        final BillDetails billDetails = BillDetailsTestDataBuilder.aBillDetails();

        // act
        final BillDetailsViewBean billDetailsPageBean = converter.convert(billDetails);

        // assert
        assertThat(billDetailsPageBean.getTotal()).isEqualTo(billDetails.getTotal());

        assertThat(billDetailsPageBean.getCallCharges().getTotal()).isEqualTo(billDetails.getCallCharges().getTotal());
        assertThat(billDetailsPageBean.getCallCharges().getCalls().size()).isEqualTo(billDetails.getCallCharges().getCalls().size());

        assertThat(billDetailsPageBean.getChosenPackage().getTotal()).isEqualTo(billDetails.getPackage().getTotal());
        assertThat(billDetailsPageBean.getChosenPackage().getSubscriptions().size()).isEqualTo(billDetails.getPackage().getSubscriptions().size());

        assertThat(billDetailsPageBean.getSkyStore().getTotal()).isEqualTo(billDetails.getSkyStore().getTotal());
        assertThat(billDetailsPageBean.getSkyStore().getRentals().size()).isEqualTo(billDetails.getSkyStore().getRentals().size());
        assertThat(billDetailsPageBean.getSkyStore().getBuyAndKeep().size()).isEqualTo(billDetails.getSkyStore().getBuyAndKeep().size());

        assertThat(billDetailsPageBean.getStatement().getDue()).isEqualTo(billDetails.getStatement().getDue());
        assertThat(billDetailsPageBean.getStatement().getGenerated()).isEqualTo(billDetails.getStatement().getGenerated());
        assertThat(billDetailsPageBean.getStatement().getPeriod().getFrom()).isEqualTo(billDetails.getStatement().getPeriod().getFrom());
        assertThat(billDetailsPageBean.getStatement().getPeriod().getTo()).isEqualTo(billDetails.getStatement().getPeriod().getTo());
    }
}
