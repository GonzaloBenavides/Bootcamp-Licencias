package cl.gonzalobenavides.licenciasapi.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.gonzalobenavides.licenciasapi.model.License;
import cl.gonzalobenavides.licenciasapi.model.Persona;
import cl.gonzalobenavides.licenciasapi.repository.LicenciaRepository;
import cl.gonzalobenavides.licenciasapi.repository.PersonaRepository;

@Service
public class MainService {
	
	@Autowired
	private LicenciaRepository licenciaRepository;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	
	//==========PERSONAS=========================
	public void newPersona(Persona p) {
		personaRepository.save(p);
	}
	
	public Persona findPersona(Long id) {
		Optional<Persona> optional = personaRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	public List<Persona> findAllPersonas(){
		return personaRepository.findAll();
	}

	//==========LICENCIAS=========================
	public void newLicencia(License l) {
		l.setNumero(this.assignNumber());
		licenciaRepository.save(l);
	}
	
	public License findLicense(Long id) {
		Optional<License> optional = licenciaRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		else 
			return null;
	}
	
	public List<License> findAllLicencias(){
		return licenciaRepository.findAll();
	}
	
	//==========CROSS=========================
	public License getLastLicense() {
		List<License> licencias = licenciaRepository.findAll();
		if(licencias == null || licencias.isEmpty())
			return null;
		Collections.sort(licencias, (l1,l2) ->{ return Integer.valueOf(l1.getNumero()).compareTo(Integer.valueOf(l2.getNumero())); });
		
		return licencias.get(licencias.size()-1);
	}
	
	public String assignNumber() {
		License nueva = this.getLastLicense();
		String nuevoNumeroString = "";
		Integer nuevoNumero = 0;
		if(nueva == null) {
			return "0000000001";
		}
		else {
			nuevoNumero = Integer.valueOf(nueva.getNumero()) + 1;
			for(int i = 0; i < (10 - nuevoNumero.toString().length()); i++){
				nuevoNumeroString += "0";
			}
			nuevoNumeroString += nuevoNumero;
		}
		return nuevoNumeroString;
	}
	
	public void assignLicense() {
		List<License> licencias = licenciaRepository.findAll();
		List<Persona> personas = personaRepository.findAll();
		
		int count = 0;
		if(licencias == null || licencias.isEmpty())
			return;
		if(personas == null || personas.isEmpty())
			return;
		
		Collections.sort(licencias, (l1,l2) ->{ return Integer.valueOf(l2.getNumero()).compareTo(Integer.valueOf(l1.getNumero())); });
		Collections.sort(personas, (p1,p2) ->{ return Long.valueOf(p2.getId()).compareTo(Long.valueOf(p1.getId())); });
		
		for(Persona p : personas) {
			if(p.getLicencia() == null) {
				for(License l : licencias) {
					if(l.getPerson() == null) {
						p.setLicencia(l);
						l.setPerson(p);
						count++;
						break;
					}
				}
			}
		}
		licenciaRepository.saveAll(licencias);
		personaRepository.saveAll(personas);
		System.out.println("Se asignaron " + count + " licencias!");
	}
}
