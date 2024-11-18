package tuti.desi.servicios;

import tuti.desi.entidades.Persona;

public interface PersonaService {
    Persona findByDni(String dni);
}
