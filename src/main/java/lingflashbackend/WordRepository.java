package lingflashbackend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import java.util.Optional;

import lingflashbackend.Word;

public interface WordRepository extends CrudRepository<Word, Integer>{
	@Nullable Optional<Word> findByChId(int chId);
}