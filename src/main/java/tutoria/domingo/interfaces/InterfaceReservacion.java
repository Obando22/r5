/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tutoria.domingo.interfaces;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tutoria.domingo.modelo.Reservacion;

/**
 *
 * @author USUARIO
 */
public interface InterfaceReservacion extends CrudRepository<Reservacion,Integer> {
    
    
   public List<Reservacion> findAllByStatus(String status);

    public List<Reservacion> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
        
    //SELECT c.client, COUNT(c.client)FROM Reservacion AS c group by c.client order by COUNT(c.client)DESC
    @Query("SELECT c.client, COUNT(c.client)FROM Reservacion AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservacionByClient(); 
    
    
}
