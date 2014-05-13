package trabalho.lpo.classes;





/**
 *
 * @author LARISSA
 */
public class Oferta {
    
    private String nome_usuario;
    private String nome_oferta;
    private String produto;
    private String desejo;

    public Oferta(String nome_usuario, String nome_oferta, String produto, String desejo) {
        this.nome_usuario = nome_usuario;
        this.nome_oferta = nome_oferta;
        this.produto = produto;
        this.desejo = desejo;
    }

    public Oferta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
     * @return the nome_usuario
     */
    public String getNome_usuario() {
        return nome_usuario;
    }

    /**
     * @param nome_usuario the nome_usuario to set
     */
    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    /**
     * @return the nome_oferta
     */
    public String getNome_oferta() {
        return nome_oferta;
    }

    /**
     * @param nome_oferta the nome_oferta to set
     */
    public void setNome_oferta(String nome_oferta) {
        this.nome_oferta = nome_oferta;
    }

    /**
     * @return the produto
     */
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }

    /**
     * @return the desejo
     */
    public String getDesejo() {
        return desejo;
    }

    /**
     * @param desejo the desejo to set
     */
    public void setDesejo(String desejo) {
        this.desejo = desejo;
    }
    
    
    
    
}
