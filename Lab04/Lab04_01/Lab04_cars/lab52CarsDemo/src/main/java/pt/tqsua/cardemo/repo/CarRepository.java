package pt.tqsua.cardemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.tqsua.cardemo.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByName(String name);

}
