package tuti.desi.accesoDatos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Camion;

@Repository
public interface ICamionRepo extends JpaRepository<Camion, String> {

	Optional<Camion> findByPatente(String patenteCamion);
	
	@Query("DELETE FROM Camion c WHERE c.patente = ?1")
	void deleteByPatente(String patenteCamion);
	
  @Override
	void deleteAll();
}
