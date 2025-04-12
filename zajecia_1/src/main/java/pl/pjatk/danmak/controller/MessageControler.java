package pl.pjatk.danmak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.danmak.components.Car;
import pl.pjatk.danmak.services.DeleteLogic;
import pl.pjatk.danmak.services.PutLogic;
import pl.pjatk.danmak.services.CarService;
import pl.pjatk.danmak.services.FacadeService;
import pl.pjatk.danmak.services.MessageService;

@RestController
public class MessageControler {
    private final FacadeService facadeService;
    private final CarService carService;
    private final PutLogic putLogic;
    private final MessageService messageService;
    private final DeleteLogic deleteLogic;

    @Autowired
    public MessageControler(FacadeService facadeService, CarService carService, MessageService messageService, PutLogic putLogic, DeleteLogic deleteLogic){
        this.facadeService = facadeService;
        this.carService = carService;
        this.messageService = messageService;
        this.putLogic = putLogic;
        this.deleteLogic = deleteLogic;
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

    @GetMapping("/homework/{model}")
    public ResponseEntity<String> byPathVariableHomework(@PathVariable("model") String model){
        return ResponseEntity.ok(new Car(model).getModel());
    }

    @GetMapping("/homework")
    public ResponseEntity<String> byRequestParamHomework(@RequestParam("model") String model){
        return ResponseEntity.ok(new Car(model).getModel());
    }

    @PutMapping("/homework/{someText}")
    public ResponseEntity<String> putMappingHomework(@RequestBody String tung, @PathVariable("someText") String sahur){
        return ResponseEntity.ok(putLogic.returnPut(tung, sahur));
    }

    @PostMapping("/homework")
    public ResponseEntity<String> postMappingHomework(@RequestBody String lirilirilila){
        return ResponseEntity.ok(lirilirilila);
    }
    @DeleteMapping("/homework/{bombardiro}")
    public ResponseEntity<Void> deleteMappingHomework(@PathVariable(value = "bombardiro", required = false) String crocodilo){
        return ResponseEntity.status(deleteLogic.returnIfGood(crocodilo)).build();
    }
    @DeleteMapping("/homework")
    public ResponseEntity<Void> deleteMappingHomework(){
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/exception")
    public ResponseEntity<Exception> throwException(){
        throw new RuntimeException("Test exception");
    }

}

