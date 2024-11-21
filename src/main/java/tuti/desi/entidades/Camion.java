package tuti.desi.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Camion {

    @Id
    private String patente;

    @ManyToOne
    private Ciudad ciudad;

    private String marca;

    private Integer modelo;

    // Getters y setters
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente.toUpperCase();
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }
}