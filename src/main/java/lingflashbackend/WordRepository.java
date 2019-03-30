package lingflashbackend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import java.util;

import lingflashbackend.Word;

public interface WordRepository extends CrudRepository<Word, Integer>{
	@Nullable List<Word> findByChId(int chId);
}