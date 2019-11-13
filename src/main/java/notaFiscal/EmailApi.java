package notaFiscal;

public interface EmailApi {
    void enviaEmail(NotaFiscal notaFiscal);

    void enviaNotificacao(NotaFiscal notaFiscal);
}
