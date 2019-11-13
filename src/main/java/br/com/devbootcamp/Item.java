package br.com.devbootcamp;

public class Item {
    private Long id;
    private String descricao;
    private Double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        if(valor < 0D){
            this.valor = 0D;
        }else
            this.valor = valor;
    }
}
