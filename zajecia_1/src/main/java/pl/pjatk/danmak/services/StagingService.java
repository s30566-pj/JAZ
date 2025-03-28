package pl.pjatk.danmak.services;

import org.springframework.stereotype.Service;
import pl.pjatk.danmak.interfaces.HandlerServiceInterface;

@Service
public class StagingService implements HandlerServiceInterface {
    public String returnCommunicate(){
        return "Hello from Staging";
    }
}
