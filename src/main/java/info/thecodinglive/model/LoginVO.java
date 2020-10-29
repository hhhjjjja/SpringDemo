package info.thecodinglive.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
//@Table(name="user")
public class LoginVO implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
	private String id;
	
	private String password;
//	private String name;
//	private String phone;
//	private String email;
//	private int auth;
	
	public void test() {
		System.out.println("id = " + id);
		System.out.println("pw = " + password);
//		System.out.println("name = " + name);
//		System.out.println("phone = " + phone);
	}
}
