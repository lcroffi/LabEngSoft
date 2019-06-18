package service;

import java.text.ParseException;
import java.util.List;

import model.Candidato;

public class CandidatoService {
    private List<Candidato> candidatos;

    public CandidatoService() throws ParseException {    
        DBMockService dbImpl = new DBMockService();
        candidatos = dbImpl.getCandidatos();   
    }

    public Candidato findById(int id) {
        for(Candidato c : candidatos) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public List<Candidato> findAll() {
        return candidatos;
    }

    public Candidato findPrefeitoByNumero(int numero) {
        for(Candidato c : candidatos) {
            if (c.getNumeroUrna() == numero && c.getOficio().equals("Prefeito")) {
                return c;
            }
        }
        return null;
    }

    public Candidato findViceByNumero(int numero) {
        for(Candidato c : candidatos) {
            if (c.getNumeroUrna() == numero && c.getOficio().equals("Vice-Prefeito")) {
                return c;
            }
        }
        return null;
    }

}