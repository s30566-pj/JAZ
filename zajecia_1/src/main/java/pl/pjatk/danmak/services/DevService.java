package pl.pjatk.danmak.services;

import org.springframework.stereotype.Service;
import pl.pjatk.danmak.interfaces.HandlerServiceInterface;

@Service("dev")
public class DevService implements HandlerServiceInterface {

    public String returnCommunicate(){
        return "Hello from Dev";
    }
}
