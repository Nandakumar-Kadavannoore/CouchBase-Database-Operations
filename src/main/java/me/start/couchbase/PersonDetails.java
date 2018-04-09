package me.start.couchbase;

/**
 * Details that to be stored in database
 * 
 * @author Nandakumar
 *
 */
public class PersonDetails {

	private String name;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person: Name='" + name + "', email=" + email;
	}

}
