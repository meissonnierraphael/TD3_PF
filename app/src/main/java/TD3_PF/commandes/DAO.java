package TD3_PF.commandes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.ArrayList;

import static TD3_PF.commandes.Categorie.*;
import TD3_PF.paires.Paire;

public class DAO {
    private List<Commande> commandes;

    private DAO(Commande c1, Commande ...cs) {
        commandes = new ArrayList<>();
        commandes.add(c1);
        commandes.addAll(List.of(cs));
    }

    public static DAO instance = null;

    public static final DAO instance() {
        if (instance == null) {
            Produit camembert = new Produit("Camembert", 4.0, NORMAL);
            Produit yaourts = new Produit("Yaourts", 2.5, INTERMEDIAIRE);
            Produit masques = new Produit("Masques", 25.0, REDUIT);
            Produit gel = new Produit("Gel", 5.0, REDUIT);
            Produit tournevis = new Produit("Tournevis", 4.5, NORMAL);
            //
            Commande c1 = new Commande()
                .ajouter(camembert, 1)
                .ajouter(yaourts, 6);
            Commande c2 = new Commande()
                .ajouter(masques, 2)
                .ajouter(gel, 10)
                .ajouter(camembert, 2)
                .ajouter(masques, 3);
            //
            instance = new DAO(c1,c2);
        }
        return instance;
    }

    /**
     * liste de toutes les commandes
     */
    public List<Commande> commandes() { return commandes; }

    /**
     * ensemble des différents produits commandés
     */
    public Set<Produit> produits() {
        Set<Produit> res = new HashSet<>();
        for(Commande c: commandes){
            for (Paire<Produit,Integer> p:c.lignes()){
                res.add(p.fst());
            }
        }
        return res;
        /*return commandes.stream()
                .flatMap(c -> c.lignes().stream())
                .map(Paire::fst)
                .collect(Collectors.toSet());*/
    }

    /**
     * liste des commandes vérifiant un prédicat
     */
    public List<Commande> selectionCommande(Predicate<Commande> p) {
        List<Commande> res = new ArrayList<>();
        for(Commande c:commandes){
            if(p.test(c)){
                res.add(c);
            }
        }
        return res;
        /*return commandes.stream()
            .filter(p)
            .collect(Collectors.toList());*/
    }

    /**
     * liste des commandes dont au moins une ligne vérifie un prédicat
     */
    public List<Commande> selectionCommandeSurExistanceLigne(Predicate<Paire<Produit,Integer>> p) {
        List<Commande> res = new ArrayList<>();
        for(Commande c: commandes){
            for(Paire<Produit,Integer> ligne : c.lignes()){
                if(p.test(ligne)){
                    res.add(c);
                    break;
                }
            }
        }
        return res;
        /*return commandes.stream()
            .filter(c -> c.lignes().stream().anyMatch(p))
            .collect(Collectors.toList());*/
    }

    /**
     * ensemble des différents produits commandés vérifiant un prédicat
     */
    public Set<Produit> selectionProduits(Predicate<Produit> p) {
        Set<Produit> res=new HashSet<>();
        for(Produit pro:produits()){
            if (p.test(pro)){
                res.add(pro);
            }
        }
        return res;
        /*return produits()
            .stream()
            .filter(p)
            .collect(Collectors.toSet());*/
    }

}
