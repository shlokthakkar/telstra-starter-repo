package au.com.telstra.simcardactivator.controller;


import au.com.telstra.simcardactivator.model.SimActivationRequest;
import au.com.telstra.simcardactivator.service.SimActivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sim")
public class SimActivationController {

    @Autowired
    private final SimActivationService simActivationService;

    public SimActivationController(SimActivationService simActivationService) {
        this.simActivationService = simActivationService;
    }

    @PostMapping("/activate")
    public ResponseEntity<String> activateSim(@RequestBody SimActivationRequest request) {
        boolean success = simActivationService.activateSim(request);
        return success ? ResponseEntity.ok("SIM Activation Successful") : ResponseEntity.badRequest().body("SIM Activation Failed");
    }
}
