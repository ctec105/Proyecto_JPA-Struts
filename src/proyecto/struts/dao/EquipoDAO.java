package proyecto.struts.dao;

import java.util.List;

import proyecto.struts.bean.Equipo;
import proyecto.struts.bean.Paquete;

public interface EquipoDAO {

	public abstract List<Equipo> buscarEquipo(String nroTarjeta, int clase)
			throws Exception;

	public abstract Equipo getEquipo(String nroTarjeta) throws Exception;

	public abstract int inserta() throws Exception;

	public abstract int edita() throws Exception;

	public abstract int elimina() throws Exception;
}
