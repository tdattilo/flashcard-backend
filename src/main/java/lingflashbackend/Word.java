package lingflashbackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Word{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer bookId;
	private Integer chId;
	private String foreignword;
	private String englishword;
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getBookId(){
		return bookId;
	}
	public void setBookId(Integer bookId){
		this.bookId=bookId;
	}
	public Integer getChId(){
		return chId;
	}
	public void setChId(Integer chId){
		this.chId=chId;
	}
	public String getForeignword(){
		return foreignword;
	}
	public void setForeinword(String foreignword){
		this.foreignword=foreignword;
	}
	public String getEnglishword(){
		return englishword;
	}
	public void setEnglishword(String englishword){
		this.englishword=englishword;
	}
}