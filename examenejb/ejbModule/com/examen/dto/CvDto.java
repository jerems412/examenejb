package com.examen.dto;

public class CvDto {
	private int id;
	private String nom;
	private String prenom;
	private int age;
	private String adresse;
	private String email;
	private String password;
	private String telephone;
	private String specialite;
	private String niveauEtude;
	private String experienceProfessionnelle;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSpecialite() {
		return specialite;
	}
	
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getExperienceProfessionnelle() {
		return experienceProfessionnelle;
	}
	
	public void setExperienceProfessionnelle(String experienceProfessionnelle) {
		this.experienceProfessionnelle = experienceProfessionnelle;
	}
	
	public String getNiveauEtude() {
		return niveauEtude;
	}
	
	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
