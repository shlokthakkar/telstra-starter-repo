package au.com.telstra.simcardactivator.service;

import au.com.telstra.simcardactivator.model.SimActivationRequest;
import au.com.telstra.simcardactivator.model.SimActivationResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SimActivationService {

    private static final String ACTUATOR_URL = "http://localhost:8444/actuate";
    private final RestTemplate restTemplate = new RestTemplate();

    public boolean activateSim(SimActivationRequest request) {
        try {
            SimActivationResponse response = restTemplate.postForObject(ACTUATOR_URL, request, SimActivationResponse.class);
            return response != null && response.isSuccess();
        } catch (Exception e) {
            return false;
        }
    }
}
