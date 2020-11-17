package proyecto.struts.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

	private static final String PERSISTENCE_UNIT_NAME = "MI_PERSISTENCIA";

	private static EntityManagerFactory factory;

	// Obtener el Manejador de objetos JPA mediante la clase Persistence
	public static EntityManagerFactory getEntityManagerFactory() {

		if (factory == null)

			factory = Persistence
					.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

		return factory;

	}

}
