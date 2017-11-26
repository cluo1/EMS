package entity;
/*实体类
 * 用来保存数据库中查询出来的数据
 * */
public class Employee {
	@Override
	public String toString() {
		return id+" "+name+" "+sal+" "+age;
	}
	private int id;
	private String name;
	private double sal;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
