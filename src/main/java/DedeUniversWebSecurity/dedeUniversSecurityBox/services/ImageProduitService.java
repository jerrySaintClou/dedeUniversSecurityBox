package DedeUniversWebSecurity.dedeUniversSecurityBox.services;
import DedeUniversWebSecurity.dedeUniversSecurityBox.entities.ImageProduit;
import DedeUniversWebSecurity.dedeUniversSecurityBox.entities.Produit;
import DedeUniversWebSecurity.dedeUniversSecurityBox.repositories.ImageProduitRepository;
import DedeUniversWebSecurity.dedeUniversSecurityBox.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageProduitService {

    @Autowired
    private ImageProduitRepository imageProduitRepository;
    @Autowired
    private ProduitRepository produitRepository;

    public List<ImageProduit> recupereTousLesImageProduits() {
        return imageProduitRepository.findAll();
    }


    public List<ImageProduit>trouverLesImageDunProduit(Produit produit){
        return this.imageProduitRepository.findByProduitOrderByIdAsc(produit);
    }

    public ImageProduit metLeImageProduit(ImageProduit imageProduit) {
        return imageProduitRepository.save(imageProduit);
    }

    public void supprimeLeImageProduit(Integer id) {
        // Supprimez le produit avec l'ID spécifié (utilisez votre propre logique ici)
        imageProduitRepository.deleteById(id);
    }

    public void suppressionDeLImageDuProduit(Integer id) {
        // Supprimez le produit avec l'ID spécifié (utilisez votre propre logique ici)
        imageProduitRepository.deleteById(id);
    }

}

