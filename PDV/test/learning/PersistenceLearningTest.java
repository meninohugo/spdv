package learning;


import org.junit.Before;
import org.junit.Test;
import pdv.domain.Fabricante;
import pdv.persistence.GenericDao;

public class PersistenceLearningTest {
	
	Fabricante fabricante = new Fabricante();
	GenericDao<Fabricante> fabricanteDao = new GenericDao<Fabricante>("pdv");	
	
	@Before
	public void init(){
		fabricante.setNome("Gambers");
	}
	
	@Test
	public void insertTest(){
		fabricanteDao.insert(fabricante);	
	}
	
	@Test
	public void updateTest(){
		Fabricante up = (Fabricante)fabricanteDao.findById(1, Fabricante.class);
		up.setNome("Novo");
		fabricanteDao.update(up);
	}
	
	@Test 
	public void updateGambiTest(){
		fabricante.setId(3);
		fabricanteDao.updateDetached(fabricante);
	}
	
	@Test
	public void deleteTest(){
		fabricanteDao.delete(fabricanteDao.findById(3, Fabricante.class));
	}
	
}
