package Database;

import java.io.Serializable;

/**
 * The persistent class for the student database table.
 * 
 */
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	public Student(int id, String address, String name) {
		this.id = id;
		this.address = address;
		this.name = name;
	}

	private int id;

	private String address;

	private String name;

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}