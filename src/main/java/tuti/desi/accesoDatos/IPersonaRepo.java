package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tuti.desi.entidades.Persona;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Long> {

    // Consulta para buscar por DNI
    Persona findByDni(String dni);
}
