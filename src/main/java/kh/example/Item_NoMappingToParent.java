package kh.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Many side of 1-n mapping from CustomerOrder to Item_NoMappingToParent.
 * 
 * Illustrates that by default, the child side of the 1-n relationship
 * needs to be mapped back to the parent for the relationship to be managed
 * by JPA.
 * 
 * @author kevinhooke
 *
 */
@Entity
public class Item_NoMappingToParent {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
}
