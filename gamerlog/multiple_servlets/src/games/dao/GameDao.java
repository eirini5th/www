package games.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import games.model.Game;
import games.util.HibernateUtil;
import login.model.User;

/**
 * CRUD database operations
 * 
 * @author Ramesh Fadatare
 *
 */
public class GameDao {

	/**
	 * Save Game
	 * 
	 * @param game
	 */
	public void saveGame(Game game) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(game);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Update Game
	 * 
	 * @param game
	 */
	public void updateGame(Game game) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(game);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Delete Game
	 * 
	 * @param id
	 */
	public void deleteGame(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a game object
			Game game = session.get(Game.class, id);
			if (game != null) {
				session.delete(game);
				System.out.println("game is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Get Game By ID
	 * 
	 * @param id
	 * @return
	 */
	public Game getGame(int id) {

		Transaction transaction = null;
		Game game = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an game object
			game = session.get(Game.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return game;
	}
	
	public Game getGameFromList(int ID) {
		Transaction transaction = null;
		Game game = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an game object
			game = (Game) session.createQuery("FROM Game G WHERE G.ID = :ID").setParameter("ID", ID)
	                .uniqueResult();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return game;
	}

	/**
	 * Get all Games
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Game> getAllGame() {

		Transaction transaction = null;
		List<Game> listOfGame = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an game object

			listOfGame = session.createQuery("from Game").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfGame;
	}

	@SuppressWarnings("unchecked")
	public List<Game> getGameList() {

		Transaction transaction = null;
		List<Game> listOfGame = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an game object

			listOfGame = session.createQuery("from Game").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfGame;
	}

}
