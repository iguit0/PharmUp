package Model;

public class Produto {
    private int id_produto;
    private String nome;
    private String descricao;
    private double precounitario;
    private String categoria;
    private int qntd_estoque;
    private int cod_fornecedor;
       
    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecounitario() {
        return precounitario;
    }

    public void setPrecounitario(double precounitario) {
        this.precounitario = precounitario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCod_fornecedor() {
        return cod_fornecedor;
    }

    public void setCod_fornecedor(int cod_fornecedor) {
        this.cod_fornecedor = cod_fornecedor;
    }

    public int getQntd_estoque() {
        return qntd_estoque;
    }

    public void setQntd_estoque(int qntd_estoque) {
        this.qntd_estoque = qntd_estoque;
    }
   
}