package proyecto.struts.dao.jpa;

public interface GenericDAO<K, E> {

	void persist(E entity);

	void remove(E entity);

	E findById(K id);

}
