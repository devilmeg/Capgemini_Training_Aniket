package Jan18Practice;

public class Employee {
	private int id;
	private String name;
	
	@Override // We override the existing equals because Default equals() is useless for real objects as it compares memory, not meaning.
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!(obj instanceof Employee)) return false;
		Employee e = (Employee) obj;
		return this.id == e.id;
	}
	
	@Override 
	public int hashCode() {
		return Integer.hashCode(id);
	}
}
