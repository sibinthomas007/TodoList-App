package classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Todo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String title;

    private Boolean completed;

    private Integer uid;

	public Integer getId(){
		return this.id;
	}

	public String getTitle(){
		return this.title;
	}


	public Integer getUid(){
		return this.uid;
	}


	public  Boolean getCompleted(){
		return this.completed;
	}

	public void setUid(Integer uid){
		this.uid = uid;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public void setCompleted(Boolean completed){
		this.completed = completed;
	}
}
