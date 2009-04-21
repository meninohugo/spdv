package pdv.persistence;

@SuppressWarnings("unchecked")
public interface Dao<Model>{
	
	void insert(Model model);
	void delete(Model model);
	void update(Model model);	
	Model findById(int id,Class clazz);
	
}