package sn.edu.isepdiamniadio.dbe.crudetudiants.etudiants;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {
   
    // Liste statique pour stocker les étudiants
    private static List<Etudiant> etudiants = new ArrayList<>();

    // Méthode pour récupérer une liste d'étudiants (HTTP GET)
    @GetMapping
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }
   
    // Méthode pour créer un nouvel étudiant (HTTP POST)
    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        // Génération de l'ID (vous pouvez utiliser une approche différente si nécessaire)
        int nextId = etudiants.isEmpty() ? 1 : etudiants.get(etudiants.size() - 1).getId() + 1;
        etudiant.setId(nextId);
        etudiants.add(etudiant);
        return etudiant;
    }

   // Méthode pour mettre à jour un étudiant (HTTP PUT)
@PutMapping("/{id}")
public ResponseEntity<Etudiant> updateEtudiant(@PathVariable int id, @RequestBody Etudiant updatedEtudiant) {
    for (Etudiant etudiant : etudiants) {
        if (etudiant.getId() == id) {
            etudiant.setPrenom(updatedEtudiant.getPrenom());
            etudiant.setNom(updatedEtudiant.getNom());
            etudiant.setAge(updatedEtudiant.getAge());
            etudiant.setMatricule(updatedEtudiant.getMatricule());
            return ResponseEntity.ok(etudiant);
        }
    }
    return ResponseEntity.notFound().build(); // Étudiant non trouvé
}

    // Méthode pour supprimer un étudiant par ID (HTTP DELETE)
    @DeleteMapping("/{id}")
    public boolean deleteEtudiant(@PathVariable int id) {
        Etudiant etudiantASupprimer = null;
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getId() == id) {
                etudiantASupprimer = etudiant;
                break;
            }
        }
        if (etudiantASupprimer != null) {
            etudiants.remove(etudiantASupprimer);
            return true;
        }
        return false; // Étudiant non trouvé
    }
    
    // Méthode pour récupérer un étudiant par ID (HTTP GET)
    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable int id) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getId() == id) {
                return etudiant;
            }
        }
        return null; // Étudiant non trouvé
    }

}
