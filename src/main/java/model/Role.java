/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Role {
    private EnumRoles descricao;
    
    public Role(EnumRoles desc){
        this.descricao = desc;
    }    
    
    public EnumRoles getDescricao() {
        return descricao;
    }

    public void setDescricao(EnumRoles descricao) {
        this.descricao = descricao;
    }
    
    
}
