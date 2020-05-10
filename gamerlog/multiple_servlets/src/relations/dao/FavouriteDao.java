package relations.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import relations.model.Favourite;
import relations.util.FavouriteHibernateUtil;

/**
 * CRUD database operations
 * @author Ramesh Fadatare
 *
 */
public class FavouriteDao {
	
	/**
	 * Save Favourite
	 * @param game
	 */
	public void saveFavourite(Favourite favourite) {
		Transaction transaction = null;
		try (Session session = FavouriteHibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(favourite);
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
	 * Update Favourite
	 * @param favourite
	 */
	public void updateFavourite(Favourite favourite) {
		Transaction transaction = null;
		try (Session session = FavouriteHibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(favourite);
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
	 * Delete Favourite
	 * @param id
	 */
	public void deleteFavourite(int id) {

		Transaction transaction = null;
		try (Session session = FavouriteHibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a favourite object
			Favourite favourite = session.get(Favourite.class, id);
			if (favourite != null) {
				session.delete(favourite);
				System.out.println("favourite is deleted");
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
	 * Get Favourite By ID
	 * @param id
	 * @return
	 */
	public Favourite getFavourite(int id) {

		Transaction transaction = null;
		Favourite favourite = null;
		try (Session session = FavouriteHibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an favourite object
			favourite = session.get(Favourite.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return favourite;
	}
	
	/**
	 * Get all Favourites
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Favourite> getAllFavourite() {

		Transaction transaction = null;
		List<Favourite> listOfFavourite = null;
		try (Session session = FavouriteHibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an favourite object
			
			listOfFavourite = session.createQuery("from Favourite").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfFavourite;
	}
}
