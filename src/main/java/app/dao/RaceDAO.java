package app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.model.Race;

@Transactional
@Repository
public interface RaceDAO extends JpaRepository<Race, Long> {

}

