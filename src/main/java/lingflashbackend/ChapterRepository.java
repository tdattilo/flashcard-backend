package lingflashbackend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

import lingflashbackend.Chapter;

public interface ChapterRepository extends CrudRepository<Chapter, Integer>{
	@Nullable Iterable<Chapter> findByBookId(int bookId);
}