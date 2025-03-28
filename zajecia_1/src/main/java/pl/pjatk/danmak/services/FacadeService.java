package pl.pjatk.danmak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FacadeService {
    @Value("${app.environment:dev}")
    private String env;
    private final DevService devService;
    private final ProdService prodService;
    private final QaService qaService;
    private final StagingService stagingService;
    @Autowired
    public FacadeService(DevService devService, ProdService prodService, QaService qaService, StagingService stagingService) {
        this.devService = devService;
        this.prodService = prodService;
        this.qaService = qaService;
        this.stagingService = stagingService;
    }


    public String execute(){
        return switch (env) {
            case "dev" -> devService.returnCommunicate();
            case "qa" -> qaService.returnCommunicate();
            case "prod" -> prodService.returnCommunicate();
            case "staging" -> stagingService.returnCommunicate();
            default -> "Invalid environment: " + env;
        };

    }
}
