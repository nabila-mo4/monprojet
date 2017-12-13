package com.escalade.beans;

import java.io.Serializable;

public class Voie implements Serializable{
	
		private Secteur secteur;
		private String nom;
		private int hauteur;
		private String nomHauteurVoie;
		private int nbPoints;
		private String etat;
		private Long id;
		
		
		public Secteur getSecteur() {
			return secteur;
		}
		public void setSecteur(Secteur secteur) {
			this.secteur = secteur;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public int getHauteur() {
			return hauteur;
		}
		public void setHauteur(int hauteur) {
			this.hauteur = hauteur;
		}
		public String getNomHauteurVoie() {
			return nomHauteurVoie;
		}
		public void setNomHauteurVoie(String nomHauteurVoie) {
			this.nomHauteurVoie = nomHauteurVoie;
		}
		public int getNbPoints() {
			return nbPoints;
		}
		public void setNbPoints(int nbPoints) {
			this.nbPoints = nbPoints;
		}
		public String getEtat() {
			return etat;
		}
		public void setEtat(String etat) {
			this.etat = etat;
		}
		
		
}
