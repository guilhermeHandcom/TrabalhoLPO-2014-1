package trabalho.lpo.classes;





/**
 *
 * @author LARISSA
 */
public class Oferta {
    
    private int cod_oferta;
    private String nome_oferta;
    private String nome_usuario;
    private String nome_produto;
    private String desejo;

    public Oferta() {
    }

    public Oferta(int cod_oferta, String nome_oferta, String nome_usuario, String nome_produto, String desejo) {
        this.cod_oferta = cod_oferta;
        this.nome_oferta = nome_oferta;
        this.nome_usuario = nome_usuario;
        this.nome_produto = nome_produto;
        this.desejo = desejo;
    }

    public int getCod_oferta() {
        return cod_oferta;
    }

    public void setCod_oferta(int cod_oferta) {
        this.cod_oferta = cod_oferta;
    }

    public String getNome_oferta() {
        return nome_oferta;
    }

    public void setNome_oferta(String nome_oferta) {
        this.nome_oferta = nome_oferta;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getDesejo() {
        return desejo;
    }

    public void setDesejo(String desejo) {
        this.desejo = desejo;
    }

 
    
    
    
}
