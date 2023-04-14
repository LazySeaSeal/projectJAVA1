package projet;
import com.mysql.cj.xdevapi.Column;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class  personnel extends personne {
    private String grade;
    //constructeur avec para
    personnel(int code_pers,String nom_pers,String prenom_pers,String email_pers,LocalDate date_entree_pers,
              String grade)
    {
        super(code_pers,nom_pers,prenom_pers,email_pers,date_entree_pers);
        this.grade=grade;
    };

    personnel()
    {

    };



    personnel login(String nom, String Prenom, String mdp, Connection connection)
    {
        try{
            PreparedStatement statement=connection.prepareStatement("select * from personnel where nom_pers= ? and prenom_pers=?");
            statement.setString(1,nom);
            statement.setString(2,Prenom);
            ResultSet resultSet =    statement.executeQuery();
            if(resultSet.first()){
                return new personnel(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5).toLocalDate(),
                        resultSet.getString(6)
                );
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        };
        return null;

    }

   void ajouter_ouvrage(Connection connection){
        
   }

    ArrayList<lecteur> get_lecteurs(Connection connection)
    {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from lecteur");
            ArrayList<lecteur> lecteurs = null;
           while(resultSet.next()){
               lecteurs.add(new lecteur(
                   resultSet.getInt(0),
                   resultSet.getString(1),
                   resultSet.getString(2),
                   resultSet.getString(3),
                   resultSet.getDate(4).toLocalDate(),
                   resultSet.getInt(5),
                   resultSet.getInt(6),
                       resultSet.getInt(7),
                       resultSet.getInt(8)
               ));
           }
        }
        catch(Exception e)
        {
            System.out.println(e);
        };
        return  null;
    }

    void ajouter_lecteur(String nom,String prenom,String email,Date Date_entree , int abonn,Connection connection)
    {
        try{
            PreparedStatement statement=connection.prepareStatement("insert into lecteur(nom_lec,prenom_lec,email_lec,date_entree_lec,nb_prets,nb_alertes,type_abonnement) values(?,?,?,?,0,0,?)");
            statement.setString(1,nom);
            statement.setString(2,prenom);
            statement.setString(3,email);
            statement.setDate(4, Date_entree);
            statement.setInt(5,abonn);
           statement.executeQuery();




        }
        catch(Exception e)
        {
            System.out.println(e);
        };
    };

}
