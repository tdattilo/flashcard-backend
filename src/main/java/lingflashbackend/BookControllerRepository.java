package lingflashbackend;

import org.springframework.data.repository.CrudRepository;

import lingflashbackend.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

}