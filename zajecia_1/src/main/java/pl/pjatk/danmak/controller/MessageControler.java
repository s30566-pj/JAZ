package pl.pjatk.danmak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.danmak.components.Car;
import pl.pjatk.danmak.services.CarService;
import pl.pjatk.danmak.services.FacadeService;

@RestController
public class MessageControler {
    public final FacadeService facadeService;
    public final CarService carService;

    @Autowired
    public MessageControler(FacadeService facadeService, CarService carService){
        this.facadeService = facadeService;
        this.carService = carService;
    }

    @GetMapping("/message")
    public String getMessage() {
        return facadeService.execute();
    }

    @GetMapping("/test/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello world");

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
