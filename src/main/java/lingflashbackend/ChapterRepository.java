package lingflashbackend;

import org.springframework.data.repository.CrudRepository;

import lingflashbackend.Chapter;

public interface ChapterRepository extends CrudRepository<Chapter, Integer>{
	@Nullable Optional<Chapter> findByBookId(int bookId);
}