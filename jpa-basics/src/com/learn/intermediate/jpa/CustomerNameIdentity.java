package com.learn.intermediate.jpa;

public class CustomerNameIdentity {

	private String firstName;
    private String lastName;
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return lastName+", "+firstName;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof CustomerNameIdentity) {
			CustomerNameIdentity identity = (CustomerNameIdentity) obj;
			return this.toString().equals(identity.toString());
		} else {
			return false;
		}
	}
	
	@Override
    public int hashCode() {
    	return this.toString().hashCode();
    }
}
