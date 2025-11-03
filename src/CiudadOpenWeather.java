import com.google.gson.annotations.SerializedName;

import java.util.List;

public record CiudadOpenWeather(
        String name,
        Sys sys,
        List<Weather> weather,
        Main main,
        Rain rain
)
{ public record Sys( String country){}
    public record Weather( String description) {}
    public record Main( double temp,
                        //En las siguientes variables @SerializedName debido al guíon en las variables del Json
                        @SerializedName("temp_min") double tempMin,
                        @SerializedName("temp_max") double tempMax){}
    public record Rain (@SerializedName("1h") Double oneHour){}
}
