package proyecto.struts.dao.jpa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import proyecto.struts.bean.Detalleprefactura;
import proyecto.struts.bean.Equipo;
import proyecto.struts.bean.Paquete;
import proyecto.struts.bean.Prefactura;
import proyecto.struts.dao.PrefacturaDAO;

public class JPAPrefacturaDAO extends GenericDAOJpa<Long, Prefactura> implements
		PrefacturaDAO {

	EntityManager em = getEntityManager();

	@Override
	public List<Detalleprefactura> getDetFactPaq(Prefactura prefactura)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			Query q = em.createNamedQuery("findPaqDetFact");
			q.setParameter("idLiquidacion", prefactura.getLiquidacion().getId());
			Iterator it = q.getResultList().iterator();
			int i = 1;
			List<Detalleprefactura> rst = new ArrayList<Detalleprefactura>();
			while (it.hasNext()) {
				Object[] par = (Object[]) it.next();
				System.out.println(par[1].toString() + " : "
						+ par[2].toString() + " : " + par[3].toString() + " : "
						+ par[4].toString() + " : " + par[5].toString());

				int idl = ((Integer) par[0]).intValue();
				int item = ((Integer) par[1]).intValue();
				String desc = par[2].toString();
				Double pu = (Double) par[3];
				Double subttl = (Double) par[4];
				String cant = par[5].toString();
				int icant = Integer.parseInt(cant);
				System.out.println(item + " : " + desc + " : " + cant + " : "
						+ icant);

				Detalleprefactura df = new Detalleprefactura();
				// df.setId(i);
				df.setId(idl);
				df.setIdPrefactura(prefactura.getId());
				df.setItem(item);
				df.setDescripcion(desc);
				df.setPrecio_unitario(pu);
				df.setSubtotal(subttl);
				df.setCantidad(icant);
				rst.add(df);
				i++;
			}
			System.out.println("Nro. Item: " + rst.size());
			return rst;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Detalleprefactura> getDetFactTec(Prefactura prefactura)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			Query q = em.createNamedQuery("findTecDetFact");
			q.setParameter("idLiquidacion", prefactura.getLiquidacion().getId());
			Iterator it = q.getResultList().iterator();
			int i = 1;
			List<Detalleprefactura> rst = new ArrayList<Detalleprefactura>();
			while (it.hasNext()) {
				Object[] par = (Object[]) it.next();
				System.out.println(par[1].toString() + " : "
						+ par[2].toString() + " : " + par[3].toString() + " : "
						+ par[4].toString() + " : " + par[5].toString());

				int idl = ((Integer) par[0]).intValue();
				int item = ((Integer) par[1]).intValue();
				String desc = par[2].toString();
				Double pu = (Double) par[3];
				String horas = par[4].toString();
				Double subttl = pu * (Double.parseDouble(horas));
				String cant = par[5].toString();
				int icant = Integer.parseInt(horas);
				System.out.println(item + " : " + desc + " : " + cant + " : "
						+ icant);

				Detalleprefactura df = new Detalleprefactura();
				//df.setId(i);
				df.setId(idl);
				df.setIdPrefactura(prefactura.getId());
				df.setItem(item);
				df.setDescripcion(desc);
				df.setPrecio_unitario(pu);
				df.setSubtotal(subttl);
				df.setCantidad(icant);
				rst.add(df);
				i++;
			}
			System.out.println("Nro. Item: " + rst.size());
			return rst;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void insertar(Prefactura prefactura, List<Detalleprefactura> detalles)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(prefactura);
			em.getTransaction().commit();
			prefactura = buscarPFxNoID(prefactura);
			if (prefactura != null) {
				Iterator it = detalles.iterator();

				while (it.hasNext()) {
					Detalleprefactura dp = new Detalleprefactura();
					dp = (Detalleprefactura) it.next();
					dp.setIdPrefactura(prefactura.getId());
					dp.setPrecio_total(0.0);
					em.getTransaction().begin();
					em.persist(dp);
					em.getTransaction().commit();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private Prefactura buscarPFxNoID(Prefactura p) {
		// TODO Auto-generated method stub
		try {
			Query q = em
					.createQuery("SELECT p FROM Prefactura p Where p.cliente =?1 AND p.fecha =?2 AND p.liquidacion.id =?3 ORDER BY p.id DESC ");
			q.setParameter(1, p.getCliente());
			q.setParameter(2, p.getFecha());
			q.setParameter(3, p.getLiquidacion().getId());

			List<Prefactura> rst = q.getResultList();
			if (rst.size() > 0) {
				return rst.get(0);
			}
			return null;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Prefactura> listarPrefacturas() throws Exception {
		// TODO Auto-generated method stub
		try {
			Query q = em.createQuery("SELECT p FROM Prefactura p");

			return q.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
