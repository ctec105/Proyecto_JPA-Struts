package proyecto.struts.services;

import java.util.ArrayList;
import java.util.List;

import proyecto.struts.bean.Estado;
import proyecto.struts.bean.Solicitud;
import proyecto.struts.dao.DAOFactory;
import proyecto.struts.dao.SolicitudDAO;

public class SolicitudService {

	ArrayList listar;

	DAOFactory fabrica = DAOFactory.getDAOFactory(6);
	SolicitudDAO solicituddao = fabrica.getSolicitudDAO();

	public int inserta(Solicitud bean) throws Exception {
		// TODO Auto-generated method stub
		return solicituddao.inserta(bean);
	}

	public int edita(Solicitud bean) throws Exception {
		// TODO Auto-generated method stub
		return solicituddao.edita(bean);
	}

	public List<Solicitud> buscarSolicitud(int id, String tarj)
			throws Exception {
		// TODO Auto-generated method stub
		return solicituddao.buscarSolicitud(id, tarj);
	}

	public Solicitud getSolicitud(int i) throws Exception {
		// TODO Auto-generated method stub
		return solicituddao.getSolicitud(i);
	}

	public int elimina(Solicitud bean) throws Exception {
		// TODO Auto-generated method stub
		return solicituddao.elimina(bean);
	}

	public List<Solicitud> buscarSolicitud(String representante, int idEstado)
			throws Exception {
		// TODO Auto-generated method stub
		return solicituddao.buscarSolicitud(representante, idEstado);
	}
}
