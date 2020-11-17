package proyecto.struts.dao;

import java.util.List;

import proyecto.struts.bean.Cliente;

public interface ClienteDAO {

	public abstract Cliente getCliente(String idCliente) throws Exception;

	public abstract List<Cliente> listarClientes() throws Exception;

	public abstract int inserta(Cliente bean) throws Exception;

	public abstract int elimina(Cliente bean) throws Exception;

	public abstract int edita(Cliente bean) throws Exception;

	public abstract List<Cliente> buscarCliente(Cliente cliente)
			throws Exception;

}
