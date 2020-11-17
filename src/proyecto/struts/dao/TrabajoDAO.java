package proyecto.struts.dao;

import java.util.Hashtable;
import java.util.List;

import proyecto.struts.bean.Ordentrabajo;
import proyecto.struts.bean.Ordentrabajo_has_tecnicos;
import proyecto.struts.bean.Paquete;
import proyecto.struts.bean.Paquetes_has_ordentrabajo;
import proyecto.struts.bean.Tecnico;
import proyecto.struts.bean.Trabajo;

public interface TrabajoDAO {

	public abstract List buscarTrabajo(String estado) throws Exception;

	public abstract Ordentrabajo getTrabajo(int id) throws Exception;

	public abstract List<Paquetes_has_ordentrabajo> getPaquetes(int idTrabajo) throws Exception;

	public abstract List<Ordentrabajo_has_tecnicos> getTenicos(int idTrabajo) throws Exception;

	public abstract int inserta(Trabajo bean, Hashtable<String, Paquete> paquetes, Hashtable<String, Tecnico> tecnicos)
			throws Exception;

	public abstract int insertar(Ordentrabajo trabajo, List<Paquete> paquetes, List<Tecnico> tecnicos) throws Exception;

	public abstract List<Ordentrabajo> listar() throws Exception;

	public abstract int actualizar(Ordentrabajo trabajo, List<Paquete> paquetes, List<Tecnico> tecnicos)
			throws Exception;

	public abstract void actualizar(Ordentrabajo ot) throws Exception;

}
