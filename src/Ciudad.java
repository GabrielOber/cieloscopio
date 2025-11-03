public class Ciudad {
    private String ciudad;
    private String pais;
    private Double temperaturaActual;
    private String condicionClimatica;
    private Double temperaturaMinima;
    private Double temperaturaMaxima;
    private Double precipitacion;
    private String fechaConsulta;

   public Ciudad() {
   }

   public Ciudad(String ciudad, String pais, Double temperaturaActual, String condicionClimatica,
                  Double temperaturaMinima, Double temperaturaMaxima) {
        this.ciudad = ciudad;
        this.pais = pais;
        this.temperaturaActual = temperaturaActual;
        this.condicionClimatica = condicionClimatica;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.precipitacion = precipitacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public Double getTemperaturaActual() {
        return temperaturaActual;
    }

    public String getCondicionClimatica() {
        return condicionClimatica;
    }

    public Double getTemperaturaMinima() {return temperaturaMinima;}

    public Double getTemperaturaMaxima() {return temperaturaMaxima;}

    public Double getPrecipitacion() {
        return precipitacion;
    }

    public String getFechaConsulta() {
        return fechaConsulta;
    }

    public void convierteCiudad (CiudadOpenWeather ciudadOpenWeather){
        this.ciudad = ciudadOpenWeather.name();
        this.pais = ciudadOpenWeather.sys().country();
        this.temperaturaActual = ciudadOpenWeather.main().temp();
        this.condicionClimatica = ciudadOpenWeather.weather().get(0).description();
        this.temperaturaMinima = ciudadOpenWeather.main().tempMin();
        this.temperaturaMaxima = ciudadOpenWeather.main().tempMax();

        // forma segura de obtener la precipitación (sin NullPointer)
        if (ciudadOpenWeather.rain() != null && ciudadOpenWeather.rain().oneHour() != null) {
            this.precipitacion = (ciudadOpenWeather.rain().oneHour());
        } else {
            this.precipitacion =(0.0);
        }
    }

    public void setFechaConsulta(String fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    @Override
    public String toString() {
        String textoPrecipitacion =
                (precipitacion != null && precipitacion > 0)
                        ? String.format("%.2f mm en la última hora", precipitacion)
                        : "Sin lluvias registradas";

        return "*********************************************************\n" +
                "                     R E S P U E S T A\n" +
                "*********************************************************\n\n" +
                "Ciudad: " + ciudad + "\n" +
                "Código país: " + pais + "\n" +
                "Fecha y hora: " + fechaConsulta + "\n\n" +
                "Temperatura actual: " + temperaturaActual + " °C\n" +
                "Condición climática: " + condicionClimatica + "\n\n" +
                "Temperatura mínima: " + temperaturaMinima + " °C\n" +
                "Temperatura máxima: " + temperaturaMaxima + " °C\n" +
                "Precipitación: " + textoPrecipitacion + "\n" ;
    }
}
