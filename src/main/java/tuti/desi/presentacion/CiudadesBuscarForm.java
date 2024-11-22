package tuti.desi.presentacion;

import java.util.List;

import tuti.desi.entidades.Provincia;

public class CiudadesBuscarForm {
	private String nombre;
	private Long provinciaSeleccionada;
	private List<Provincia> provincias;

	//agregado
	private String CodigoPostal;

	public List<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}
	
	public Long getProvinciaSeleccionada() {
		return provinciaSeleccionada;
	}
	
	public void setProvinciaSeleccionada(Long provinciaSeleccionada) {
		this.provinciaSeleccionada = provinciaSeleccionada;
	}
	
	public String getNombre() {
		if(nombre != null && nombre.length() > 0)
			return nombre;
		else
			return null;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//agregado
	public String getCodigoPostal() {
		if(CodigoPostal != null && CodigoPostal.length() > 0)
			return CodigoPostal;
		else
			return null;
	}
	
	public void setCodigoPostal(String CodigoPostal) {
		this.CodigoPostal = CodigoPostal;
	}
	

}