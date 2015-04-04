/**
 * 
 */
package net.chris.integration.facade.rest;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import net.chris.integration.billing.dto.BillDetails;
import net.chris.integration.testdata.builder.BillDetailsTestDataBuilder;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.unitils.reflectionassert.ReflectionAssert;

/**
 * Unit tests for {@link RestBillingFacade}.
 * 
 * @author Chris Hern
 * 
 */
public class RestBillingFacadeTest {

    private MockRestServiceServer mockRestServiceServer;

    private final static String REQUEST_URL = "http://localhost/billingData";

    private RestBillingFacade billingFacade;

    @Before
    public void setup() {

        billingFacade = new RestBillingFacade(REQUEST_URL);
        mockRestServiceServer = MockRestServiceServer.createServer(billingFacade.getRestTemplate());
    }

    @Test
    public void testGetBillDetails() throws Exception {
        // arrange
        // final String billDetailsJsonString = TestResources.getJsonResource("sampleBillDetails");
        //
        // final BillDetails expectedBillDetails = mapper.readValue(billDetailsJsonString, BillDetails.class);

        final BillDetails expectedBillDetails = BillDetailsTestDataBuilder.aBillDetails();
        final String billDetailsJsonString = BillDetailsTestDataBuilder.aBillDetailsAsString(expectedBillDetails);

        mockRestServiceServer.expect(requestTo(REQUEST_URL)).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(billDetailsJsonString, MediaType.APPLICATION_JSON));

        // act
        final BillDetails actualBillDetails = billingFacade.getBillDetails();

        // assert
        ReflectionAssert.assertReflectionEquals(expectedBillDetails, actualBillDetails);
    }

}
