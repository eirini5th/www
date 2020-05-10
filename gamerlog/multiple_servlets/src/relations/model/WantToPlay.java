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

@Entity
@Table(name = "wantToPlay")
public class WantToPlay {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ID")
//	protected int ID;

	@Column(name = "userID")
	protected int userID;

	@Column(name = "gameID")
	protected int gameID;


	public WantToPlay() {
	}

	public WantToPlay(int userID, int gameID) {
		super();
		this.userID = userID;
		this.gameID = gameID;
	}

	public int getUserID() {
		return userID;
	}

	public void getUserId(int userID) {
		this.userID = userID;
	}

	public int getGameID() {
		return gameID;
	}

	public void getUserID(int gameID) {
		this.gameID = gameID;
	}

}
