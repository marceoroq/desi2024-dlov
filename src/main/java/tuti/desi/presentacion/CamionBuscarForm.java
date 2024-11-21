package tuti.desi.presentacion;

import tuti.desi.entidades.Camion;
import tuti.desi.entidades.Ciudad;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CamionBuscarForm {

    private String patente;
    private String codigoPostal;

    // Constructor vacío
    public CamionBuscarForm() {
    }

    // Getters y Setters
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
