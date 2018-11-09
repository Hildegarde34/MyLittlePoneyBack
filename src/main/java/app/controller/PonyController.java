package app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
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

import app.dao.PonyDAO;
import app.dao.RaceDAO;
import app.exceptions.ResourceNotFoundException;
import app.model.Pony;
import app.model.Race;

@RestController
@RequestMapping("/Pony")
public class PonyController {

	@Autowired
	PonyDAO ponyDAO;
	@Autowired
	RaceDAO raceDAO;

	@CrossOrigin(origins = "*")
	@GetMapping("/getPonies")
	public List<Pony> getAllPonies() {
		return ponyDAO.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/getPony/{id}")
	public Pony getById(@PathVariable long id) {
		Optional<Pony> oPony = ponyDAO.findById(id);
		if (oPony.isPresent()) {
			return oPony.get();
		}
		throw new ResourceNotFoundException("Sorry, this pony does not exist yet...");
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/addPony")
	public Pony addPony(@RequestBody @Valid Pony pony) {
		return ponyDAO.save(pony);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/deletePony/{id}")
	public void deletePony(@PathVariable long id) {
		 List<Race> races = raceDAO.findAll();
	        races.forEach((race) -> {
	            List<Pony> poniesFiltered = race.getPoniesRace().stream().filter((p) -> p.getId() != id).collect(Collectors.toList());
	            race.setPoniesRace(poniesFiltered);
	            raceDAO.save(race);
	        });
		ponyDAO.deleteById(id);
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/updatePony/{id}")
	public Pony updatePony(@PathVariable long id, @RequestBody @Valid Pony pony) {
		return ponyDAO.save(pony);
	}

}
