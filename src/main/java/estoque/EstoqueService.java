package estoque;

import br.com.devbootcamp.Item;
import notaFiscal.NotaFiscalItem;

public interface EstoqueService {
    void atualizaEstoque(NotaFiscalItem notaFiscalItem);
}
