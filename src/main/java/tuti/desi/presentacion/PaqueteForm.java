package tuti.desi.presentacion;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class PaqueteForm {

    @NotNull
    private Long idOrigen;

    @NotNull
    private Long idDestino;

    @NotNull
    @DecimalMin(value = "0.01", message = "El peso debe ser mayor a 0")
    private Double peso;

    private boolean fragil;

    @NotNull
    @Pattern(regexp = "\\d{8}", message = "El DNI del remitente debe tener 8 dígitos")
    private String dniRemitente;

    @NotNull
    @Pattern(regexp = "\\d{8}", message = "El DNI del destinatario debe tener 8 dígitos")
    private String dniDestinatario;

    
    
    
    
    
    
    
    
    //---------------------------------------------
        public Long getIdOrigen() {
            return idOrigen;
        }

        public Long getIdDestino() {
            return idDestino;
        }

        public Double getPeso() {
            return peso;
        }

        public boolean isFragil() {
            return fragil;
        }

        public String getDniRemitente() {
            return dniRemitente;
        }

        public String getDniDestinatario() {
            return dniDestinatario;
        }

        
        public void setIdOrigen(Long idOrigen) {
            this.idOrigen = idOrigen;
        }

        public void setIdDestino(Long idDestino) {
            this.idDestino = idDestino;
        }

        public void setPeso(Double peso) {
            this.peso = peso;
        }

        public void setFragil(boolean fragil) {
            this.fragil = fragil;
        }

        public void setDniRemitente(String dniRemitente) {
            this.dniRemitente = dniRemitente;
        }

        public void setDniDestinatario(String dniDestinatario) {
            this.dniDestinatario = dniDestinatario;
        }
    
    
    
    
}
