# 📌 API RESTful con Spring Boot, WebFlux e Internacionalización

Este proyecto es una API RESTful desarrollada con *Spring Boot 3, utilizando **Spring WebFlux* para programación reactiva e *internacionalización (i18n)* para manejar múltiples idiomas.

---

## 🛠 *Requisitos Previos*
Antes de ejecutar el proyecto, asegúrate de tener instalado:

- *Java 17+* ([Descargar JDK](https://adoptium.net/))
- *Maven 3.8+* ([Descargar Maven](https://maven.apache.org/download.cgi))
- *Postman* (Opcional, para probar la API) ([Descargar Postman](https://www.postman.com/downloads/))

---

## 🚀 *Instalación y Ejecución*

### 1️⃣ *Clonar el Repositorio*
sh
 git clone https://github.com/tu-usuario/APIRESTful_RetoFinal.git
 cd APIRESTful_RetoFinal


### 2️⃣ *Compilar y Construir el Proyecto*
sh
mvn clean package


### 3️⃣ *Ejecutar la Aplicación*
sh
mvn spring-boot:run


La API se ejecutará en http://localhost:8080 🚀

---

## 📌 *Endpoints Disponibles*

### ✅ *Pedidos*
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /api/pedidos | Obtiene la lista de pedidos |
| POST | /api/pedidos | Crea un nuevo pedido |
| GET | /api/pedidos/mensaje?lang=es | Obtiene un mensaje traducido |

### 📌 **Ejemplo de Creación de Pedido (POST /api/pedidos)**
*URL:* http://localhost:8080/api/pedidos

*Headers:*
json
Content-Type: application/json


*Body (JSON):*
json
{
  "producto": "Laptop",
  "cantidad": 2,
  "precioTotal": 1200.0
}


*Respuesta esperada:*
json
{
  "id": "123456",
  "producto": "Laptop",
  "cantidad": 2,
  "precioTotal": 1200.0
}


---

## 🌍 *Internacionalización (i18n)*
La API soporta diferentes idiomas en sus mensajes.

📌 *Ejemplo:*
- GET http://localhost:8080/api/pedidos/mensaje?lang=es → "Hola, bienvenido a nuestra API Reactiva!"
- GET http://localhost:8080/api/pedidos/mensaje?lang=en → "Hello, welcome to our Reactive API!"
- GET http://localhost:8080/api/pedidos/mensaje?lang=fr → "Bonjour, bienvenue sur notre API réactive!"

---

## 🔥 **Pruebas con cURL**
Si no quieres usar Postman, puedes probar los endpoints con cURL:
sh
curl -X POST http://localhost:8080/api/pedidos \
     -H "Content-Type: application/json" \
     -d '{"producto": "Mouse", "cantidad": 1, "precioTotal": 25.0}'


---

## 🛠 *Tecnologías Usadas*
- *Spring Boot 3* - Framework para construir APIs RESTful
- *Spring WebFlux* - Programación reactiva
- *Spring Boot Validation* - Validación de datos
- *Spring Boot DevTools* - Herramientas de desarrollo
- *Internacionalización (i18n)* - Soporte para múltiples idiomas
- *Java 17+* - Lenguaje de programación

---

## 📌 *Posibles Errores y Soluciones*

### ❌ Error 400 - No request body
🔹 *Causa:* No se está enviando el body correctamente en la solicitud POST.
🔹 *Solución:* Asegúrate de que Content-Type: application/json está presente y que el body es un JSON válido.

### ❌ Error: Type mismatch: cannot convert from Mono<ResponseEntity<?>> to Mono<ResponseEntity<Pedido>>
🔹 *Causa:* Spring WebFlux no infiere el tipo Pedido correctamente.
🔹 *Solución:* Usa ResponseEntity.badRequest().<Pedido>build() para especificar el tipo.
