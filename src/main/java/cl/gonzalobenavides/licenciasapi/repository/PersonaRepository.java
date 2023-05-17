package cl.gonzalobenavides.licenciasapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cl.gonzalobenavides.licenciasapi.model.License;
import cl.gonzalobenavides.licenciasapi.model.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long>{
	
	List<Persona> findAll();
}
