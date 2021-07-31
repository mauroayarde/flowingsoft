package flowingsoft.com.ejercicio1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import flowingsoft.com.ejercicio1.models.HoraModelo;

@Repository
public interface HoraRepositorio extends CrudRepository<HoraModelo, Long> {

}
