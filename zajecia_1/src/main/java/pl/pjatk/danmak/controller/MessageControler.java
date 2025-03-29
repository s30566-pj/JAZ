package pl.pjatk.danmak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.danmak.services.FacadeService;

@RestController
public class MessageControler {
    public final FacadeService facadeService;

    @Autowired
    public MessageControler(FacadeService facadeService){
        this.facadeService = facadeService;
    }

    @GetMapping("/message")
    public String getMessage() {
        return facadeService.execute();
    }

    @GetMapping("/test/hello")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<String>("Hello world", HttpStatusCode.valueOf(200));
    }
}
