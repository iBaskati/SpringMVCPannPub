package models;



public class Client {
	private Long id;
	private String name;
	private String responsable;
	private String type;
	enum Type{ANNC, PROP } ; 
	private Type enumType; 
	private String email;
	private String password;
	private String passwordConf;
	
	
	
	
	public Client() {
		this.generateID();
	}

	private void generateID() {
		this.id = (Long) (long) (Math.random()*100000);
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
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getPasswordConf() {
		return passwordConf;
	}

	public void setPasswordConf(String passwordConf) {
		this.passwordConf = passwordConf;
	}

	

	public Type getEnumType() {
		return enumType;
	}

	public void setEnumType(Type enumType) {
		this.enumType = enumType;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", responsable=" + responsable + ", type=" + type + ", email="
				+ email + "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	public boolean isNull() {
		if(this.email == null || this.password== null) {
			return true;
		}
		return false;
	}

	
	
	
	
	
	
}
