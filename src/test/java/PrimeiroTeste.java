import org.junit.Assert;
import org.junit.Test;

public class PrimeiroTeste {

    @Test
    public void validaSoma(){
        int um = 1;
        int dois = 2;

        int resultado = um + um;

        Assert.assertEquals(dois, resultado);
    }

    @Test
    public void valorNaoPodeSerNulo(){
        String valor = "Teste";

        Assert.assertNotNull(valor);
    }

    @Test
    public void stringDeveSerInvertida(){
        String nome = "Maikon Pscheidt";

        String nomeInvertido = InverteString.inverte(nome);

        Assert.assertEquals("tdiehcsP nokiaM", nomeInvertido);
    }



}
