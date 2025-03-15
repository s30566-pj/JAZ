package pl.pjatk.danmak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FacadeService {
    private String env;
    @Autowired
    public FacadeService() {
    }
    @Autowired
    public DevService conditionallyGetDevService( DevService devService ) {

    }
}
