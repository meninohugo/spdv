package pdv.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class GenericDao<Model> implements Dao<Model> {
	
	private EntityManager entityManager;
	
	public GenericDao(String persistenceUnit) {
		entityManager = Persistence
			.createEntityManagerFactory(persistenceUnit)
			.createEntityManager();
		entityManager.getTransaction().begin();
	}
	
	@Override
	public void delete(Model model) {
		entityManager.remove(model);
		entityManager.getTransaction().commit();		
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public Model findById(int id, Class clazz) {
		return (Model)entityManager.find(clazz, id);		
	}

	@Override
	public void insert(Model model) {
		entityManager.persist(model);
		entityManager.getTransaction().commit();
	}

	@Override
	public void update(Model model) {
		entityManager.persist(model);		
		entityManager.getTransaction().commit();
	}
	
	public void updateDetached(Model model){
		entityManager.merge(model);
		entityManager.getTransaction().commit();
	}
	
}
