package proyecto.struts.bean;

import java.io.Serializable;

public class Permisos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int idArea;
	int idMenu;
	String nivel;
	String Titulo;
	String ver;
	int enc;

	public int getEnc() {
		return enc;
	}

	public void setEnc(int enc) {
		this.enc = enc;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

}
