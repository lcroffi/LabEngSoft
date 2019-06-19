/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="users")
public class User {
    @Id
    private int id;
    @Column(name="numero_titulo")
    private String numeroTitulo;
    @Column(name="senha")
    private String senha;
    @Column(name="nome")
    private String nome;
    @Column(name="dob")
    private Date dob;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="emissao_titulo")
    private Date emissaoTitulo;
    @Column(name="zona")
    private int zona;
    @Column(name="secao")
    private int secao;
    @Column(name="allow_vote")
    private boolean allowVote;
    @Column(name="done")
    private boolean done;
    
    private List<Role> roles;
    
    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroTitulo() {
        return numeroTitulo;
    }

    public void setNumeroTitulo(String numeroTitulo) {
        this.numeroTitulo = numeroTitulo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }
        
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getEmissaoTitulo() {
        return emissaoTitulo;
    }

    public void setEmissaoTitulo(Date emissaoTitulo) {
        this.emissaoTitulo = emissaoTitulo;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public int getSecao() {
        return secao;
    }

    public void setSecao(int secao) {
        this.secao = secao;
    }

    public boolean getAllowVote() {
        return allowVote;
    }

    public void setAllowVote(boolean allowVote) {
        this.allowVote = allowVote;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
}
