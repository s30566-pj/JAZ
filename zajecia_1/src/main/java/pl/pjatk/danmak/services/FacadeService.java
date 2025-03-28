package pl.pjatk.danmak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.pjatk.danmak.interfaces.HandlerServiceInterface;

import java.util.Map;

@Service
public class FacadeService {
    @Value("${app.environment:dev}")
    private String env;
    private final Map<String, HandlerServiceInterface> services;
    @Autowired
    public FacadeService(Map<String, HandlerServiceInterface> services) {
        this.services = services;
    }


    public String execute(){
        HandlerServiceInterface service = services.get(env);
        if (service == null){
            return "Invalid environment: " + env;
        }

        return service.returnCommunicate();

    }
}
