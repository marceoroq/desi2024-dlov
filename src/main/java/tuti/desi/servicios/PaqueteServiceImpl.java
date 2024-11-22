package tuti.desi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IPaqueteRepo;
import tuti.desi.accesoDatos.ICiudadRepo;
import tuti.desi.entidades.Paquete;
import tuti.desi.excepciones.Excepcion;

@Service
public class PaqueteServiceImpl implements PaqueteService {

    @Autowired
    private IPaqueteRepo paqueteRepo;

    @Autowired
    private ICiudadRepo ciudadRepo;

    @Override
    public void save(Paquete paquete) throws Excepcion {
        // Verificar que el destino y peso sean válidos
        if (paquete.getDestino() == null || paquete.getPeso() == null) {
            throw new Excepcion("El destino y el peso son obligatorios");
        }

        // Guardar el paquete
        paqueteRepo.save(paquete);
    }
}
