package Com;

public class Employee {

	private int Eid;
	private String Name;
	private int Sal;

	public Employee(int eid, String name, int sal) {
		this.setEid(eid);
		this.setName(name);
		this.setSal(sal);
	}
	
	public Employee() {
		this.setEid(0);
		this.setName(null);
		this.setSal(0);
	}

	public void init(int eid, String name, int sal) {
		this.setEid(eid);
		this.setName(name);
		this.setSal(sal);
	}
	
	public void display() {
		System.out.println("ID = "+this.getEid()+" Name = "+this.getName()+" Sal = "+this.getSal());
	}

	public int getSal() {
		return Sal;
	}

	public void setSal(int sal) {
		Sal = sal;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getEid() {
		return Eid;
	}

	public void setEid(int eid) {
		Eid = eid;
	}

}
