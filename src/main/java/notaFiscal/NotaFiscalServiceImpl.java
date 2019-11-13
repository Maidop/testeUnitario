package notaFiscal;

import estoque.EstoqueService;

import java.util.List;

public class NotaFiscalServiceImpl implements  NotaFiscalService {

    //@Autowired
    private NotaFiscalRepository repository;
    private EmailApi emailApi;
    private EstoqueService estoqueService;

    @Override
    public NotaFiscal save(NotaFiscal notaFiscal) {
        repository.save(notaFiscal);

        emailApi.enviaEmail(notaFiscal);
        emailApi.enviaNotificacao(notaFiscal);

        for (NotaFiscalItem notaFiscalItem : notaFiscal.getNotaFiscalItemList()) {
            estoqueService.atualizaEstoque(notaFiscalItem);
        }

        return notaFiscal;
    }

    @Override
    public void saveAll(List<NotaFiscal> notaFiscalList) {
        repository.saveAll((notaFiscalList));
    }

    @Override
    public NotaFiscal update(String chave, NotaFiscal notaFiscal) {
        return repository.update(chave, notaFiscal);
    }

    @Override
    public NotaFiscal findByChave(String chave) {
        return repository.findByChave(chave);
    }

    @Override
    public void atualizaChaveHomologacao(String chave) {
        NotaFiscal notaFiscal = repository.findByChave(chave);
        if(notaFiscal != null){
            notaFiscal.setChave(notaFiscal.getChave() + "HOMOLOGACAO");
            repository.update(chave, notaFiscal);
        }
    }
}
