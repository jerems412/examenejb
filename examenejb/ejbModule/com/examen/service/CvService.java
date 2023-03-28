package com.examen.service;

import java.util.List;
import javax.ejb.Stateless;
import com.examen.entities.Cv;
import com.examen.repository.CvRepository;
//import com.itextpdf.html2pdf.ConverterProperties;
//import com.itextpdf.html2pdf.HtmlConverter;
//import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;

//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
//import java.io.FileWriter;


@Stateless
public class CvService extends Service<Cv> implements CvRepository {
	
	/*
	* This method logs in a User object with the specified email and password by checking if the email and password
	* match those of any Cv object in the database.
	* @param username The email of the User object to log in.
	* @param password The password of the User object to log in.
	* @return A new Cv object with the specified email and password if a match is found in the database.
	*/
	@Override
	public Cv logon(String email, String password) {
		Log.info("Attempting to log in Cv object with username: "+ email +" and password: "+ password);
		try {
			Cv user1 = new Cv();
			List<Cv> result = em.createQuery("SELECT t FROM Cv t").getResultList(); 
			for(Cv value : result ) {
				if(email.equals(value.getEmail()) && password.equals(value.getPassword())) {
					user1 = value;
					return user1;
				}
			}
			Log.info("No Cv object found in the database with email: "+email+" and password: "+ password);
			return user1;
		} catch (Exception e) {
			Log.error("An error occurred while logging in Cv object with username: "+email+" and password: "+password+": "+ e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	* This method saves a Cv object to the database.
	* The method uses the EtityFramework to begin a transaction, save the Cv object to the database,
	* and commit the transaction.
	* @param cv The object to save to the database.
	*/
	@Override
	public Boolean Register(Cv cv) {
		Boolean result = false;
		Log.info("Attempting to Register user to the database");
		try {
			//Boolean trouve = sendMail(cv.getEmail());
			Boolean trouve = true;
			if(trouve) {
				this.save(cv);
				Log.info("Successfully register user to the database.");
				result = true;
			}
		} catch (Exception e) {
			Log.error("An error occurred while saving Cv object to the database: "+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	/**
	* This method print a Cv object to a pdf file.
	* and commit the transaction.
	* @param cv The object to print to the pdf.
	*/
	@Override
	public Boolean print(Cv cv) {
        try {
        	Document document = new Document();
        	LocalDate myObj = LocalDate.now(); 
            PdfWriter.getInstance(document, new FileOutputStream("C:/Users/jerem/eclipse-workspace/examenweb/src/main/webapp/WEB-INF/cv/cv"+cv.getId()+cv.getNom()+cv.getPrenom()+".pdf"));
            document.open();
            document.add(new Paragraph(htmlcontent(cv)));
            document.close();
            Log.info("PDF created successfully !");
        } catch (Exception e) {
        	Log.error("An error occurred while print Cv object: "+e.getMessage());
        }
		return true;
	}

	@Override
	public String htmlcontent(Cv cv) {
		String html = ""
				+ "NOM : "+cv.getNom()+"\r\n"
				+ "PRENOM: "+cv.getPrenom()+"\r\n"
				+ "AGE: "+cv.getAge()+" years old\r\n"
				+ "EMAIL : "+cv.getEmail()+"\r\n"
				+ "TELEPONE: "+cv.getTelephone()+"\r\n"
				+ "ADRESSE: "+cv.getAdresse()+"\r\n"
				+ "SPECIALITE: "+cv.getSpecialite()+"\r\n"
				+ "NIVEAU D'ETUDE: "+cv.getNiveauEtude()+"\r\n"
				+ "EXPERIENCE PROFESSIONNELLE: "+cv.getExperienceProfessionnelle()+"\r\n";
		return html;
	}
}
