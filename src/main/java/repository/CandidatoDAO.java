package repository;

import java.util.List;
import model.Candidato;

public interface CandidatoDAO {
    public Candidato insert(Candidato candidato);
    public Candidato findById(int id);
    public Candidato findByNumeroUrna(int numeroUrna);
    public List<Candidato> findAll();
    public Candidato update(Candidato candidatoAnt, Candidato candidatoAt);
    public boolean delete(Candidato candidato);
    public boolean delete(int id);     
}