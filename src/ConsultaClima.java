import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsultaClima {
    private static final String URI_BASE ="https://api.openweathermap.org/data/2.5/weather?q=";
    private static final String API_KEY = "TU_API_KEY_AQUI";
    public Ciudad buscaCiudad(String nombreCiudad) {
        if(nombreCiudad.contains(",")){
            String[] partes = nombreCiudad.split(",");
            String nombre = partes[0];
            String codigoPais = partes[1];

            nombre = Normalizer.normalize(nombre, Normalizer.Form.NFD);
            nombre = nombre.replaceAll("\\p{M}", ""); // elimina acentos
            nombre = nombre.replace("ñ", "n").replace("Ñ", "N");
            nombreCiudad = nombre.trim() + "," + codigoPais.trim();
        }else{
            nombreCiudad  = Normalizer.normalize(nombreCiudad, Normalizer.Form.NFD);
            nombreCiudad = nombreCiudad.replaceAll("\\p{M}", "");
            nombreCiudad = nombreCiudad.replace("ñ", "n").replace("Ñ", "N");
            nombreCiudad = nombreCiudad.toUpperCase().trim();
        }

        URI direccion = URI.create(URI_BASE + nombreCiudad.replace(" ", "%20")
                + "&units=metric&lang=es&appid=" + API_KEY);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder().create();
            CiudadOpenWeather ciudadOpenWeather = gson.fromJson(response.body(), CiudadOpenWeather.class);

            // Obtener la fecha y hora actuales
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            Ciudad ciudad = new Ciudad();
            ciudad.convierteCiudad(ciudadOpenWeather);
            ciudad.setFechaConsulta(ahora.format(formateador));
            return ciudad;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error consultando la API", e);
        }
    }
}


