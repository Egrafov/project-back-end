package store.users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    EntityManager entityManager = null;

    public static boolean existsByUsername(String userName) {
        Query query = entityManager.createQuery("SELECT COUNT(u) FROM User u WHERE u.userName = :userName");
        query.setParameter("userName", userName);
        Long count = (Long) query.getSingleResult();
        return count > 0;
    }

}
