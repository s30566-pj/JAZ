package pl.pjatk.danmak.services;

import org.springframework.stereotype.Service;
import pl.pjatk.danmak.components.Car;

@Service
public class CarService {

    public Car retunCar(Car car){
        if (car == null) {
            return new Car(12, "nfeof31f31", "Folkswagen", "Passeratti");
        } else {
            return car;
        }
    }
}
