/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.lpo.classes;

/**
 *
 * @author curso
 */
public class Grupo {
    

    private int codGrupo;
    private String titulo;
    private String descricao;
    private int fase;
    
    public Grupo(int codGrupo,  String titulo, String descricao, int fase) {
        
        this.codGrupo = codGrupo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.fase = fase;
        
      
    }

    public Grupo() {
       
    }

    /**
     * @return the codGrupo
     */
    public int getCodGrupo() {
        return codGrupo;
    }

    /**
     * @param codGrupo the codGrupo to set
     */
    public void setCodGrupo(int codGrupo) {
        this.codGrupo = codGrupo;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the fase
     */
    public int getFase() {
        return fase;
    }

    /**
     * @param fase the fase to set
     */
    public void setFase(int fase) {
        this.fase = fase;
    }

   

   
}
