package kh.example;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * CustomerOrder with 1-n relationship to Item_NoMappingToParent with 
 * deliberately no mapping back to parent. Illustrates that child side of
 * 1-n relationship by default manages the relationship - omitting this part of the relationship
 * results in not being able to create the relationship between child entities
 * and the parent (with JPA1.0). With JPA2.0, an implicit join table is 
 * created for the relationship
 * 
 * @author kevinhooke
 *
 */
@Entity
public class CustomerOrder_NoItemMapping {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@OneToMany
	private Set<Item_NoMappingToParent>items;
	
	public Set<Item_NoMappingToParent> getItems() {
		if(this.items == null){
			this.items = new HashSet<Item_NoMappingToParent>();
		}
		return items;
	}

	public void setItems(Set<Item_NoMappingToParent> items) {
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
