package tuti.desi.presentacion;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import tuti.desi.accesoDatos.ICamionRepo;
import tuti.desi.accesoDatos.ICiudadRepo;
import tuti.desi.entidades.Camion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.servicios.CamionBuscarService;

@Controller
@RequestMapping("/camionBuscar")
public class CamionBuscarController {

    @Autowired
    private CamionBuscarService camionBuscarService;

    @Autowired
    private ICamionRepo camionRepo;  // Repositorio para obtener las patentes

    @Autowired
    private ICiudadRepo ciudadRepo;  // Repositorio para obtener los códigos postales

    // Método para mostrar el formulario
    @RequestMapping
    public String mostrarFormulario(Model model) {
        // Obtener todas las patentes de camiones
        List<String> patentes = camionRepo.findAll().stream()
                                           .map(Camion::getPatente)
                                           .distinct()
                                           .collect(Collectors.toList());

        // Obtener todos los códigos postales de las ciudades
        List<String> codigosPostales = ciudadRepo.findAll().stream()
                                                  .map(Ciudad::getCodigoPostal)
                                                  .distinct()
                                                  .collect(Collectors.toList());

        // Pasar las listas al modelo
        model.addAttribute("patentes", patentes);
        model.addAttribute("codigosPostales", codigosPostales);
        model.addAttribute("formBean", new CamionBuscarForm());

        return "camionBuscar";  // Nombre de la vista
    }

    // Método para realizar la búsqueda
    @PostMapping
    public String buscarCamiones(@Valid @ModelAttribute("formBean") CamionBuscarForm formBean,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            return "camionBuscar";
        }

        // Llamada al servicio para realizar la búsqueda con el formulario
        List<Ciudad> resultados = camionBuscarService.buscar(formBean);
        model.addAttribute("resultados", resultados);

        return "camionBuscar";
    }
}
