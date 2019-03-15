package lingflashbackend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

import lingflashbackend.People;

public interface PeopleRepository extends CrudRepository<People, Integer>{
	@Nullable People findByUnameAndPw(String uname, String pw);
	boolean existsById(Integer id);
}