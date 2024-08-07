package DedeUniversWebSecurity.dedeUniversSecurityBox.services;
import DedeUniversWebSecurity.dedeUniversSecurityBox.entities.Produit;
import DedeUniversWebSecurity.dedeUniversSecurityBox.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit findById(Integer id) {
        return produitRepository.findById(id).get();
    }

    public List<Produit> recupereTousLesProduits() {
        return produitRepository.findAll();
    }

    public List<Produit> getByNomProduit(String nomProduit){
        return produitRepository.findByNomProduitContaining(nomProduit);
    }


    public void suppressionDuProduit(Integer id) {
        // Supprimez le produit avec l'ID spécifié (utilisez votre propre logique ici)
        produitRepository.deleteById(id);
    }
}

