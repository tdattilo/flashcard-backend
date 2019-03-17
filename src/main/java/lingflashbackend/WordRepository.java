package lingflashbackend;

import org.springframework.data.repository.CrudRepository;

import lingflashbackend.Word;

public interface WordRepository extends CrudRepository<Word, Integer>{
	@Nullable Optional<Word> findByChId(int chId);
}