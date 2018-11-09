package app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.model.User;

@Transactional
@Repository
public interface UserDAO extends JpaRepository<User, Long> {
	User findByLogin(String login);
}
