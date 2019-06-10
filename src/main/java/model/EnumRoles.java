/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public enum EnumRoles {
   
    CHEFE ("Chefe de Seção"),     
    MESARIO ("Mesário"),
    USUARIO_COMUM ("Usuário Comum");

    
    private final String descricao;        
    EnumRoles(String valor){
        this.descricao = valor;
    }    
    @Override
    public String toString(){
        return this.descricao;
    }
}
