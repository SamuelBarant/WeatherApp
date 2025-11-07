# 🌦️ Práctica 1 — Persistencia con SharedPreferences y Room  

### 📚 Módulo: Acceso a Datos  
**Curso 2025/2026**

---

## 🧩 Descripción general

Esta práctica consiste en **implementar mecanismos de persistencia local en una aplicación Android** que muestra datos meteorológicos obtenidos del API de [Open-Meteo](https://open-meteo.com/).  

El objetivo es desarrollar la parte de **almacenamiento y recuperación de datos** (latitud, longitud y temperaturas), utilizando **SharedPreferences** y **Room (SQLite)**.

---

## 🎯 Objetivos de la práctica

- Implementar el guardado y lectura de coordenadas mediante `SharedPreferences`.
- Crear una base de datos local con Room para almacenar temperaturas.
- Obtener los datos de la base de datos y mostrarlos gráficamente en la app.

---

## 🧱 Estructura de la práctica

### 🔹 Parte 1: Guardar ubicación en SharedPreferences
- Clase: `PreferencesManager`
- Al pulsar el botón de guardar en `LocationFragment`, se almacenan los valores de **latitud** y **longitud**.
- Los datos se persistirán incluso al cerrar la aplicación.

### 🔹 Parte 2: Almacenar temperaturas con Room
- Clases involucradas:
  - `WeatherEntity`
  - `WeatherDao`
  - `WeatherDatabase`
- Cada vez que se recibe una nueva respuesta del API:
  1. Se eliminan los datos anteriores de la tabla `weather_data`.
  2. Se insertan las nuevas temperaturas mapeadas desde la respuesta JSON.

### 🔹 Parte 3: Obtener temperaturas desde Room
- Se implementa en `WeatherDao` un método para recuperar los datos ordenados por **hora ascendente**, de modo que el gráfico (`TemperatureChartFragment`) pueda representar correctamente la evolución diaria de temperaturas.

---

## 🧠 Resultados de aprendizaje

| Código | Descripción |
|:--|:--|
| **RA1** | Desarrolla aplicaciones que gestionan información almacenada en ficheros utilizando clases específicas. |
| **RA2** | Desarrolla aplicaciones que gestionan información en bases de datos relacionales mediante mecanismos de conexión. |
| **RA3** | Gestiona la persistencia de datos utilizando herramientas ORM (Room). |

---

## 🧮 Rúbrica de evaluación

| Criterio | Excelente (4) | Adecuado (3) | Mejorable (2) | Insuficiente (1) |
|:--|:--|:--|:--|:--|
| **PreferencesManager** | Lectura/escritura correcta, sin errores. | Pequeños fallos menores. | Guarda o lee parcialmente. | No funcional o no compila. |
| **WeatherEntity** | Campos y anotaciones correctas. | Error menor en tipos/etiquetas. | Anotaciones incompletas. | No guarda datos o no compila. |
| **WeatherDao** | Métodos CRUD completos y anotaciones correctas. | Fallos menores (orden, retorno). | Métodos incompletos. | Interfaz no operativa. |
| **WeatherDatabase** | Configurada correctamente con patrón Singleton. | Funcional sin Singleton. | Fallos concretos. | No implementa Room o no compila. |

---

## 🧰 Tecnologías utilizadas

- **Kotlin / Android Studio**
- **Room (SQLite ORM)**
- **SharedPreferences**
- **Open-Meteo API**
- **MVVM Architecture (ya implementada parcialmente)**

---

## 🗂️ Archivos a modificar

- `PreferencesManager.kt`
- `WeatherEntity.kt`
- `WeatherDao.kt`
- `WeatherDatabase.kt`

⚠️ **Nota:** Las clases `ApplicationContext` y `WeatherRepository` contienen comentarios que indican qué código eliminar o modificar una vez completadas las implementaciones anteriores.

---

## 🚀 Ejecución
1. Abrir el proyecto en **Android Studio**.  
2. Clonar el repositorio  
   ```bash
   git clone https://github.com/tu-usuario/practica1-persistencia.git
3. Ejecutar en un emulador o dispositivo físico.  
4. Probar la persistencia modificando la ubicación y verificando el gráfico de temperaturas.

---
## ✍️ Autor

**Samuel Barba**  
Estudiante de 1º de DAM — Curso 2025/2026
