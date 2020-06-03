package relations.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Favourite.java This is a model class represents a Favourite entity
 * 
 * @author Ramesh Fadatare
 *
 */

@Entity (name = "userlists")
@Table(name = "userlists")
public class ListEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	protected int id;

	@Column(name = "userID")
	protected int userID;

	@Column(name = "gameID")
	protected int gameID;
	
	@Column(name = "name")
	protected String name;

	public ListEntry() {
	}

	public ListEntry(int userID, int gameID, String name) {
		super();
		this.userID = userID;
		this.gameID = gameID;
		this.name = name;
	}
	
	public ListEntry(int id, int userID, int gameID, String name) {
		super();
		this.id = id;
		this.userID = userID;
		this.gameID = gameID;
		this.name = name;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserId(int userID) {
		this.userID = userID;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
