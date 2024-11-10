package tuti.desi.presentacion;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import tuti.desi.entidades.Camion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.servicios.CamionService;
import tuti.desi.servicios.CiudadService;

@Controller
@RequestMapping("/camionEditar")
public class CamionEditarController {
	@Autowired
	private CamionService servicioCamion;
	
	@Autowired
	private CiudadService servicioCiudad;

	@GetMapping(path = {"", "/{patente}"})
	public String preparaForm(Model modelo, @PathVariable("patente") Optional<String> patente)  throws Exception {
		if (patente.isPresent()) {
			// Obtener el camión por patente
			Camion entity = servicioCamion.getByPatente(patente.get());

			// Convertir la entidad Camion a CamionForm
			CamionForm form = new CamionForm(entity);

			modelo.addAttribute("formBean", form);
		} else {
			// Si no hay patente, crear un formulario vacío
			modelo.addAttribute("formBean", new CamionForm());
		}
		return "camionEditar";
	}
	
	@ModelAttribute("allCiudades")
	public List<Ciudad> getAllCiudades() {
		return this.servicioCiudad.getAll();
	}

	@PostMapping
	public String submit(
		@ModelAttribute("formBean") @Valid CamionForm formBean,
		BindingResult result,
		ModelMap modelo,
		@RequestParam String action
	) {
		if(action.equals("Aceptar")) {
			if(result.hasErrors()) {
				modelo.addAttribute("formBean", formBean);
				return "camionEditar";
			} else {
				try {
					// Verificamos si la patente ya existe en nuestra base de datos
					if(servicioCamion.getByPatente(formBean.getPatente()) != null) {
						// Si existe, agregamos el error y volvemos a misma pagina para mostrar el error
						FieldError error = new FieldError("formBean", "patente", "Ya existe un camión con esta patente");
						result.addError(error);
						modelo.addAttribute("formBean", formBean);
						return "camionEditar";
					}

					// Guardamos el camion si no hubo error en la validacion de la patente
					Camion camion = formBean.toPojo();
					camion.setCiudad(servicioCiudad.getById(formBean.getIdCiudad()));
					servicioCamion.save(camion);

					// Una vez guardado el camion, volvemos a la pagina principal
					return "redirect:/";
				} catch (Excepcion e) {
					if(e.getAtributo() == null) {
						ObjectError error = new ObjectError("globalError", e.getMessage());
						result.addError(error);
					} else {
						FieldError error1 = new FieldError("formBean", e.getAtributo(), e.getMessage());
						result.addError(error1);
					}
					modelo.addAttribute("formBean",formBean);
					return "camionEditar";  //Como existe un error me quedo en la misma pantalla
				}
			}
		}

		if(action.equals("Cancelar")) {
			modelo.clear();
		}

		return "redirect:/";
	}
}