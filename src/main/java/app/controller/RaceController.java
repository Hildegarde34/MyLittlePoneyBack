package app.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@CrossOrigin(origins = "*")
	@GetMapping("/getRaces")
	public List<Race> getAllRaces() {
		return raceDAO.findAll();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/addRace")
	public Race addRace(@RequestBody Race race) {
		return raceDAO.save(race);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/deleteRace/{id}")
	public void deleteRace(@PathParam("id") long id) {
		raceDAO.deleteById(id);
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/updateRace/{id}")
	public Race updateRace(@PathVariable("id") Long id, @RequestBody @Valid Race race) {
			return raceDAO.save(race);
	
	}

}


