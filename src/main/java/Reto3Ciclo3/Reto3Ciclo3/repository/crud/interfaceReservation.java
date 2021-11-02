package Reto3Ciclo3.Reto3Ciclo3.repository.crud;

import Reto3Ciclo3.Reto3Ciclo3.model.entityReservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/*
 *
 * @author NadiaS
 * @version 11.0.12
 */
public interface interfaceReservation extends CrudRepository<entityReservation, Integer> {
    public List<entityReservation> findAllByStatus(String status);
    public List<entityReservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    @Query("SELECT c.client, COUNT(c.client) FROM entityReservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationByClient();

}
