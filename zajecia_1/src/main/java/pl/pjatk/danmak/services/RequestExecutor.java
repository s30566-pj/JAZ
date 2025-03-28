package pl.pjatk.danmak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RequestExecutor {
    private final FacadeService facadeService;

    @Autowired
    public RequestExecutor(FacadeService facadeService) {
        this.facadeService = facadeService;
        System.out.println(facadeService.execute());
    }
}
