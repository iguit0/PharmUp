package Model;

import java.util.Date;

public class Venda {
    private int id_venda;
    private int qntd_venda;
    private Date Data;
    private double valortotal;
    private int cod_funcionario;
    private int cod_cliente;

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public int getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(int cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getQntd_venda() {
        return qntd_venda;
    }

    public void setQntd_venda(int qntd_venda) {
        this.qntd_venda = qntd_venda;
    } 
}
