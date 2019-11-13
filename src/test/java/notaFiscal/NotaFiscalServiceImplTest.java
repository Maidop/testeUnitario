package notaFiscal;

import estoque.EstoqueService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class NotaFiscalServiceImplTest {

    @Mock
    private NotaFiscalRepository repository;
    @InjectMocks
    private NotaFiscalServiceImpl serviceImpl;

    @Mock
    private EmailApi api;
    @Mock
    private EstoqueService estoqueService;


    @Test
    public void verificaSeChamMetodoSave() {
        List<NotaFiscalItem> nfItem = new ArrayList<>();
        NotaFiscalItem nfi1 = new NotaFiscalItem();
        NotaFiscalItem nfi2 = new NotaFiscalItem();
        NotaFiscalItem nfi3 = new NotaFiscalItem();
        nfItem.add(nfi1);
        nfItem.add(nfi2);
        nfItem.add(nfi3);
        var notaFiscal = new NotaFiscal();
        notaFiscal.setNotaFiscalItemList(nfItem);
        serviceImpl.save(notaFiscal);
        Mockito.verify(repository).save(Mockito.any());
        Mockito.verify(api).enviaEmail(notaFiscal);
        Mockito.verify(api).enviaNotificacao(notaFiscal);
        //Mockito.verify(estoqueService).atualizaEstoque((NotaFiscalItem) notaFiscal.getNotaFiscalItemList());
    }

    @Test
    public void verificaSeListaFoiAdicionada() {
        List<NotaFiscal> notaFiscalList = new ArrayList<>();
        serviceImpl.saveAll(notaFiscalList);


        Mockito.verify(repository).saveAll(notaFiscalList);
    }

    @Test
    public void VerificaSeEfetuouUpdate() {
        String chave = "556284712";
        NotaFiscal notaFiscal = new NotaFiscal();
        serviceImpl.update(chave, notaFiscal);

        Mockito.verify(repository).update("556284712", notaFiscal);
    }

    @Test
    public void verificaSeEncontrouNotaPorChave() {
        String chave = "556284712";
        serviceImpl.findByChave("556284712");

        Mockito.verify(repository).findByChave("556284712");
    }

    @Test
    public void verificaSeAtualizaChave() {
        var notaFiscal = new NotaFiscal();
        notaFiscal.setChave("123");
        Mockito.when(repository.findByChave("123")).thenReturn(notaFiscal);
        serviceImpl.atualizaChaveHomologacao("123");

        assertEquals("123HOMOLOGACAO", notaFiscal.getChave());
        Mockito.verify(repository).update("123", notaFiscal);
    }

}