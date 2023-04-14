package projet;

import java.time.LocalDate;

public class personne {
      private int id;
    private String nom;
    private String prenom;
    private String email;
     private LocalDate date_entree;

    personne(int id,String nom,String prenom,String email,LocalDate date_entree)
    {
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.date_entree=date_entree;
    };
    personne()
    {
    };


    int getId(){
        return  id ;
    }
}
