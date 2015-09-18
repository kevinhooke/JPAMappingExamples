package kh.example;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

public class JPATests {

	private static EntityManager em;
			
	@BeforeClass
	public static void setup(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPU");
		em = emf.createEntityManager();
	}
	
	
	@Test
	public void testPersistOneToManyRelationship(){
		em.getTransaction().begin();
		
		CustomerOrder_NoItemMapping order = new CustomerOrder_NoItemMapping();
		Item_NoMappingToParent item = new Item_NoMappingToParent();
		
		//add item to order
		order.getItems().add(item);
		
		//normally you would also add item to order to item too to establish
		//the relationship as this is the driving side of the relationship
		//but in this case for the sake of illustration this is missing 
		
		//with JPA1.0 this would result in no association between the
		//two entities
		
		//with JPA2.0 a join table can be explicitly mapped to. If left out
		//and using hbm2ddl, a join table will be created and used for the relationship
		//the child table is created without an fk. The relationship is entirely described 
		//in the join table.
		
		em.persist(item);
		em.persist(order);
		em.getTransaction().commit();
		
		Long id = order.getId();
		assertNotNull(id);
		
		//to check that the fk to pk relationship is missing you need to look in the
		//tables
			
	}
	
}
