package notaFiscal;

import java.util.List;

public interface NotaFiscalRepository {
    void save(NotaFiscal notaFiscal);

    void saveAll(List<NotaFiscal> notaFiscalList);

    NotaFiscal update(String chave, NotaFiscal notaFiscal);

    NotaFiscal findByChave(String chave);

    void atualizaChaveHomologacao(String chave);
}
