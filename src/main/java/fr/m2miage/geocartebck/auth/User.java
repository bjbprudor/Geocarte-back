package fr.m2miage.geocartebck.auth;

import fr.m2miage.geocartebck.dao.UtilisateurRepository;
import fr.m2miage.geocartebck.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;

import javax.rmi.CORBA.Util;

public class User
{
    @Autowired
    private UtilisateurRepository userRepo;

    private Utilisateur utilisateur;

    public User()
    {
        //Utilisateur = new Utilisateur();
    }

    public void Connect(String username, String password)
    {

    }

    public void ConnectTo(String email, String password)
    {

    }

    public String getUsername()
    {
        return "";// utilisateur.getNom();
    }



    private void getUnencrypterPassword()
    {

    }

}
