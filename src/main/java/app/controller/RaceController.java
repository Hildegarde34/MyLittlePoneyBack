package app.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dao.RaceDAO;
import app.model.Race;

@RestController
@RequestMapping("/Race")
public class RaceController {

	@Autowired
	RaceDAO raceDAO;

	@GetMapping("/getRaces")
	public List<Race> getAllRaces() {
		return raceDAO.findAll();
	}

	@PostMapping("/addRace")
	public Race addRace(@RequestBody @Valid Race race) {
		return raceDAO.save(race);
	}

	@DeleteMapping("/deleteRace/{id}")
	public void deleteRace(@PathParam("id") long id) {
		raceDAO.deleteById(id);
	}
	
}
