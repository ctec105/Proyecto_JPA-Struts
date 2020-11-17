package proyecto.struts.dao;

import java.util.List;

import proyecto.struts.bean.Solicitud;

public interface SolicitudDAO {

	public abstract int inserta(Solicitud bean) throws Exception;

	public abstract int edita(Solicitud bean) throws Exception;

	public abstract int elimina(Solicitud bean) throws Exception;

	public abstract List<Solicitud> buscarSolicitud(int id, String tarj)
			throws Exception;

	public abstract Solicitud getSolicitud(int i) throws Exception;

	public abstract List<Solicitud> buscarSolicitud(String representante,
			int idEstado) throws Exception;

}
