package br.com.devbootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarrinhoCompraServiceTest {


    Item item;
    Item item2;
    CarrinhoCompraService carrinhoCompraService = new CarrinhoCompraService(new CarrinhoCompra());

    @Before
    public void before(){
        item = new Item();
        item.setId(1L);
        item.setDescricao("Caneta");
        item.setValor(4.50D);

        item2 = new Item();
        item2.setId(2L);
        item2.setDescricao("camisa");
        item2.setValor(7.50D);
    }

    @Test
    public void verificaSeAdicionouItemNaLista(){
        carrinhoCompraService.adicionaItem(item);

        assertEquals(1,carrinhoCompraService.getCarrinhoCompra().getItens().size());
    }

    @Test
    public void verificaSeRemoveuDaLista(){
        carrinhoCompraService.removeItem(item);

        assertEquals(0,carrinhoCompraService.getCarrinhoCompra().getItens().size());
    }

    @Test
    public void verificaAdicaoDeFrete(){
        carrinhoCompraService.adicionaItem(item);
        carrinhoCompraService.adicionaFrete(15D);

        assertEquals(Double.valueOf(15), carrinhoCompraService.getCarrinhoCompra().getValorFrete());
        assertEquals(Double.valueOf(19.5), carrinhoCompraService.getCarrinhoCompra().getValotTotal());
    }

    @Test(expected = RuntimeException.class)
    public void verificaAdicaoDeDesconto(){
        carrinhoCompraService.adicionaItem(item);
        carrinhoCompraService.acrescentarDesconto(3D);

        assertEquals(Double.valueOf(3), carrinhoCompraService.getCarrinhoCompra().getValorDesconto());
        assertEquals(Double.valueOf(1.5), carrinhoCompraService.getCarrinhoCompra().getValotTotal());
    }

    @Test(expected = RuntimeException.class)
    public void validaTodasAsAdicoes(){
        carrinhoCompraService.adicionaItem(item);
        carrinhoCompraService.adicionaItem(item2);
        carrinhoCompraService.removeItem(item);
        carrinhoCompraService.adicionaFrete(15D);
        carrinhoCompraService.acrescentarDesconto(3D);

        assertEquals(Double.valueOf(19.5), carrinhoCompraService.getCarrinhoCompra().getValotTotal());
        assertEquals(1,carrinhoCompraService.getCarrinhoCompra().getItens().size());
        assertNotNull(carrinhoCompraService.getCarrinhoCompra().getValorFrete());
        assertNotNull(carrinhoCompraService.getCarrinhoCompra().getItens());
    }
}