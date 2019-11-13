package br.com.devbootcamp;

import jdk.jshell.EvalException;

public class CarrinhoCompraService {

    private CarrinhoCompra carrinhoCompra;

    public CarrinhoCompraService(CarrinhoCompra carrinhoCompra) {
        this.carrinhoCompra = carrinhoCompra;
    }

    public void adicionaItem(Item item){
        carrinhoCompra.getItens().add(item);
        Double valotTotal = 0D;
        for (Item iten : carrinhoCompra.getItens()) {
            valotTotal += iten.getValor();
        }
        carrinhoCompra.setValotTotal(valotTotal);
    }

    public void removeItem(Item item){
        carrinhoCompra.getItens().remove(item);
        Double valotTotal = 0D;
        for (Item iten : carrinhoCompra.getItens()) {
            valotTotal += iten.getValor();
        }
        carrinhoCompra.setValotTotal(valotTotal);
    }

    public void adicionaFrete(Double valorFrete){
        carrinhoCompra.setValorFrete(valorFrete);
        Double total = carrinhoCompra.getValotTotal();
        total += valorFrete;
        carrinhoCompra.setValotTotal(total);
    }

    public void acrescentarDesconto(Double desconto){
        if(desconto > carrinhoCompra.getValotTotal()){
            throw new RuntimeException("não possível adicionar desconto");
        }
        else{
            carrinhoCompra.setValorDesconto(desconto);
            Double total = carrinhoCompra.getValotTotal();
            total -= desconto;
            carrinhoCompra.setValotTotal(total);
        }
    }


    public CarrinhoCompra getCarrinhoCompra(){
        return carrinhoCompra;
    }
}
