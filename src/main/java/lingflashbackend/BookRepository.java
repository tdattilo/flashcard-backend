package lingflashbackend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import java.util.Optional;

import lingflashbackend.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	@Nullable Iterable<Book> findByOwner(int owner);
}