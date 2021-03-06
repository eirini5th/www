package relations.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

//import login.model.User;
import relations.model.ListEntry;
import relations.util.ListEntryHibernateUtil;

public class ListEntryDao {
	
	/**
	 * Save ListEntry
	 * @param game
	 */
	public void saveListEntry(ListEntry listEntry) {
		Transaction transaction = null;
		try (Session session = ListEntryHibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(listEntry);
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
	 * Update ListEntry
	 * @param listEntry
	 */
	public void updateListEntry(ListEntry listEntry) {
		Transaction transaction = null;
		try (Session session = ListEntryHibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(listEntry);
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
	 * Delete ListEntry
	 * @param id
	 */
	public void deleteListEntry(int id) {

		Transaction transaction = null;
		try (Session session = ListEntryHibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a listEntry object
			ListEntry listEntry = session.get(ListEntry.class, id);
			if (listEntry != null) {
				session.delete(listEntry);
				System.out.println("listEntry is deleted");
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
	
	public void deleteListEntryObject(ListEntry listEntry) {

		Transaction transaction = null;
		try (Session session = ListEntryHibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a listEntry object
			if (listEntry != null) {
				session.delete(listEntry);
				System.out.println("listEntry is deleted");
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
	 * Get ListEntry By ID
	 * @param id
	 * @return
	 */
	public ListEntry getListEntry(int id) {

		Transaction transaction = null;
		ListEntry listEntry = null;
		try (Session session = ListEntryHibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an listEntry object
			listEntry = session.get(ListEntry.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listEntry;
	}
	
	@SuppressWarnings("unchecked")
	public boolean checkIfExists(int userID, int gameID, String listname) {
		Transaction transaction = null;
		List<ListEntry> listOfListEntry = null;
		try (Session session = ListEntryHibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an listEntry LIST of the desired objects (should be zero or one)
			String query = "from userlists f where f.userID = :userID and f.gameID = :gameID and f.name = :listname";
			listOfListEntry = session.createQuery(query).setParameter("userID", userID).setParameter("gameID", gameID).setParameter("listname", listname).getResultList();
			
			// commit transaction
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		if (listOfListEntry.size() > 0)
			return true;
		else
			return false;
	}
	
	/**
	 * Get all ListEntries
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ListEntry> getAllListEntries(int userID, String listname) {

		Transaction transaction = null;
		List<ListEntry> listOfListEntry = null;
		try (Session session = ListEntryHibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an listEntry object
			String query = "from userlists f where f.userID = :userID and f.name = :listname";
			listOfListEntry = session.createQuery(query).setParameter("userID", userID).setParameter("listname", listname).getResultList();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				System.out.println("transaction not null 1");
				transaction.rollback();
				System.out.println("transaction not null 2");
			}
			e.printStackTrace();
		}
		return listOfListEntry;
	}
	
	@SuppressWarnings("unchecked")
	public List<ListEntry> getSpecificEntries(int userID, int gameID, String listname) {

		Transaction transaction = null;
		List<ListEntry> listOfListEntry = null;
		try (Session session = ListEntryHibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			// get an listEntry object
			String query = "from userlists f where f.userID = :userID and f.name = :listname and f.gameID =:gameID";
			listOfListEntry = session.createQuery(query).setParameter("gameID", gameID).setParameter("userID", userID).setParameter("listname", listname).getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				System.out.println("transaction not null 1");
				transaction.rollback();
				System.out.println("transaction not null 2");
			}
			e.printStackTrace();
		}
		return listOfListEntry;
	}
}
