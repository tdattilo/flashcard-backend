package lingflashbackend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

import lingflashbackend.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	@Nullable Optional<Book> findByOwner(int owner);
}