package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="candidatos")
public class Candidato {
    @Id
    private int id;
    @Column(name="foto")
    private String foto;
    @Column(name="nome_candidato")
    private String nomeCandidato;
    @Column(name="partido")
    private String partido;
    @Column(name="oficio")
    private String oficio;
    @Column(name="numero_urna")
    private int numeroUrna;
    @Column(name="votos")
    private int votos;

    public Candidato() {        
    }

    public Candidato(int id, String nomeCandidato, String partido, String oficio, int numeroUrna, int votos) {
        this.id = id;
        this.nomeCandidato = nomeCandidato;
        this.partido = partido;
        this.oficio = oficio;
        this.numeroUrna = numeroUrna;
        this.votos = votos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNomeCandidato(){
        return nomeCandidato;
    }

    public void setNomeCandidato(String nomeCandidato){
        this.nomeCandidato = nomeCandidato;
    }

    public String getPartido(){
        return partido;
    }

    public void setPartido(String partido){
        this.partido = partido;
    }

    public String getOficio(){
        return oficio;
    }

    public void setOficio(String oficio){
        this.oficio = oficio;
    }

    public int getNumeroUrna(){
        return numeroUrna;
    }

    public void setNumeroUrna(int numeroUrna){
        this.numeroUrna = numeroUrna;
    }

    public int getVotos(){
        return votos;
    }

    public void setVotos(int votos){
        this.votos = votos;
    }
}