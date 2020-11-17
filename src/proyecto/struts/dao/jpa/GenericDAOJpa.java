package proyecto.struts.dao.jpa;

import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import proyecto.struts.util.JpaUtils;

public abstract class GenericDAOJpa<K, E> implements GenericDAO<K, E> {

	protected Class<E> entityClass;

	protected EntityManager entityManager;

	public GenericDAOJpa() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass
				.getActualTypeArguments()[1];
	}

	public void persist(E entity) {
		entityManager.persist(entity);
	}

	public void remove(E entity) {
		entityManager.remove(entity);
	}

	public E findById(K id) {
		return entityManager.find(entityClass, id);
	}

	public EntityManager getEntityManager() {

		if (entityManager == null)

			entityManager = JpaUtils.getEntityManagerFactory()
					.createEntityManager();

		return entityManager;

	}

}