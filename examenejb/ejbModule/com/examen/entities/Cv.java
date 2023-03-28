package com.examen.entities;

import javax.persistence.*;

@Entity
@Table(name = "cv")
public class Cv {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "age")
	private int age;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "telephone")
	private String telephone;
	@Column(name = "specialite")
	private String specialite;
	@Column(name = "niveauEtude")
	private String niveauEtude;
	@Column(name = "experienceProfessionnelle")
	private String experienceProfessionnelle;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
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
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getSpecialite() {
		return specialite;
	}
	
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	public String getNiveauEtude() {
		return niveauEtude;
	}
	
	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}
	
	public String getExperienceProfessionnelle() {
		return experienceProfessionnelle;
	}
	
	public void setExperienceProfessionnelle(String experienceProfessionnelle) {
		this.experienceProfessionnelle = experienceProfessionnelle;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
