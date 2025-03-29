package pl.pjatk.danmak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return ResponseEntity.ok(messageService.responseEntity(reqParam));
        }


    @PostMapping("/test/model")
    public ResponseEntity<Car> getSomeObject(@RequestBody(required = false) Car car){
        return ResponseEntity.ok(carService.retunCar(car));
    }

    @GetMapping("/test/hello/{someValue}")
    public ResponseEntity<String> someValue(@PathVariable("someValue") String wartosc){
        return ResponseEntity.ok(wartosc);
    }

}
