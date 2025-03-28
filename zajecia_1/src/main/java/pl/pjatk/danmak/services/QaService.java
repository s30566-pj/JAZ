package pl.pjatk.danmak.services;

import org.springframework.stereotype.Service;
import pl.pjatk.danmak.interfaces.HandlerServiceInterface;
@Service("qa")
public class QaService implements HandlerServiceInterface {
    public String returnCommunicate(){
        return "Hello from Qa";
    }
}
