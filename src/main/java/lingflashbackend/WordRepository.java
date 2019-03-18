package lingflashbackend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

import lingflashbackend.Word;

public interface WordRepository extends CrudRepository<Word, Integer>{
	@Nullable Iterable<Word> findByChId(int chId);
}