# ☀️ Cieloscopio

Cieloscopio es una aplicación desarrollada en **Java** que permite consultar el **estado del clima actual** de cualquier ciudad disponible en la API pública de [OpenWeather](https://openweathermap.org/).  
Ofrece información como la temperatura, las condiciones climáticas, la temperatura mínima y máxima, la presencia de precipitaciones y la fecha y hora de la consulta.

---

![Cieloscopio - Aplicación del clima](https://i.imgur.com/p8xHtYD.png)

---

## 🚀 Características principales

- Consulta del clima en tiempo real por nombre de ciudad o por ciudad y código de país (por ejemplo: `Buenos Aires`, `Barcelona,EC`).
- Soporte para nombres con acentos y caracteres especiales (`México`, `Bogotá`, etc.).
- Conversión automática de unidades a grados Celsius y texto en idioma español
- Presentación formateada con fecha y hora local.
- Manejo de excepciones para errores de red o entradas inválidas.

---
## 🔎 Búsqueda por ciudad y código de país

Algunas ciudades en el mundo comparten el mismo nombre (por ejemplo, *Barcelona* existe tanto en España como en Venezuela o Ecuador).

Para obtener resultados correctos, la aplicación **Cieloscopio** permite especificar el **código del país** junto al nombre de la ciudad, separados por una coma.

**Ejemplo:**
- `Barcelona,ES` → Barcelona (España)
- `Barcelona,EC` → Barcelona (Ecuador)
- `Bogota,CO` → Bogotá (Colombia)
- `Lima,PE` → Lima (Perú)

Esto sigue el estándar [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/List_of_ISO_3166_country_codes), utilizado por la API de OpenWeather.

⚠️ **Importante:** si no se especifica el código del país, el servicio puede devolver una ciudad distinta a la esperada.

### 🖥️ Ejemplo de ejecución
```bash
Bienvenido a Cieloscopio (tu ventana digital al clima del mundo)
*********************************************************
Elija una ciudad para obtener los datos meteorológicos:
1- Bogotá
2- Buenos Aires
3- Ciudad de México
4- Lima
5- Santiago de Chile
6- Deseo consultar otra ciudad
7- Salir
*********************************************************

Escriba el nombre de la ciudad sobre la que desea consultar:

Barcelona,ES

RESPUESTA:
Ciudad: Barcelona
Código país: ES
Fecha y hora: 10/10/2025 19:40:03

Temperatura actual: 22.5°C
Condición climática: Cielo claro

Temperatura mínima: 20.1°C
Temperatura máxima: 24.3°C
Precipitación: Sin datos
`````

## ⚙️ Tecnologías utilizadas

- **Java 17+**
- **Gson** → para procesar el JSON de la API.
- **HttpClient (java.net.http)** → para las solicitudes HTTP.
- **OpenWeather API** → fuente de datos meteorológicos.
- **API gratuita** (sin autenticación avanzada ni límites elevados de consultas).
---


---

## 🔑 Configuración de la API

Para ejecutar el proyecto correctamente, se necesita una **API Key personal** de [OpenWeather](https://home.openweathermap.org/users/sign_up).  
Una vez obtenida, reemplazá el valor en la clase `ConsultaClima`:

```java
private static final String API_KEY = "TU_API_KEY_AQUI";
```

---

## 👤 Autor

<p align="center">
  <img src="https://i.imgur.com/7h93Q3Z.jpeg" alt="Foto de Gabriel Oberlin" width="140" style="border-radius:50%;">
</p>

<p align="center">
  <b>Gabriel Oberlin</b>  
  <br>
  Desarrollador Java en formación · Apasionado por la tecnología y el aprendizaje constante  
</p>
📜 Licencia

Este proyecto utiliza la versión gratuita de la API de OpenWeather y se distribuye únicamente con fines educativos y demostrativos.

