package proyecto.struts.services;

import java.util.ArrayList;
import java.util.List;

import proyecto.struts.dao.DAOFactory;
import proyecto.struts.bean.Cliente;
import proyecto.struts.dao.ClienteDAO;

public class ClienteService {
	ArrayList listar;

	DAOFactory fabrica = DAOFactory.getDAOFactory(6);
	ClienteDAO clientedao = fabrica.getClienteDAO();

	public Cliente getCliente(String idCliente) throws Exception {
		// TODO Auto-generated method stub
		return clientedao.getCliente(idCliente);
	}

	public List listarClientes() throws Exception {
		// TODO Auto-generated method stub
		return clientedao.listarClientes();
	}

	public int inserta(Cliente bean) throws Exception {
		// TODO Auto-generated method stub
		return clientedao.inserta(bean);
	}

	public int elimina(Cliente bean) throws Exception {
		// TODO Auto-generated method stub
		return clientedao.elimina(bean);
	}

	public int edita(Cliente bean) throws Exception {
		// TODO Auto-generated method stub
		return clientedao.edita(bean);
	}

	public List<Cliente> buscarCliente(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		return clientedao.buscarCliente(cliente);
	}
}
