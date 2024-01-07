package repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.userlogin.user.model.UserInfo;

@Repository
public interface UserRepository extends MongoRepository<UserInfo, Integer>{

    Optional<UserInfo> findByEmail(String email);
}
