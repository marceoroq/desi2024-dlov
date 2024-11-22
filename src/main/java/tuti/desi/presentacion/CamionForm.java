package tuti.desi.presentacion;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import tuti.desi.entidades.Camion;

/**
 * Objeto necesario para insertar o eliminar un camión.
 * En lugar de referenciar al objeto Ciudad, reemplazamos ese atributo por el idCiudad, 
 * lo que hace más sencillo representarlo en JSON.
 */
public class CamionForm {

    @NotNull
    @Pattern(regexp = "^([A-Za-z]{2}[0-9]{3}[A-Za-z]{2})|([A-Za-z]{3}[0-9]{3})$", message = "La patente debe tener el formato correcto (ej. AB123CD o ABC123)")
    private String patente;

    @NotBlank(message = "La marca es obligatoria")
    private String marca;
    
    @NotNull(message = "El modelo es obligatorio")
    @Min(value = 1800, message = "El modelo debe ser mayor al año 1800")
    @Max(value = 2025, message = "El modelo debe ser menor al año 2026")
    private Integer modelo;

    @NotNull
    private Long idCiudad; // id de la ciudad (referencia)

    public CamionForm() {
        super();
    }

    public CamionForm(Camion camion) {
        super();
        this.patente = camion.getPatente();
        this.marca = camion.getMarca();
        this.modelo = camion.getModelo();
        this.idCiudad = camion.getCiudad() != null ? camion.getCiudad().getId() : null;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
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

    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    /**
     * Convierte el CamionForm a un objeto Camion.
     */
    public Camion toPojo() {
        Camion camion = new Camion();
        camion.setPatente(this.getPatente());
        camion.setMarca(this.getMarca());
        camion.setModelo(this.getModelo());
        return camion;
    }
}
