package br.com.devbootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    private Item item;

    @Before
    public void before(){
        item = new Item();
    }

    @Test
    public void valorDoItemNaoPodeSerNegativo(){
        Item item = new Item();
        item.setValor(Double.valueOf(-1));

        assertEquals(Double.valueOf(0), item.getValor());
    }

    @Test
    public void seValorDoItemForMaiorQueZeroDeveSerMantido(){
        Item item = new Item();
        item.setValor(Double.valueOf(10));

        assertEquals(Double.valueOf(10), item.getValor());
    }
}