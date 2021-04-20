package pt.tqsua.cardemo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pt.tqsua.cardemo.controller.CarNotFoundException;
import pt.tqsua.cardemo.entities.Car;
import pt.tqsua.cardemo.repo.CarRepository;
import pt.tqsua.cardemo.services.CarService;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService sutCarService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void getCarDetails_returnsCarInfo() {
        given( carRepository.findByName("prius")).willReturn( new Car("prius", "toyota"));
        Car car = sutCarService.getCarDetails( "prius");
        Assertions.assertThat( car.getName()).isEqualTo("prius");
    }

    @Test
    public void getCarDetails_whenDoesntExist_returnsException() {
        String nonExisting = "bad_car_name";
        given( carRepository.findByName( nonExisting )).willThrow(CarNotFoundException.class);

        Assertions.assertThatThrownBy( () -> { sutCarService.getCarDetails( nonExisting); }).isInstanceOf( CarNotFoundException.class );
    }

}