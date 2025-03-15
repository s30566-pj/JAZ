package pl.pjatk.danmak.services;

import org.springframework.stereotype.Service;
import pl.pjatk.danmak.interfaces.HandlerServiceInterface;
@Service
public class QaService implements HandlerServiceInterface {
    public QaService() {
        System.out.println("QaService");
    }
}
