/**
 * 
 */
package net.chris.integration.facade.rest;

import net.chris.integration.billing.dto.BillDetails;
import net.chris.integration.facade.BillingFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

/**
 * Implementation of the billing facade which integrates via REST.
 * 
 * @author Chris Hern
 * 
 */
@Controller
public class RestBillingFacade implements BillingFacade {

    private String restEndpoint;
    private RestTemplate restTemplate;

    @Autowired
    public RestBillingFacade(@Value("${rest.endpoint}") final String restEndpoint) {

        this.restEndpoint = restEndpoint;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public BillDetails getBillDetails() {

        final ResponseEntity<BillDetails> response = restTemplate.getForEntity(restEndpoint, BillDetails.class);

        return response.getBody();
    }

    /**
     * @return the restTemplate
     */
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

}
