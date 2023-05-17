package cl.gonzalobenavides.licenciasapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.gonzalobenavides.licenciasapi.model.License;
import cl.gonzalobenavides.licenciasapi.model.Persona;
import cl.gonzalobenavides.licenciasapi.service.MainService;
import jakarta.validation.Valid;

@Controller
public class LicenciaController {

	@Autowired
	private MainService mainService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Persona> personas = mainService.findAllPersonas();
		List<License> licencias = mainService.findAllLicencias();
		model.addAttribute("personas",personas);
		model.addAttribute("licencias",licencias);
		return "index.jsp";
	}
	
	@GetMapping("persona/new")
	public String newPersona(@ModelAttribute("persona") Persona persona) {
		return "newPerson.jsp";
	}
	
	@GetMapping("licencia/new")
	public String newLicencia(@ModelAttribute("licencia") License licencia) {
		return "newLicense.jsp";
	}
	
	@PostMapping("persona/new")
	public String newPersona(@Valid @ModelAttribute("persona") Persona persona, BindingResult res) {
		if(res.hasErrors()) {
			return "newPerson.jsp";
		}
		else
			mainService.newPersona(persona);
		
		mainService.assignLicense();
		return "redirect:/";
	}
	
	@PostMapping("licencia/new")
	public String newLicencia(@Valid @ModelAttribute("licencia") License licencia, BindingResult res) {
		
//		licencia.setNumero(mainService.assignNumber());
		if(res.hasErrors()) {
			return "newLicense.jsp";
		}
		else
			mainService.newLicencia(licencia);
		
		mainService.assignLicense();
		return "redirect:/";
	}
}
