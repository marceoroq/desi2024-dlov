package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tuti.desi.entidades.Paquete;

@Repository
public interface IPaqueteRepo extends JpaRepository<Paquete, Long> {
}
