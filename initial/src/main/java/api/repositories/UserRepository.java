package repositories;

import org.springframework.data.repository.CrudRepository;

import classes.User;
import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
}
