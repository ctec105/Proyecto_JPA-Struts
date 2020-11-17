package proyecto.struts.dao;

import java.util.List;

import proyecto.struts.bean.Area;
import proyecto.struts.bean.ClaseEquipo;
import proyecto.struts.bean.Especialidad;
import proyecto.struts.bean.Estado;
import proyecto.struts.bean.Marca;
import proyecto.struts.bean.Modelo;
import proyecto.struts.bean.Paquetesactividades;
import proyecto.struts.bean.Paquetesherramientas;
import proyecto.struts.bean.Paquetesmateriales;
import proyecto.struts.bean.UtilBean;

public interface UtilDAO {

	public abstract List lista(String table) throws Exception;

	public abstract UtilBean getUtil(String table, String id) throws Exception;

	public abstract List<Marca> listMarca() throws Exception;

	public abstract List<Modelo> listModelo() throws Exception;

	public abstract List<Modelo> listModelo(String marca) throws Exception;

	public abstract Paquetesmateriales getMaterial(int buscMat)
			throws Exception;

	public abstract Paquetesherramientas getHerramienta(int buscHer)
			throws Exception;

	public abstract Paquetesactividades getActividad(int buscAct)
			throws Exception;

	public abstract List<ClaseEquipo> getClasesEquipos() throws Exception;

	public abstract List<Estado> getEstados() throws Exception;

	public abstract List<Especialidad> listEspecialidad() throws Exception;

	public abstract List<Paquetesherramientas> popBucarHerramienta(
			Paquetesherramientas herramienta) throws Exception;

	public abstract List<Paquetesactividades> popBuscarActividad(
			Paquetesactividades actividad) throws Exception;

	public abstract List<Paquetesmateriales> popBuscarMaterial(
			Paquetesmateriales material) throws Exception;

	public abstract Area getArea(int codArea) throws Exception;

}
