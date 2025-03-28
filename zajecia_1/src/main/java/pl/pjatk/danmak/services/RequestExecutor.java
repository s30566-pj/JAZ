package pl.pjatk.danmak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestExecutor {

    @Autowired
    public RequestExecutor(FacadeService facadeService) {
        System.out.println(facadeService.execute());
    }
}
