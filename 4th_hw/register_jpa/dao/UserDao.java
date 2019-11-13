package register_jpa.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import register_jpa.model.User;
import register_jpa.util.HibernateUtil;

public class UserDao {

    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        }
        catch (javax.persistence.PersistenceException e) {
//            transaction.rollback();
        }
        
        catch (Exception e) {
        	System.out.println("#############################################");
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public boolean checkIfExists(String username) {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (User) session.createQuery("FROM User U WHERE U.username = :username").setParameter("username", username)
                .uniqueResult();

            if (user != null) {
                return true;
            }

            // commit transaction
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
}