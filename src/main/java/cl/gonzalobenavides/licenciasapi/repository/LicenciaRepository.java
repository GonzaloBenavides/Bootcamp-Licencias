package cl.gonzalobenavides.licenciasapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import cl.gonzalobenavides.licenciasapi.model.License;
import cl.gonzalobenavides.licenciasapi.model.Persona;

public interface LicenciaRepository extends CrudRepository<License, Long>{

	List<License> findAll();
}
