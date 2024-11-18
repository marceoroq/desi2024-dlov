package tuti.desi.servicios;

import tuti.desi.entidades.Paquete;
import tuti.desi.excepciones.Excepcion;

public interface PaqueteService {
    void save(Paquete paquete) throws Excepcion;
}
