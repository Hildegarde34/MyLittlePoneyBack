package app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.model.Role;

@Transactional
@Repository
public interface RoleDAO extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}