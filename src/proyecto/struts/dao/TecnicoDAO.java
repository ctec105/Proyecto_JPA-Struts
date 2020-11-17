package proyecto.struts.dao;

import java.util.List;

import proyecto.struts.bean.Tecnico;

public interface TecnicoDAO {

	public abstract List buscarTecnico(String nombre) throws Exception;

	public abstract Tecnico getTecnico(int id) throws Exception;

	public abstract List<Tecnico> popBuscarTecn(Tecnico tecnico)
			throws Exception;

}
