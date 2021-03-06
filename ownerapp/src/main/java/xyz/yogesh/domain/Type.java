package xyz.yogesh.domain;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "types", catalog = "petclinic")
public class Type {

	private Integer id;
	private String name;
	private Set<Pet> pets;

	public Type() {
	}

	public Type(String name, Set<Pet> pets) {
		this.name = name;
		this.pets = pets;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 80)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
	public Set<Pet> getPets() {
		return this.pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

}
