package pl.pjatk.danmak.services;

import org.springframework.stereotype.Service;
import pl.pjatk.danmak.interfaces.HandlerServiceInterface;

@Service("prod")
public class ProdService implements HandlerServiceInterface {
    public String returnCommunicate(){
        return "Hello from Prod";
    }
}
