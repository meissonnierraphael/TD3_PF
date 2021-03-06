/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package TD3_PF;

import TD3_PF.arbres.Arbre;
import TD3_PF.arbres.Feuille;
import TD3_PF.arbres.Noeud;
import TD3_PF.arbresgeneriques2.Chaine;
import TD3_PF.arbresgeneriques2.Entier;
import TD3_PF.commandes.Categorie;
import TD3_PF.commandes.Commande;
import TD3_PF.commandes.DAO;
import TD3_PF.commandes.Produit;
import TD3_PF.paires.IPaire;
import TD3_PF.paires.Paire;
import TD3_PF.universite.Annee;
import TD3_PF.universite.Etudiant;
import TD3_PF.universite.Matiere;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void question21() {
        IPaire<Integer, String> p1 = new Paire<>(1, "un");
        System.out.println(p1);
        IPaire<Double, String> p2 = p1.changeFst(1.0);
        System.out.println(p2);
        IPaire<Double, IPaire<Integer, String>> p3 = p2.changeSnd(p1);
        System.out.println(p3);
    }

    public static void question31() {
        final TD3_PF.arbres.Arbre f1 = new TD3_PF.arbres.Feuille(1);
        final TD3_PF.arbres.Arbre f2 = new TD3_PF.arbres.Feuille(2);
        final TD3_PF.arbres.Arbre n1 = new TD3_PF.arbres.Noeud(List.of(f1, f2));
        final TD3_PF.arbres.Arbre f3 = new TD3_PF.arbres.Feuille(3);
        final TD3_PF.arbres.Arbre n2 = new TD3_PF.arbres.Noeud(List.of(n1, f3));
        System.out.println(n2.taille());
        System.out.println(n2.contient(1));
        System.out.println(n2.contient(2));
        System.out.println(n2.contient(3));
        System.out.println(n2.contient(4));
        System.out.println(n2.valeurs());
        System.out.println(n2.somme());
        System.out.println(n2.min());
        System.out.println(n2.max());
    }

    public static void question32() {
        System.out.println("-- Integer");
        final TD3_PF.arbresgeneriques1.Arbre<Integer> if1 = new TD3_PF.arbresgeneriques1.Feuille<>(1);
        final TD3_PF.arbresgeneriques1.Arbre<Integer> if2 = new TD3_PF.arbresgeneriques1.Feuille<>(2);
        final TD3_PF.arbresgeneriques1.Arbre<Integer> in1 = new TD3_PF.arbresgeneriques1.Noeud<>(List.of(if1, if2));
        final TD3_PF.arbresgeneriques1.Arbre<Integer> if3 = new TD3_PF.arbresgeneriques1.Feuille<>(3);
        final TD3_PF.arbresgeneriques1.Arbre<Integer> in2 = new TD3_PF.arbresgeneriques1.Noeud<>(List.of(in1, if3));
        System.out.println(in2.taille());
        System.out.println(in2.contient(1));
        System.out.println(in2.contient(2));
        System.out.println(in2.contient(3));
        System.out.println(in2.contient(4));
        System.out.println(in2.valeurs());
        System.out.println("-- String");
        final TD3_PF.arbresgeneriques1.Arbre<String> sf1 = new TD3_PF.arbresgeneriques1.Feuille<>("a");
        final TD3_PF.arbresgeneriques1.Arbre<String> sf2 = new TD3_PF.arbresgeneriques1.Feuille<>("b");
        final TD3_PF.arbresgeneriques1.Arbre<String> sn1 = new TD3_PF.arbresgeneriques1.Noeud<>(List.of(sf1, sf2));
        final TD3_PF.arbresgeneriques1.Arbre<String> sf3 = new TD3_PF.arbresgeneriques1.Feuille<>("c");
        final TD3_PF.arbresgeneriques1.Arbre<String> sn2 = new TD3_PF.arbresgeneriques1.Noeud<>(List.of(sn1, sf3));
        System.out.println(sn2.taille());
        System.out.println(sn2.contient("a"));
        System.out.println(sn2.contient("b"));
        System.out.println(sn2.contient("c"));
        System.out.println(sn2.contient("d"));
        System.out.println(sn2.valeurs());
    }

    public static void question33() {
        System.out.println("-- Entier");
        final TD3_PF.arbresgeneriques2.Arbre<Entier> if1 = new TD3_PF.arbresgeneriques2.Feuille<>(new Entier(1));
        final TD3_PF.arbresgeneriques2.Arbre<Entier> if2 = new TD3_PF.arbresgeneriques2.Feuille<>(new Entier(2));
        final TD3_PF.arbresgeneriques2.Arbre<Entier> in1 = new TD3_PF.arbresgeneriques2.Noeud<>(List.of(if1, if2));
        final TD3_PF.arbresgeneriques2.Arbre<Entier> if3 = new TD3_PF.arbresgeneriques2.Feuille<>(new Entier(3));
        final TD3_PF.arbresgeneriques2.Arbre<Entier> in2 = new TD3_PF.arbresgeneriques2.Noeud<>(List.of(in1, if3));
        System.out.println(in2.taille());
        System.out.println(in2.contient(new Entier(1)));
        System.out.println(in2.contient(new Entier(2)));
        System.out.println(in2.contient(new Entier(3)));
        System.out.println(in2.contient(new Entier(4)));
        System.out.println(in2.valeurs());
        System.out.println(in2.somme());
        System.out.println(in2.min());
        System.out.println(in2.max());
        System.out.println(in2.estTrie());
        System.out.println("-- Chaine");
        final TD3_PF.arbresgeneriques2.Arbre<Chaine> sf1 = new TD3_PF.arbresgeneriques2.Feuille<>(new Chaine("a"));
        final TD3_PF.arbresgeneriques2.Arbre<Chaine> sf2 = new TD3_PF.arbresgeneriques2.Feuille<>(new Chaine("b"));
        final TD3_PF.arbresgeneriques2.Arbre<Chaine> sn1 = new TD3_PF.arbresgeneriques2.Noeud<>(List.of(sf1, sf2));
        final TD3_PF.arbresgeneriques2.Arbre<Chaine> sf3 = new TD3_PF.arbresgeneriques2.Feuille<>(new Chaine("c"));
        final TD3_PF.arbresgeneriques2.Arbre<Chaine> sn2 = new TD3_PF.arbresgeneriques2.Noeud<>(List.of(sn1, sf3));
        System.out.println(sn2.taille());
        System.out.println(sn2.contient(new Chaine("a")));
        System.out.println(sn2.contient(new Chaine("b")));
        System.out.println(sn2.contient(new Chaine("c")));
        System.out.println(sn2.contient(new Chaine("d")));
        System.out.println(sn2.valeurs());
        System.out.println(sn2.somme());
        System.out.println(sn2.min());
        System.out.println(sn2.max());
        System.out.println(sn2.estTrie());
    }

    public static void exercice2() {
        question21();
    }

    public static void exercice3() {
        question31();
        question32();
        question33();
    }

    public static void exercice4() {
        DAO data = DAO.instance();
        // commandes (non normalis??es puis normalis??es)
        for (Commande c : data.commandes()) {
            System.out.println(c);
        }
        for (Commande c : data.commandes()) {
            System.out.println(c.normaliser());
        }
        // produits
        System.out.println(data.produits());
        // produits ?? TVA r??duite (3 versions)
        System.out.println(data.selectionProduits(p -> p.cat() == Categorie.REDUIT));
        System.out.println(data.selectionProduits(p -> App.aTauxReduit(p)));
        System.out.println(data.selectionProduits(App::aTauxReduit));
        // produits ?? TVA r??duite co??tant plus de 5 EUR
        System.out.println(data.selectionProduits(p -> p.cat() == Categorie.REDUIT && p.prix() > 5.0));
        // commandes de plus de 2 items
        System.out.println(data.selectionCommande(c -> c.lignes().size() > 2));
        // commandes contenant au moins un produit ?? TVA r??duite command?? en plus de 2
        // exemplaires
        System.out.println(
                data.selectionCommandeSurExistanceLigne(l -> l.fst().cat() == Categorie.REDUIT && l.snd() > 2));
        // affichage des commandes sans r??duction
        for (Commande c : data.commandes()) {
            System.out.println(c.affiche(App::calculSimple));
        }
        // affichage des commandes avec r??duction
        for (Commande c : data.commandes()) {
            System.out.println(c.affiche(App::calculReduction));
        }
    }

    public static Boolean aTauxReduit(Produit p) {
        return p.cat() == Categorie.REDUIT;
    }

    /**
     * prix TTC = prix unitaire * (1 + taux TVA) * qt??
     */
    public static Double calculSimple(Paire<Produit, Integer> ligne) {
        Produit p = ligne.fst();
        int qte = ligne.snd();
        return p.prix() * (1 + p.cat().tva()) * qte;
    }

    /**
     * r??duction = si qt?? > 2 alors prix unitaire sinon 0 prix TTC = prix unitaire *
     * (1 + taux TVA) * qt?? - r??duction
     */
    public static Double calculReduction(Paire<Produit, Integer> ligne) {
        Double reduction = (ligne.snd() > 2) ? ligne.fst().prix() : 0.0;
        return calculSimple(ligne) - reduction;
    }

    // mati??res d'une ann??e
    public static final Function<Annee, Stream<Matiere>> matieresA =
            a -> a.ues().stream().flatMap(ue -> ue.ects().keySet().stream());

    // mati??res d'un ??tudiant
    public static final Function<Etudiant, Stream<Matiere>> matieresE =
            e -> matieresA.apply(e.annee());

    // mati??res coefficient??es d'un ??tudiant (version Entry)
    public static final Function<Etudiant, Stream<Map.Entry<Matiere, Integer>>> matieresCoefE_ =
            e -> e.annee().ues()
            .stream().flatMap(ue -> ue.ects().entrySet().stream());

    // transformation d'une Entry en une Paire
    public static final Function<Map.Entry<Matiere, Integer>, Paire<Matiere, Integer>> entry2paire =
            e -> new Paire<>(e.getKey(),e.getValue());


    // mati??res coefficient??es d'un ??tudiant (version Paire)
    public static final Function<Etudiant, Stream<Paire<Matiere, Integer>>> matieresCoefE =
            e -> matieresCoefE_.apply(e).map(entry2paire);

    // accumulateur pour calcul de la moyenne
    // ((asomme, acoefs), (note, coef)) -> (asomme+note*coef, acoef+coef)
    public static final BinaryOperator<Paire<Double, Integer>> accumulateurMoyenne =
            (acc,val) -> new Paire<>(acc.fst()+ val.fst()* val.snd(), acc.snd()+ val.snd() );

    // zero (valeur initiale pour l'accumulateur)
    public static final Paire<Double, Integer> zero =
            new Paire<>(0.0,0);

    // obtention de la liste de (note, coef) pour les mati??res d'un ??tudiant
    // 1. obtenir les (mati??re, coef)s
    // 2. mapper pour obtenir les (note, coef)s, null pour la note si l'??tudiant est
    // DEF dans cette mati??re
    public static final Function<Etudiant, List<Paire<Double, Integer>>> notesPonderees =

            e -> matieresCoefE.apply(e)
                    .map(p -> new Paire<>(e.notes().get(p.fst()),p.snd()))
                    .collect(Collectors.toList());

    // obtention de la liste de (note, coef) pour les mati??res d'un ??tudiant
    // 1. obtenir les (mati??re, coef)s
    // 2. mapper pour obtenir les (note, coef)s, 0.0 pour la note si l'??tudiant est
    // DEF dans cette mati??re
    public static final Function<Etudiant, List<Paire<Double, Integer>>> notesPondereesIndicatives =
            e -> matieresCoefE.apply(e)
                    .map(p -> new Paire<>(e.notes().containsKey(p.fst()) ? e.notes().get(p.fst()) : 0.0 , p.snd()))
                    .collect(Collectors.toList());

    // rempli avec l'accumulateur sp??cifique
    public static final Function<List<Paire<Double, Integer>>, Paire<Double, Integer>> reduit =
            as -> as.stream().reduce(zero,accumulateurMoyenne);

    // calcule la moyenne ?? partir d'un couple (somme pond??r??e, somme coefs)
    public static final Function<Paire<Double, Integer>, Double> divise =
            p -> p.fst()/p.snd();

    // calcul de moyenne fonctionnel
    // composer notesPonderees, reduit et divise
    // exception en cas de mati??re DEF
    public static final Function<Etudiant, Double> computeMoyenne =
            notesPonderees.andThen(reduit).andThen(divise);

    public static void main(final String[] args) {
        exercice2();
        exercice3();
        exercice4();
    }
}
