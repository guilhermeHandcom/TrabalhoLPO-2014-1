/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho.lpo.classes;

/**
 *
 * @author LARISSA
 */
public class Proposta {
    private int cod_proposta;
    private String nome_user;
    private String desejo;

    public Proposta(int cod_proposta, String nome_user, String desejo) {
        this.cod_proposta = cod_proposta;
        this.nome_user = nome_user;
        this.desejo = desejo;
    }

    public Proposta() {
    }
    
   
    public int getCod_proposta() {
        return cod_proposta;
    }

    public void setCod_proposta(int cod_proposta) {
        this.cod_proposta = cod_proposta;
    }

    public String getNome_user() {
        return nome_user;
    }

    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }

    public String getDesejo() {
        return desejo;
    }

    public void setDesejo(String desejo) {
        this.desejo = desejo;
    }
    
    
}
