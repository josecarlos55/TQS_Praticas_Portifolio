package pt.tqsua.cardemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pt.tqsua.cardemo.entities.Car;
import pt.tqsua.cardemo.services.CarService;
import pt.tqsua.cardemo.controller.CarNotFoundException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CarControllerTest {

    @Autowired
    MockMvc servlet;

    @MockBean
    CarService carService;

    @Test
    public void whenGetCar_theReturnCar() throws Exception {
        given( carService.getCarDetails( anyString())).willReturn( new Car("prius", "toyota"));

        servlet.perform(MockMvcRequestBuilders.get("/cars/prius"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("prius"));
    }

    @Test
    public void whenGetInexistingCar_theReturnNothing() throws Exception {
        String not_valid_car = "not_valid_car";

        given( carService.getCarDetails(not_valid_car)).willThrow( new CarNotFoundException() );

        servlet.perform(MockMvcRequestBuilders.get("/cars/".concat(not_valid_car)))
                .andExpect(status().isNotFound());
    }
}
