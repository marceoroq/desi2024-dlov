package tuti.desi.presentacion;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.Paquete;
import tuti.desi.entidades.Persona;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.servicios.CiudadService;
import tuti.desi.servicios.PaqueteService;
import tuti.desi.servicios.PersonaService;

import java.util.List;

@Controller
@RequestMapping("/paqueteRegistrar")
public class PaqueteRegistrarController {

    @Autowired
    private PaqueteService paqueteService;

    @Autowired
    private CiudadService ciudadService;

    @Autowired
    private PersonaService personaService;

    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return ciudadService.getAll();
    }

    @GetMapping
    public String preparaForm(Model modelo) {
        modelo.addAttribute("formBean", new PaqueteForm());
        return "paqueteRegistrar";
    }

    @PostMapping
    public String submit(
            @ModelAttribute("formBean") @Valid PaqueteForm formBean,
            BindingResult result,
            Model modelo) {

        // Validar si el remitente existe en el sistema
        Persona remitente = personaService.findByDni(formBean.getDniRemitente());
        if (remitente == null) {
            result.rejectValue("dniRemitente", "error.dniRemitente", "El remitente no está registrado.");
        }

        // Validar si el destinatario existe en el sistema
        Persona destinatario = personaService.findByDni(formBean.getDniDestinatario());
        if (destinatario == null) {
            result.rejectValue("dniDestinatario", "error.dniDestinatario", "El destinatario no está registrado.");
        }

        // Verificar si hay errores en el formulario
        if (result.hasErrors()) {
            return "paqueteRegistrar";
        }

        try {
            // Crear y guardar el paquete
            Paquete paquete = new Paquete();
            paquete.setOrigen(new Ciudad());
            paquete.getOrigen().setId(formBean.getIdOrigen());
            paquete.setDestino(new Ciudad());
            paquete.getDestino().setId(formBean.getIdDestino());
            paquete.setPeso(formBean.getPeso());
            paquete.setFragil(formBean.isFragil());
            paquete.setRemitente(remitente); 
            paquete.setDestinatario(destinatario);

            paqueteService.save(paquete);
            return "redirect:/paqueteRegistrar?success=true";

        } catch (Excepcion e) {
            result.rejectValue("globalError", null, e.getMessage());
            return "paqueteRegistrar";
        }
    }
    

    @GetMapping("/cancelar")
    public String cancelar() {
        return "redirect:/"; 
    }
}
