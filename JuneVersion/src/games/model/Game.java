package games.model;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "games")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	protected int ID;

	@Column(name = "title")
	protected String title;

	@Column(name = "yearReleased")
	protected String yearReleased;

	@Column(name = "developers")
	protected String developers;

	@Column(name = "publishers")
	protected String publishers;

	@Column(name = "genres")
	protected String genres;

	@Column(name = "image")
	protected String image;
	
	public Game() {
	}
	
	//felt kinda debuggy, might delete later
	public Game(int id, String title) {
		super();
		this.ID = id;
		this.title = title;
	}

	public Game(String title, String yearReleased, String developers, String publishers, String genres, String image) {
		super();
		this.title = title;
		this.yearReleased = yearReleased;
		this.developers = developers;
		this.publishers = publishers;
		this.genres = genres;
		this.image = image;
	}

	public Game(int ID, String title, String yearReleased, String developers, String publishers, String genres,
			String image) {
		super();
		this.ID = ID;
		this.title = title;
		this.yearReleased = yearReleased;
		this.developers = developers;
		this.publishers = publishers;
		this.genres = genres;
		this.image = image;
	}

	public int getId() {
		return ID;
	}

	public void setId(int ID) {
		this.ID = ID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYearReleased() {
		return yearReleased;
	}

	public void setYearReleased(String yearReleased) {
		this.yearReleased = yearReleased;
	}

	public String getDevelopers() {
		return developers;
	}

	public void setDevelopers(String developers) {
		this.developers = developers;
	}

	public String getPublishers() {
		return publishers;
	}

	public void setName(String publishers) {
		this.publishers = publishers;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
