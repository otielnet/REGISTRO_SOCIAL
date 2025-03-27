package ec.com.registro.social.model;

import java.util.Map;
import lombok.Data;

@Data
public class Provincia {
    private String provincia;
    private Map<String, Canton> cantones;
}