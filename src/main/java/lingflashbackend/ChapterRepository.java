package lingflashbackend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import java.util.Optional;

import lingflashbackend.Chapter;

public interface ChapterRepository extends CrudRepository<Chapter, Integer>{
	@Nullable Optional<Chapter> findByBookId(int bookId);
}