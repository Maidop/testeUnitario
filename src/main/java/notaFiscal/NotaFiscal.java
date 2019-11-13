package notaFiscal;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NotaFiscal {

    private String chave;
    private List<NotaFiscalItem> notaFiscalItemList = new ArrayList<>();
}
