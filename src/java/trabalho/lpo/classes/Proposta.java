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
    private int cod_oferta;
    private String nome_user;
    private String desejo;

    public Proposta(int cod_oferta, String nome_user, String desejo) {
        this.cod_oferta = cod_oferta;
        this.nome_user = nome_user;
        this.desejo = desejo;
    }

    public Proposta() {
    }


    
    

    public int getCod_oferta() {
        return cod_oferta;
    }

    public void setCod_oferta(int cod_oferta) {
        this.cod_oferta = cod_oferta;
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
