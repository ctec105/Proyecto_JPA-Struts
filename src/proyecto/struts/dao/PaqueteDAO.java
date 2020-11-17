package proyecto.struts.dao;

import java.util.List;

import proyecto.struts.bean.Paquete;
import proyecto.struts.bean.Paquetesactividades;
import proyecto.struts.bean.Paquetesherramientas;
import proyecto.struts.bean.Paquetesmateriales;

public interface PaqueteDAO {

	public abstract Paquete getPaquete(int id) throws Exception;

	public abstract List buscarPaquete(String nro) throws Exception;

	public abstract List<Paquete> getPaquetes(int buscPaq,
			List<Paquete> paquetes) throws Exception;

	public abstract List<Paquete> getPaquetes() throws Exception;

	public abstract int insertar(Paquete paquete,
			List<Paquetesactividades> lstAct, List<Paquetesmateriales> lstMat,
			List<Paquetesherramientas> lstHer) throws Exception;

	public abstract int modificar(Paquete paquete,
			List<Paquetesactividades> lstAct, List<Paquetesmateriales> lstMat,
			List<Paquetesherramientas> lstHer) throws Exception;

	public abstract List<Paquetesherramientas> getHerramientasxId(int id)
			throws Exception;

	public abstract List<Paquetesmateriales> getMaterialesxId(int id)
			throws Exception;

	public abstract List<Paquetesactividades> getActividadesxId(int id)
			throws Exception;

	public abstract int eliminar(Paquete paquete) throws Exception;

	public abstract List<Paquete> popBuscarPaquetes(Paquete paquete)
			throws Exception;

}
