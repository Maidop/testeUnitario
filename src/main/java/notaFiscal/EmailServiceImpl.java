package notaFiscal;

public class EmailServiceImpl implements EmailApi {

    private EmailApi emailApi;

    @Override
    public void enviaEmail(NotaFiscal notaFiscal) {
        String conteudo ="texto do e-mail";
        //abertura FileInputStream
        //anexa NotaFiscal
        //Fechamento OutputStream
    }

    @Override
    public void enviaNotificacao(NotaFiscal notaFiscal) {

    }
}
