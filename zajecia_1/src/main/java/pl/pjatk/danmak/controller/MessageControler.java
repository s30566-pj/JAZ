package pl.pjatk.danmak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.danmak.components.Car;
import pl.pjatk.danmak.services.CarService;
import pl.pjatk.danmak.services.FacadeService;
import pl.pjatk.danmak.services.MessageService;

@RestController
public class MessageControler {
    public final FacadeService facadeService;
    public final CarService carService;

    public final MessageService messageService;

    @Autowired
    public MessageControler(FacadeService facadeService, CarService carService, MessageService messageService){
        this.facadeService = facadeService;
        this.carService = carService;
        this.messageService = messageService;
    }

    @GetMapping("/message")
    public String getMessage() {
        return facadeService.execute();
    }

    @GetMapping("/test/hello")
    public ResponseEntity<String> hello(@RequestParam(required = false) String reqParam){
        return messageService.responseEntity(reqParam);
        }


    @GetMapping("/test/model")
    public ResponseEntity<Car> returnedCar(){
        return ResponseEntity.ok(carService.retunCar());
    }

    @GetMapping("/test/hello/{someValue}")
    public ResponseEntity<String> someValue(@PathVariable("someValue") String wartosc){
        return ResponseEntity.ok(wartosc);
    }

}
