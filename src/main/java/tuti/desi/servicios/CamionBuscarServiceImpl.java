package tuti.desi.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.ICamionRepo;
import tuti.desi.accesoDatos.ICiudadRepo;
import tuti.desi.entidades.Camion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.CamionBuscarForm;

@Service
public class CamionBuscarServiceImpl implements CamionBuscarService {

    @Autowired
    private ICiudadRepo ciudadRepo;
    
    @Autowired 
    private ICamionRepo camionRepo;

    @Override
    public List<Ciudad> buscar(CamionBuscarForm form) {
        // Validar criterios de búsqueda
        if ((form.getPatente() == null || form.getPatente().isEmpty()) &&
            (form.getCodigoPostal() == null || form.getCodigoPostal().isEmpty())) {
            throw new IllegalArgumentException("Debe ingresar al menos un criterio de búsqueda.");
        }

        List<Ciudad> resultados = null;

        try {
            if (form.getPatente() != null && !form.getPatente().isEmpty()) {
                // Usar ICamionRepo para buscar el camión por patente
                Optional<Camion> camion = camionRepo.findByPatente(form.getPatente());
                if (camion.isEmpty()) {
                    throw new Excepcion("No se encontró un camión con esa patente.");
                }

                // Obtener la ciudad asociada al camión
                resultados = List.of(camion.get().getCiudad());
            } else {
                // Buscar ciudades por código postal
                resultados = ciudadRepo.findByCodigoPostal(form.getCodigoPostal());
            }
    
            // Validar si no se encontraron resultados
            if (resultados == null || resultados.isEmpty()) {
                throw new Excepcion("No se encontraron resultados para los criterios ingresados.");
            }
        } catch (Excepcion ex) {
            try {
                // Propagar la excepción o agregar un mensaje específico
                throw ex; // Aquí podrías re-lanzar la excepción o agregar más detalles si es necesario.
            } catch (Excepcion ex1) {
            }
        }

        return resultados;
    }
}
