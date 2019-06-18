package service;

import java.text.DateFormat;
import java.text.ParseException;

import model.Candidato;
import model.EnumRoles;
import model.Role;
import model.User;
import java.util.ArrayList;
import java.util.List;

public class DBMockService {
    private List<User> users;
    private List<Role> roles;
    private List<Candidato> candidatos;

    public DBMockService() throws ParseException {
        DateFormat f = DateFormat.getDateInstance();
        users = new ArrayList<User>();
        candidatos = new ArrayList<Candidato>();

        //Primeiro usuário do sistema
        roles = new ArrayList<Role>();
        roles.add(new Role(EnumRoles.CHEFE));
        roles.add(new Role(EnumRoles.MESARIO));
        roles.add(new Role(EnumRoles.USUARIO_COMUM));
        User u1 = new User();
        u1.setNumeroTitulo("chefe");
        u1.setSenha("123");
        u1.setId(1);
        u1.setNome("Maria da Silva");
        u1.setDob(f.parse("12/01/1995"));
        u1.setCity("Caçapava");
        u1.setState("São Paulo");
        u1.setEmissaoTitulo(f.parse("13/02/2013"));
        u1.setZona(127);
        u1.setSecao(35);
        u1.setAllowVote(false);
        u1.setDone(false);
        u1.setRoles(roles);        
        users.add(u1);

        //Segundo usuário do sistema
        roles = new ArrayList<Role>();
        roles.add(new Role(EnumRoles.MESARIO));
        roles.add(new Role(EnumRoles.USUARIO_COMUM));
        u1 = new User();
        u1.setNumeroTitulo("mesario");
        u1.setSenha("123");  
        u1.setId(2);
        u1.setNome("João Maria");
        u1.setDob(f.parse("14/09/1989"));
        u1.setCity("Guararema");
        u1.setState("São Paulo");
        u1.setEmissaoTitulo(f.parse("15/05/1998")); 
        u1.setZona(127);
        u1.setSecao(37); 
        u1.setAllowVote(false);
        u1.setDone(false);
        u1.setRoles(roles);
        users.add(u1); 

        //Terceiro usuário do sistema 
        roles = new ArrayList<Role>();
        roles.add(new Role(EnumRoles.USUARIO_COMUM));
        u1 = new User();
        u1.setNumeroTitulo("eleitor");
        u1.setSenha("123"); 
        u1.setId(3);
        u1.setNome("Maria José");   
        u1.setDob(f.parse("24/05/1987"));
        u1.setCity("Santa Branca");
        u1.setState("São Paulo");
        u1.setEmissaoTitulo(f.parse("03/08/1996"));
        u1.setZona(231);
        u1.setSecao(2);
        u1.setAllowVote(false);
        u1.setDone(false);
        u1.setRoles(roles);
        users.add(u1);   
        
        // Primeiro candidato
        Candidato c1 = new Candidato();
        c1.setId(1);
        c1.setFoto("prefeita.jpg");
        c1.setNomeCandidato("Tabata Claudia Amaral de Pontes");
        c1.setPartido("Partido Democrático Trabalhista");
        c1.setOficio("Prefeito");
        c1.setNumeroUrna(12);
        c1.setVotos(0);
        candidatos.add(c1);

        // Segundo candidato
        c1 = new Candidato();
        c1.setId(2);
        c1.setFoto("vice.jpg");
        c1.setNomeCandidato("Brienne de Tarth");
        c1.setPartido("Casa Stark");
        c1.setOficio("Vice-Prefeito");
        c1.setNumeroUrna(12);
        c1.setVotos(0);
        candidatos.add(c1);

        // Terceiro candidato
        c1 = new Candidato();
        c1.setId(3);
        c1.setFoto("joffrey.jpg");
        c1.setNomeCandidato("Joffrey Baratheon");
        c1.setPartido("Partido Social Liberal");
        c1.setOficio("Prefeito");
        c1.setNumeroUrna(17);
        c1.setVotos(0);
        candidatos.add(c1);

        // Quarto candidato
        c1 = new Candidato();
        c1.setId(4);
        c1.setFoto("theon.jpg");
        c1.setNomeCandidato("Theon Greyjoy");
        c1.setPartido("Partido das Mulheres Brasileiras");
        c1.setOficio("Vice-Prefeito");
        c1.setNumeroUrna(17);
        c1.setVotos(0);
        candidatos.add(c1);
    }

    public List<User> getUsers() {
        return users;
    }
    public List<Role> getRoles() {
        return roles;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }
}