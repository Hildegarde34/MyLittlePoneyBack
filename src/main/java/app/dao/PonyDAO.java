package app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.model.Pony;


@Transactional
@Repository
public interface PonyDAO extends JpaRepository<Pony, Long> {

}
