package lingflashbackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chapter{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String chaptitle;
	private Integer bookId;
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public String getChaptitle(){
		return title;
	}
	public void setChaptitle(String chaptitle){
		this.chaptitle=chaptitle;
	}
	public Integer getBookId(){
		return bookId;
	}
	public void setBookId(Integer bookId){
		this.bookId=bookId;
	}
}