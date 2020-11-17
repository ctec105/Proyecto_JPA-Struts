package proyecto.struts.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@Column(name = "id_usuario")
	private int codUsuario;
	private String nombre;
	private String ape_pat;
	private String ape_mat;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_ingreso")
	private Date ingreso;
	private String login;
	private String password;
	@Column(name = "tb_area_id_area")
	private int codArea;
	private int estado;

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Usuario() {

	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe_pat() {
		return ape_pat;
	}

	public void setApe_pat(String apePat) {
		ape_pat = apePat;
	}

	public String getApe_mat() {
		return ape_mat;
	}

	public void setApe_mat(String apeMat) {
		ape_mat = apeMat;
	}

	public Date getIngreso() {
		return ingreso;
	}

	public void setIngreso(Date ingreso) {
		this.ingreso = ingreso;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCodArea() {
		return codArea;
	}

	public void setCodArea(int codArea) {
		this.codArea = codArea;
	}

}
