package com.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="users")
@NamedQueries({
	//WE use class name along with class variable
	@NamedQuery(name= "Users.findAll",query="SELECT u FROM Users u ORDER BY u.fullname"),
	@NamedQuery(name= "Users.findByEmail",query="SELECT u FROM Users u WHERE u.email = :email"),
	@NamedQuery(name= "Users.countAll",query="SELECT Count(*) FROM Users u"),
	@NamedQuery(name= "Users.checkLogin",query="SELECT u FROM Users u WHERE u.email = :email AND password = :password")
	
	
})
public class Users {

    private Integer userid;
    private String email;
    private String fullname;
    private String password;
    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getUserid() {
        return userid;
    }
    public Users() {
    	
    }
    public Users(String email, String fullname, String password) {
		
		this.email = email;
		this.fullname = fullname;
		this.password = password;
	}

	public Users(Integer userid, String email, String fullname, String password) {
		this.userid = userid;
		this.email = email;
		this.fullname = fullname;
		this.password = password;
	}
	public void setUserid(Integer userid) {
        this.userid = userid;
    }
    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name="full_name")
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    @Column(name="password")
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    

}

