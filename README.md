
# aluraChallenge - Conversor de Monedas BackEnd - FA

![Badge: Java](https://img.shields.io/badge/Java-17-blue) ![Badge: IntelliJ](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-orange)

Este proyecto es un **Conversor de Monedas** desarrollado en **Java**, que utiliza una API de tasas de cambio para realizar conversiones entre diferentes divisas. Es parte de un desafío educativo que combina conceptos de programación, manejo de APIs, y manipulación de datos JSON.

---

## Descripción

El **Conversor de Monedas** permite realizar conversiones entre las principales divisas internacionales utilizando tasas de cambio en tiempo real proporcionadas por la API **ExchangeRate-API**. Está diseñado como un programa de consola interactivo, con funcionalidades que incluyen un historial de conversiones y validación de entradas.

---

## Funcionalidades

- Conversión entre 10 divisas internacionales.
- Validación de entradas para evitar errores.
- Historial de conversiones realizadas durante la ejecución.
- Presentación de resultados con formato numérico legible.
- Uso de tasas de cambio actualizadas en tiempo real.

---

## Tecnologías Utilizadas

- **Java 17**: Lenguaje de programación principal.
- **IntelliJ IDEA**: Entorno de desarrollo utilizado.
- **Gson**: Biblioteca para el manejo y manipulación de JSON.
- **ExchangeRate-API**: Fuente de datos para las tasas de cambio.

---

## Divisas Soportadas

El conversor admite las siguientes divisas:

- ARS: Peso argentino
- BOB: Boliviano boliviano
- BRL: Real brasileño
- CLP: Peso chileno
- COP: Peso colombiano
- EUR: Euro
- JPY: Yen japonés
- KRW: Won surcoreano
- MXN: Peso mexicano
- USD: Dólar estadounidense

---

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de contar con:

1. **Java Development Kit (JDK)** versión 17 o superior.
2. **IntelliJ IDEA** o un IDE compatible con proyectos Java.
3. Conexión a internet para realizar solicitudes a la API.

---

## Cómo Usarlo

1. **Clona este repositorio** en tu máquina local:
   ```bash
   git clone https://github.com/AlmarazFV/aluraChallenge.git
   cd aluraChallenge
   ```

2. **Configura la biblioteca Gson**:
   - Abre el proyecto en IntelliJ IDEA.
   - Ve a `File > Project Structure > Modules > Dependencies`.
   - Agrega la biblioteca **Gson** desde [Maven Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson).

3. **Ejecuta el proyecto** desde la clase principal `Principal`.

### Menú Interactivo

Al ejecutar el programa, se mostrará un menú como el siguiente:

```plaintext
=== Conversor de Monedas ===
1. Ver tasas de conversión disponibles
2. Realizar una conversión
3. Ver historial de conversiones
9. Salir
Seleccione una opción:
```

---

## Autores

- **Nombre**: Fernando Almaraz
- **Correo Electrónico**: [almarazfv@gmail.com](mailto:almarazfv@gmail.com)
- **GitHub**: [AlmarazFV](https://github.com/AlmarazFV)

---

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.
