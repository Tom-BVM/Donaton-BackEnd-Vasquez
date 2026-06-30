Donaton Backend
Este repositorio contiene el backend del proyecto Donaton, desarrollado con Spring Boot y organizado en microservicios. Cada servicio cumple una función específica dentro de la plataforma solidaria, permitiendo modularidad, escalabilidad y fácil mantenimiento.

Tecnologías utilizadas
Spring Boot para la lógica de negocio.

Java como lenguaje principal.

MySQL para la persistencia de datos.

Docker y docker-compose para despliegue.

JUnit y MockMvc para pruebas.

Microservicios principales
Auth: registro e inicio de sesión.

Usuarios: gestión de perfiles.

Donaciones: CRUD de donaciones con validación de montos.

Necesidades: publicación y gestión de necesidades.

Logística: organización de envíos y entregas.

Compilar y ejecutar con Maven:
mvn clean install
mvn spring-boot:run

Levantar con Docker:
docker-compose up --build

Testing
Service tests: validan reglas de negocio.

Controller tests: verifican endpoints con MockMvc.

Cobertura superior al 80%.

Ejecutar pruebas:
mvn test

Contribución
Crear ramas separadas para nuevas funcionalidades.

Hacer pull requests para revisión.

Mantener buenas prácticas de código y documentación.
