package models;

import models.Client.Type;

public class ClientView {
	private Long id;
	private String name;
	private String responsable;
	private String type;
	private Type enumType; 
	private String email;

	
	
	
	
	public ClientView(Client client) {
		super();
		this.id = client.getId();
		this.name = client.getName();
		this.responsable = client.getResponsable();
		this.type = client.getType();
		this.email = client.getEmail();
	}

	public ClientView() {
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

	@Override
	public String toString() {
		return "ClientView [id=" + id + ", name=" + name + ", responsable=" + responsable + ", type=" + type
				+ ", email=" + email + "]";
	}

	
	public Type getEnumType() {
		return enumType;
	}

	public void setEnumType(Type enumType) {
		this.enumType = enumType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ClientView other = (ClientView) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	
	
	
}
