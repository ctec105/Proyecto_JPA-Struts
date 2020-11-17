package proyecto.struts.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import proyecto.struts.bean.Equipo;
import proyecto.struts.dao.EquipoDAO;

public class JPAEquipoDAO extends GenericDAOJpa<Long, Equipo> implements EquipoDAO {

	@Override
	public List<Equipo> buscarEquipo(String nroTarjeta, int clase)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			Query q = getEntityManager()
					.createQuery(
							"SELECT e FROM Equipo e WHERE e.nrotarjeta like ?1 AND e.claseEquipo = ?2");
			q.setParameter(1, "%" + nroTarjeta + "%");
			q.setParameter(2, clase);
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public int edita() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int elimina() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Equipo getEquipo(String nroTarjeta) throws Exception {
		System.out.print("nroTarjeta:  " + nroTarjeta);
		try {
			return getEntityManager().find(Equipo.class, nroTarjeta);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public int inserta() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
