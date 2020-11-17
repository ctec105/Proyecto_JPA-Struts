package proyecto.struts.dao.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import proyecto.struts.bean.Solicitud;
import proyecto.struts.bean.rpt.Rrt01;
import proyecto.struts.bean.rpt.Rrt02;
import proyecto.struts.dao.ReporteDAO;

public class JPAReporteDAO extends GenericDAOJpa<Long, Rrt01> implements
		ReporteDAO {

	EntityManager em = getEntityManager();

	@Override
	public List<Rrt01> reporte1(Date fecInicio, Date fecFin) throws Exception {
		// TODO Auto-generated method stub
		List<Rrt01> rst = new ArrayList<Rrt01>();
		try {

			Query q = em
					.createQuery("SELECT p.ruc, p.cliente, SUM(d.subtotal) "
							+ "FROM Prefactura p , Detalleprefactura d "
							+ "WHERE  p.id = d.idPrefactura "
							+ "AND   p.fecha >= ?1  AND p.fecha <= ?2 "
							+ "GROUP BY p.ruc, p.cliente");
			q.setParameter(1, fecInicio);
			q.setParameter(2, fecFin);
			Rrt01 rpt;
			Iterator it = q.getResultList().iterator();
			while (it.hasNext()) {
				Object[] par = (Object[]) it.next();
				rpt = new Rrt01();
				Double t = Double.parseDouble(par[2].toString());
				rpt.setRuc(par[0].toString());
				rpt.setNombre(par[1].toString());
				rpt.setTotal(t);
				rst.add(rpt);
			}
			return rst;
		} catch (Exception e) {
			e.printStackTrace();
			return rst;
			// TODO: handle exception
		}
	}

	@Override
	public List<Rrt02> reporte2() throws Exception {
		// TODO Auto-generated method stub
		List<Rrt02> rst = new ArrayList<Rrt02>();
		Rrt02 rpt;
		Query q = em
				.createQuery("SELECT s FROM Solicitud s WHERE s.estado.idestado =?1 ");
		q.setParameter(1, 1);
		Iterator it = q.getResultList().iterator();
		while (it.hasNext()) {
			Solicitud sol = new Solicitud();
			sol = (Solicitud) it.next();
			rpt = new Rrt02();
			rpt.setId(sol.getId());
			rpt.setDesc(sol.getDesc());
			rpt.setEquipo(sol.getEquipo().getNrotarjeta());
			rpt.setFecha(sol.getFecha());
			rpt.setRepresentante(sol.getRepresentante());
			rpt.setTelefono(sol.getTelefono());
			rpt.setHorometro(sol.getHorometro());
			rst.add(rpt);
		}
		return rst;
	}

}
