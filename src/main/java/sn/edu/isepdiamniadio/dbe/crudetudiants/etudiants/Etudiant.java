package sn.edu.isepdiamniadio.dbe.crudetudiants.etudiants;

public class Etudiant {
 private int id;
 private String prenom;
 private String nom;
 private int age;
 private String matricule;
 
public Etudiant() {
}
public Etudiant(int id, String prenom, String nom, int age, String matricule) {
    this.id = id;
    this.prenom = prenom;
    this.nom = nom;
    this.age = age;
    this.matricule = matricule;
}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getPrenom() {
    return prenom;
}
public void setPrenom(String prenom) {
    this.prenom = prenom;
}
public String getNom() {
    return nom;
}
public void setNom(String nom) {
    this.nom = nom;
}
public int getAge() {
    return age;
}
public void setAge(int age) {
    this.age = age;
}
public String getMatricule() {
    return matricule;
}
public void setMatricule(String matricule) {
    this.matricule = matricule;
}
    
}
