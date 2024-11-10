/**
 * @author oroquieta
 *
 */
package tuti.desi.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.ICamionRepo;
import tuti.desi.entidades.Camion;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.CiudadesBuscarForm;

@Service
public class CamionServiceImpl implements CamionService {
	
	@Autowired
	ICamionRepo repo;

	@Override
	public List<Camion> getAll() {
		return repo.findAll();
	}

	@Override
	public Camion getByPatente(String patenteCamion) {
		Optional<Camion> camionOptional = repo.findByPatente(patenteCamion);
		if (camionOptional.isPresent()) {
			return camionOptional.get();
		} else {
			return null;
		}
	}

	@Override
	public void deleteByPatente(String patenteCamion) {
		repo.deleteByPatente(patenteCamion);
	}

	@Override
	public void save(Camion c) throws Excepcion {
		repo.save(c);
	}
}
