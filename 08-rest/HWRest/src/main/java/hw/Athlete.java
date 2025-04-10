package hw;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Athlete")
public class Athlete {
	private int id ;
	private int height;
	private String fullname;
	private String email;
	public Athlete () {
	}
	public Athlete(int id, String fullname, String email, int height) {
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.height = height;
	}
	@XmlElement(name = "id")
	public int getID() {
		return id;
	}
	public void setID(int iD) {
		id = iD;
	}
	@XmlElement(name = "name")
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	@XmlElement(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement(name = "height")
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
