package pagetest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonJPA {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 20, nullable = false)
	private String name;
	@Column(length = 4, nullable = false)
	private Integer age;
	@Column(length = 20, nullable = false)
	private String address;

	public PersonJPA() {
		super();
	}

	public PersonJPA(Long id, String name, Integer age, String address) {
		super();
		//this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString(){
		return "PersonJPA [id="+id+",name="+name+",age="+age+",address="+address+"]";
	}

}