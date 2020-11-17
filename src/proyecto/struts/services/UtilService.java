package proyecto.struts.services;

import java.util.ArrayList;
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
import proyecto.struts.dao.DAOFactory;
import proyecto.struts.dao.UtilDAO;

public class UtilService {

	ArrayList listar;

	DAOFactory fabrica = DAOFactory.getDAOFactory(6);
	UtilDAO utildao = fabrica.getUtilDAO();

	public List lista(String table) throws Exception {
		// TODO Auto-generated method stub
		return utildao.lista(table);
	}

	public UtilBean getUtil(String table, String id) throws Exception {
		// TODO Auto-generated method stub
		return utildao.getUtil(table, id);
	}

	public List<Marca> listMarca() throws Exception {
		return utildao.listMarca();
	}

	public List<Modelo> listModelo() throws Exception {
		// TODO Auto-generated method stub
		return utildao.listModelo();
	}

	public List<Modelo> listModelo(String marca) throws Exception {
		// TODO Auto-generated method stub
		return utildao.listModelo(marca);
	}

	public Paquetesmateriales getMaterial(int buscMat) throws Exception {
		// TODO Auto-generated method stub
		return utildao.getMaterial(buscMat);
	}

	public Paquetesherramientas getHerramienta(int buscHer) throws Exception {
		// TODO Auto-generated method stub
		return utildao.getHerramienta(buscHer);
	}

	public Paquetesactividades getActividad(int buscAct) throws Exception {
		// TODO Auto-generated method stub
		return utildao.getActividad(buscAct);
	}

	public List<ClaseEquipo> getClasesEquipos() throws Exception {
		// TODO Auto-generated method stub
		return utildao.getClasesEquipos();
	}

	public List<Estado> getEstados() throws Exception {
		// TODO Auto-generated method stub
		return utildao.getEstados();
	}

	public List<Especialidad> listEspecialidad() throws Exception {
		// TODO Auto-generated method stub
		return utildao.listEspecialidad();
	}

	public List<Paquetesherramientas> popBucarHerramienta(
			Paquetesherramientas herramienta) throws Exception {
		// TODO Auto-generated method stub
		return utildao.popBucarHerramienta(herramienta);
	}

	public List<Paquetesactividades> popBuscarActividad(
			Paquetesactividades actividad) throws Exception {
		// TODO Auto-generated method stub
		return utildao.popBuscarActividad(actividad);
	}

	public List<Paquetesmateriales> popBuscarMaterial(
			Paquetesmateriales material) throws Exception {
		// TODO Auto-generated method stub
		return utildao.popBuscarMaterial(material);
	}

	public Area getArea(int codArea) throws Exception {
		// TODO Auto-generated method stub
		return utildao.getArea(codArea);
	}

}
