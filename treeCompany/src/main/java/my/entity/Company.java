package my.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double invest;
	private double allInvest;
	private int level;
	@ManyToOne
	private Company parent;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
	private List<Company> children;

	public Company() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAllInvest() {
		return allInvest;
	}

	public void setAllInvest(double allInvest) {
		this.allInvest = allInvest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getInvest() {
		return invest;
	}

	public void setInvest(double invest) {
		this.invest = invest;
	}

	public List<Company> getChildren() {
		return children;
	}

	public void setChildren(List<Company> children) {
		this.children = children;
	}

	public Company getParent() {
		return parent;
	}

	public void setParent(Company parent) {
		this.parent = parent;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
