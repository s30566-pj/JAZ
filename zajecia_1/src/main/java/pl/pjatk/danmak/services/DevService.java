package pl.pjatk.danmak.services;

import org.springframework.stereotype.Service;
import pl.pjatk.danmak.interfaces.HandlerServiceInterface;
@Service
public class DevService implements HandlerServiceInterface {
    public DevService() {
        System.out.println("DevService");
    }
}
