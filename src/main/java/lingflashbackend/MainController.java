package lingflashbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.json.*;
import java.util.Optional;

import lingflashbackend.People;
import lingflashbackend.PeopleRepository;
import lingflashbackend.Book;
import lingflashbackend.BookRepository;
import lingflashbackend.Chapter;
import lingflashbackend.ChapterRepository;
import lingflashbackend.Word;
import lingflashbackend.WordRepository;


@RestController
@RequestMapping(path="/calls")
public class MainController {

	@Autowired
	private PeopleRepository peopleRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private ChapterRepository chapterRepository;
	@Autowired
	private WordRepository wordRepository;

	@PostMapping(path="/unpw")
	public @ResponseBody String login(@RequestBody String data){
		
		JSONObject parsedData = new JSONObject(data);
		if(parsedData!=null){
			if(parsedData.has("username")){
				if(parsedData.has("password")){
					People p = new People();
					p = peopleRepository.findByUnameAndPw(parsedData.getString("username"), parsedData.getString("password"));
					if(p!=null){
						String response = "{\"response\":\"" + p.getId() + "\"}";
						return response;
						}
					return "{\"response\":\"Unsuccessful Attempt.\"}";
				}
			}
		}
		return "{\"response\":\"Unsuccessful Attempt.\"}";
	}

	@PostMapping(path="/books")
	public @ResponseBody Iterable<Book> getBooks(@RequestBody String data){
		JSONObject parsedData = new JSONObject(data);
		if(parsedData!=null){
			if(parsedData.has("user_id")){
					return bookRepository.findByOwner(parsedData.getInt("user_id"));
			}
		}
		return null;
	}
	@PostMapping(path="/chapters")
	public @ResponseBody Iterable<Chapter> getChapters(@RequestBody String data){
		JSONObject parsedData = new JSONObject(data);
		if(parsedData!=null){
			if(parsedData.has("book_id")){
					return chapterRepository.findByBookId(parsedData.getInt("book_id"));
			}
		}
		return null;
	}
	@PostMapping(path="/words")
	public @ResponseBody Iterable<Word> getWords(@RequestBody String data){
		JSONObject parsedData = new JSONObject(data);
		if(parsedData!=null){
			if(parsedData.has("ch_id")){
					return wordRepository.findByChId(parsedData.getInt("ch_id"));
			}
		}
		return null;
	}
}