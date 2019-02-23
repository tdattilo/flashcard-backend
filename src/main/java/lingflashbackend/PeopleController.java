package lingflashbackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class People{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String uname;
	private String pw;
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public String getUname(){
		return uname;
	}
	public void setUname(String uname){
		this.uname=uname;
	}
	public String getPw(){
		return pw;
	}
	public void setPw(String pw){
		this.pw=pw;
	}
}