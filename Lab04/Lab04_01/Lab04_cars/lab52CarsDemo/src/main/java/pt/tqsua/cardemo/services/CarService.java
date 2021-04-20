package pt.tqsua.cardemo.services;

import org.springframework.stereotype.Service;
import pt.tqsua.cardemo.entities.Car;
import pt.tqsua.cardemo.repo.CarRepository;

@Service
public class CarService {


    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }



    public Car getCarDetails(String key) {
        return  carRepository.findByName( key);
    }
}
