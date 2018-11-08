package app.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "race")
public class Race {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotNull
	@Length(min = 1, max = 50)
	private String location;

	@Column
	@NotNull
	private LocalDate date;

	@ManyToMany
	@JoinTable(name="race_pony", joinColumns=@JoinColumn(name="race_id"), inverseJoinColumns=@JoinColumn(name="pony_id"))
	private List<Pony> poniesRace = new ArrayList<Pony>();

	public Race() {
	}

	public Race(String location, LocalDate date) {
		this.location = location;
		this.date = date;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String place) {
		this.location = place;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Pony> getPoniesRace() {
		return poniesRace;
	}

	public void setPoniesRace(List<Pony> ponies) {
		this.poniesRace = ponies;
	}

}
