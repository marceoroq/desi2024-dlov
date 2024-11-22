package tuti.desi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuti.desi.accesoDatos.IPersonaRepo;
import tuti.desi.entidades.Persona;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private IPersonaRepo personaRepo;

    @Override
    public Persona findByDni(String dni) {
        return personaRepo.findByDni(dni);
    }
}
