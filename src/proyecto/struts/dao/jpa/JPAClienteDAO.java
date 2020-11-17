package proyecto.struts.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import proyecto.struts.bean.Cliente;
import proyecto.struts.dao.ClienteDAO;

public class JPAClienteDAO extends GenericDAOJpa<Long, Cliente> implements
		ClienteDAO {

	@Override
	public int edita(Cliente bean) throws Exception {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().merge(bean);
			getEntityManager().getTransaction().commit();
			return 0;
		} catch (Exception e) {
			return 1;
		}
	}

	@Override
	public int elimina(Cliente bean) throws Exception {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().remove(bean);
			getEntityManager().getTransaction().commit();
			return 0;
		} catch (Exception e) {
			return 1;
		}
	}

	@Override
	public Cliente getCliente(String idCliente) throws Exception {
		// TODO Auto-generated method stub
		try {
			return getEntityManager().find(Cliente.class, idCliente);
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}

	@Override
	public int inserta(Cliente bean) throws Exception {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(bean);
		getEntityManager().getTransaction().commit();

		return 0;
	}

	@Override
	public List<Cliente> listarClientes() throws Exception {
		// TODO Auto-generated method stub
		Query q = getEntityManager().createQuery(
				"select u from Cliente u Where u.id <> '9999999999'");

		List<Cliente> results = q.getResultList();

		System.out.println("Registros encontrados :" + results.size());

		return results;
	}

	@Override
	public List<Cliente> buscarCliente(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		Query q = getEntityManager()
				.createQuery(
						"select u from Cliente u Where u.id <> '9999999999' And u.id like ?1 AND u.razonSoc like ?2 ");
		q.setParameter(1, "%" + cliente.getId() + "%");
		q.setParameter(2, "%" + cliente.getRazonSoc() + "%");
		List<Cliente> results = q.getResultList();

		System.out.println("Registros encontrados :" + results.size());

		return results;
	}

}
