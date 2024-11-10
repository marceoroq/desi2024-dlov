package tuti.desi.servicios;


import java.util.List;

import tuti.desi.entidades.Camion;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.CiudadesBuscarForm;
/**
 * Clase que permite gestionar la entidad Camion en el sistema.
 * @author oroquieta
 * @version 1.0
 */

public interface CamionService {
	/**
	 * Obtiene la lista completa de camiones
	 * @return Todos los camiones
	 */
	List<Camion> getAll();
	
	/**
	 * Obtiene un camion determinado
	 * @param patente Identificador del camion buscado
	 * @return camion encontrado
	 */
	Camion getByPatente(String patenteCamion) ;

	void deleteByPatente(String patenteCamion);

	void save(Camion c) throws Excepcion;

}
