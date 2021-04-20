package pt.tqsua.cardemo;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import pt.tqsua.cardemo.entities.Car;
import pt.tqsua.cardemo.repo.CarRepository;

@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository repository;

    @Autowired
    private TestEntityManager entityManager; //actual insert, forces use of hibernate
    // direct use of the respository, does not reproduce the actual use of the bd

   @Test
   public void getCar_retursCarDetails() {
       Car saverCar = entityManager.persistAndFlush( new Car("prius", "toyota"));

       Car car = repository.findByName( "prius");

       Assertions.assertThat( car.getName()).isEqualTo( saverCar.getName());
    }

}