package DedeUniversWebSecurity.dedeUniversSecurityBox.repositories;

import DedeUniversWebSecurity.dedeUniversSecurityBox.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Integer>{
    List<Produit> findByNomProduitContaining(String nomProduit);

}
