package tuti.desi.presentacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Provincia;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.servicios.CiudadService;
import tuti.desi.servicios.ProvinciaService;


@Controller
@RequestMapping("/ciudadesBuscar")
public class CiudadesBuscarController {
	@Autowired
	private ProvinciaService servicioProvincia;

	@Autowired
	private CiudadService servicioCiudad;


	@RequestMapping(method = RequestMethod.GET)
	public String preparaForm(Model modelo) {
    	CiudadesBuscarForm form = new CiudadesBuscarForm();
//    	form.setProvincias(servicioProvincia.getAll());    //  en lugar de esto hacemos @ModelAttribute("allProvincias")
    	modelo.addAttribute("formBean", form);
    	return "ciudadesBuscar";
    }

    @ModelAttribute("allProvincias")
    public List<Provincia> getAllProvincias() {
        return this.servicioProvincia.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(
    	@ModelAttribute("formBean") @Valid CiudadesBuscarForm formBean,
    	BindingResult result,
    	ModelMap modelo,
    	@RequestParam String action
    ) throws Excepcion {
    	if(action.equals("Buscar")) {
    		try {
    			List<Ciudad> ciudades = servicioCiudad.filter(formBean);
    			modelo.addAttribute("resultados", ciudades);
    		} catch (Exception e) {
    			ObjectError error = new ObjectError("globalError", e.getMessage());
    			result.addError(error);
    		}
    		modelo.addAttribute("formBean", formBean);
    		return "ciudadesBuscar";
    	}

    	if(action.equals("Cancelar")) {
    		modelo.clear();
    		return "redirect:/";
    	}

    	if(action.equals("Registrar")) {
    		modelo.clear();
    		return "redirect:/ciudadEditar";
    	}

    	return "redirect:/";
    }
}