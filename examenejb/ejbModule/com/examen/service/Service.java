package com.examen.service;

import java.util.List;
import java.util.Properties;
import javax.ejb.Stateless;
import javax.persistence.*;
import org.apache.log4j.Logger;
import com.examen.repository.Repository;
import javax.mail.internet.*;
import javax.mail.*;

@Stateless
public class Service<T> implements Repository<T> {
	@PersistenceContext(unitName="examenejb")
	protected EntityManager em;
	protected static Logger Log = Logger.getLogger(Service.class.getName());
	
	public  Service() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("examenejb");
		this.em = emf.createEntityManager();
	}

	/**
	* This method saves a object to the database.
	* The method uses the EtityFramework to begin a transaction, save the object to the database,
	* and commit the transaction.
	* @param t The object to save to the database.
	*/
	@Override
	public int save(T t) {
		int result = 0;
		String table=t.getClass().getSimpleName();
		Log.info("Attempting to save "+table+" object to the database");
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(t);
			tx.commit();
			result = 1;
			Log.info("Successfully saved "+table+" object to the database.");
		} catch (Exception e) {
			Log.error("An error occurred while saving User object to the database: "+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	/*
	* This method deletes a object from the database using the ID of the object.
	* The method uses the EntityFramework to begin a transaction, retrieve the  object from the database,
	* delete the object from the database, and commit the transaction.
	* @param id The ID of the object to delete from the database.
	* If there is no object with the specified ID in the database, then nothing happens.
	*/
	@Override
	public int deleteById(int id, T t) {
		int result = 0;
		String table=t.getClass().getSimpleName(); 
      	try {
			t=(T) em.createQuery("SELECT t FROM " + table + " t WHERE t.id=:id").setParameter("id", id).getSingleResult();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			if (t != null) {
				em.remove(t);
				result = 1;
		        Log.info("Successfully deleted "+table+" object from the database with ID: "+ id);
		    } else {
		        Log.info("No "+table+" object with ID "+id+" found in the database. Nothing to delete.");
		    }
			tx.commit();
		}catch(Exception e) {
			Log.error("An error occurred while deleting "+table+" object from the database with ID "+id+": "+ e.getMessage());
		    throw e;
		}
      	return result;
	}

	/**
	 * Update an existing t in the database.
	 * @param compte The t to be updated
	 */
	@Override
	public int update(T t) {
		int result = 0;
		String table=t.getClass().getSimpleName();
		Log.info("Updating "+table+" with");
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.merge(t);
			tx.commit();
			result = 1;
			Log.info("Updating "+table+" successfully ");
		} catch (Exception e) {
			Log.error("An error occurred while updating "+table+" "+ e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	/**
	* This method retrieves all objects from the database.
	* The method uses the EntityFramework to query the database and retrieve the objects.
	* @return A List containing all objects retrieved from the database.
	* If there are no objects in the database, then an empty List is returned.
	*/
	@Override
	public List<T> findAll(T t) {
		String table=t.getClass().getSimpleName();
		Log.info("Attempting to retrieve all "+table+" objects from the database.");
		List<T> result = em.createQuery("SELECT t FROM " + table + " t").getResultList();
		if (result != null) {
	        Log.info("Successfully retrieved "+table+" list");
	    } else {
	        Log.error("Could not find "+table+" list");
	    }
		return result;
	}

	/**
	* This method retrieves a object from the database based on the provided ID.
	* The method uses the EntityFramework to query the database and retrieve the object.
	* @param id The ID of the object to retrieve from the database.
	* @return The object retrieved from the database with the provided ID.
	* If there is no object with the provided ID in the database, then null is returned.
	*/
	@Override
	public T findById(int id, T t) {
		String table=t.getClass().getSimpleName();
		Log.info("Attempting to retrieve "+table+" object with ID: "+ id);
        t=(T) em.createQuery("SELECT t FROM " + table + " t WHERE t.id=:id").setParameter("id", id).getSingleResult();
	    if (t != null) {
	        Log.info("Successfully retrieved "+table+" object with ID: "+ id);
	    } else {
	        Log.error("Could not find "+table+" object with ID: "+ id);
	    }
	    return t;
	}

	/**
	* This method send mail to an user.
	* @param emailSend The email of the object are sending email and emailReceive The email of thr object are receive.
	* @return an boolean variable.
	*/
	@Override
	public Boolean sendMail(String emailreceive) {
		Boolean result = false;
		Log.info("Attempting jeremyobiang412@gmail.com to send email at "+ emailreceive);
        try {
        	Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            Session session = Session.getInstance(props, new Authenticator() {
            	@Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("jeremyobiang412@gmail.com", "************");
                }
            });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("jeremyobiang412@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailreceive));
            message.setSubject("Inscription to Examen ejb");
            message.setText("Your registration was successful!");
            Transport.send(message);
            Log.info("mail successfully sent!");
            result = true;
        }catch (Exception e) {
        	Log.error("An error occurred : "+ e.getMessage());
			e.printStackTrace();
        }
        return result;
	}
}
