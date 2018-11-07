package app.controller;

import java.util.List;
import java.util.Optional;

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

import app.dao.PonyDAO;
import app.exceptions.RessourceNotFoundException;
import app.model.Pony;

@RestController
@RequestMapping("/Pony")
public class PonyController {

	@Autowired
	PonyDAO ponyDAO;

	@CrossOrigin(origins = "*")
	@GetMapping("/getPonies")
	public List<Pony> getAllPonies() {
		return ponyDAO.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/getPony/{id}")
	public Pony getById(@PathVariable("id") Long id) {
		Optional<Pony> oPony = ponyDAO.findById(id);
		if (oPony.isPresent()) {
			return oPony.get();
		}
		throw new RessourceNotFoundException("Sorry, this pony does not exist yet...");
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/addPony")
	public Pony addPony(@RequestBody @Valid Pony pony) {
		return ponyDAO.save(pony);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/deletePony/{id}")
	public void deletePony(@PathVariable("id") Long id) {
		ponyDAO.deleteById(id);
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/updatePony/{id}")
	public Pony updatePony(@PathVariable("id") Long id, @RequestBody @Valid Pony pony) {
		Optional<Pony> ponyToChange = ponyDAO.findById(id);
		if (ponyToChange.isPresent()) {
			ponyToChange.get().setName(pony.getName());
			ponyToChange.get().setColor(pony.getColor());
			ponyToChange.get().setAge(pony.getAge());
			ponyToChange.get().setWeight(pony.getWeight());

			Pony updatedPony = ponyDAO.save(ponyToChange.get());
			return updatedPony;
		}

		throw new RessourceNotFoundException("Sorry, this pony does not exist yet...");

	}

}
