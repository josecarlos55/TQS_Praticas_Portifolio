package pt.tqsua.cardemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pt.tqsua.cardemo.entities.Car;
import pt.tqsua.cardemo.repo.CarRepository;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class CarDemoApiIntegrationTest {

    @Autowired
    private TestRestTemplate restClient;

    @Autowired
    private CarRepository repository;

    @BeforeEach
    public void setUpTestCars() throws Exception {
        repository.saveAndFlush(new Car("zoe", "renault"));
        repository.saveAndFlush(new Car("prius", "toyota"));

    }

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    }


    @Test
    void getCar_returnsCarDetailsTest() {
        ResponseEntity<Car> entity = restClient.getForEntity("/cars/prius", Car.class);

        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody().getName()).isEqualTo("prius");
    }

}
