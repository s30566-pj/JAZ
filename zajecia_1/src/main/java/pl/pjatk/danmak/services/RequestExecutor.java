package pl.pjatk.danmak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.pjatk.danmak.interfaces.HandlerServiceInterface;

@Service
public class RequestExecutor {
    private String env;
    private FacadeService facadeService;

    @Autowired
    public RequestExecutor(@Value("${app.enviroment}" ) String env, FacadeService facadeService) {
        this.env = env;
        this.facadeService = facadeService;
        facadeService(execute(env));
    }
    private String execute(String env) {
        return switch (env) {
            case "prod" -> "prod";
            case "qa" -> "qa";
            case "dev" -> "dev";
            default -> "prod";
        };
    }
}
