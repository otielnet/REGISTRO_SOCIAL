package ec.com.registro.social.model;

import java.util.Map;
import lombok.Data;

@Data
public class Canton {
    private String canton;
    private Map<String, String> parroquias; // Clave: código, Valor: nombre
}