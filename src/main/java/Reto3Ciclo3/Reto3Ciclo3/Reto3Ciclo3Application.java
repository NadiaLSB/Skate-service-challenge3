package Reto3Ciclo3.Reto3Ciclo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/*
 *
 * @author NadiaS
 * @version 11.0.12
 */
@EntityScan(basePackages = {"Reto3Ciclo3.Reto3Ciclo3.model"})
@SpringBootApplication
public class Reto3Ciclo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3Ciclo3Application.class, args);
	}

}
