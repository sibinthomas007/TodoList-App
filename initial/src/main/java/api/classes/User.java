package classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String username;

    private String password;

	public Integer getId(){
		return this.id;
	}

	public String getUsername(){
		return this.username;
	}

	public  String getPassword(){
		return this.password;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public void setPassword(String password){
		this.password = password;
	}
}
