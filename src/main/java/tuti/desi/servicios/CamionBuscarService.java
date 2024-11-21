package tuti.desi.servicios;

import java.util.List;

import tuti.desi.entidades.Ciudad;
import tuti.desi.presentacion.CamionBuscarForm;

public interface CamionBuscarService {
    /**
     * Busca ciudades basándose en los criterios de patente y/o código postal.
     *
     * @param form Objeto que contiene los criterios de búsqueda.
     * @return Lista de ciudades que coinciden con los criterios.
     */
    List<Ciudad> buscar(CamionBuscarForm form);
}
