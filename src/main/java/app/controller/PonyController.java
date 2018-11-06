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

import app.dao.PonyDAO;
import app.model.Pony;

@RestController
@RequestMapping("/Pony")
public class PonyController {

	@Autowired
	PonyDAO ponyDAO;

	@GetMapping("/getPonies")
	public List<Pony> getAllPonies() {
		return ponyDAO.findAll();
	}

	@PostMapping("/addPony")
	public Pony addPony(@RequestBody @Valid Pony pony) {
		return ponyDAO.save(pony);
	}

	@DeleteMapping("/deletePony/{id}")
	public void deletePony(@PathParam("id") Long id) {
		ponyDAO.deleteById(id);
	}

}


