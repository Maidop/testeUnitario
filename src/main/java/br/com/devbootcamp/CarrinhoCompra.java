package br.com.devbootcamp;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompra {

    private Double valotTotal = 0D;
    private Double valorFrete = 0D;
    private Double valorDesconto = 0D;
    private List<Item> itens = new ArrayList<>();

    public Double getValotTotal() {
        return valotTotal;
    }

    public void setValotTotal(Double valotTotal) {
        this.valotTotal = valotTotal;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
