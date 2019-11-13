public class InverteString {
    public static String inverte(String nome) {
        String nomeInvertido = nome;

        StringBuffer sb = new StringBuffer(nome);
        sb.reverse();

        return sb.toString();
    }
}
