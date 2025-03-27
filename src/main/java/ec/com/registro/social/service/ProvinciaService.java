package ec.com.registro.social.service;

import ec.com.registro.social.model.Provincia;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProvinciaService {
    private Map<String, Provincia> provincias;
    private final String JSON_URL = "https://gist.githubusercontent.com/emamut/6626d3dff58598b624a1/raw/166183f4520c4603987c55498df8d2983703c316/provincias.json";
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public ProvinciaService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void init() {
        try {
            String jsonResponse = restTemplate.getForObject(JSON_URL, String.class);
            TypeReference<Map<String, Provincia>> typeRef = new TypeReference<>() {};
            this.provincias = objectMapper.readValue(jsonResponse, typeRef);
            
            System.out.println("Provincias cargadas: " + this.provincias.keySet());
        } catch (Exception e) {
            e.printStackTrace();
            this.provincias = new HashMap<>();
        }
    }

    public Map<String, Provincia> getProvincias() {
        return provincias;
    }
}