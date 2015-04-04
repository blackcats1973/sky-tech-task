/**
 * 
 */
package net.chris.integration.testdata.builder;

import net.chris.integration.billing.dto.BillDetails;
import net.chris.integration.test.util.TestResources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * Class for creating instances of {@link BillDetails} to be used in unit tests.
 * 
 * @author Chris Hern
 * 
 */
public final class BillDetailsTestDataBuilder {

    public static BillDetails aBillDetails() throws Exception {

        final ObjectMapper mapper = new ObjectMapper();

        final String billDetailsJsonString = TestResources.getJsonResource("sampleBillDetails");

        return mapper.readValue(billDetailsJsonString, BillDetails.class);
    }

    public static String aBillDetailsAsString(final BillDetails billDetails) throws Exception {

        final ObjectWriter writer = new ObjectMapper().writer();

        return writer.writeValueAsString(billDetails);
    }
}
