# Donatón - Backend Microservices Platform

Ecosistema de servicios distribuidos desarrollado en Java Spring Boot para soportar las operaciones críticas de la plataforma Donatón. La arquitectura se basa en el patrón de base de datos por servicio (Database per Service) para garantizar un desacoplamiento total, escalabilidad independiente y tolerancia a fallos entre la recaudación de fondos y el control material.

---

## Tecnologías y Herramientas Utilizadas

- **Core Framework:** Java 21 / Spring Boot 3.x
- **Módulos de Spring:** Spring Web (APIs RESTful), Spring Data JPA (Persistencia de datos)
- **Seguridad:** Configuración nativa de CORS para control de accesos cruzados
- **Bases de Datos:** PostgreSQL / MySQL / MongoDB (Bases de datos independientes por servicio)
- **Contenedores:** Docker y Docker Compose para la orquestación de la red y dependencias
- **Calidad de Código:** Integración con SonarQube para análisis estático de vulnerabilidades
- **Pruebas Automatizadas:** JUnit 5, Mockito y Spring Boot Test

---

## Arquitectura de Microservicios Incluidos

### 1. Microservicio de Autenticación (Auths)
- **Puerto de red:** 8081
- **Responsabilidad:** Registro seguro de usuarios, almacenamiento y verificación de credenciales. Retorna el estado de inicio de sesión requerido por el frontend.

### 2. Microservicio de Donaciones (Donaciones)
- **Puerto de red:** 8082
- **Responsabilidad:** Gestión de la recaudación monetaria. Recibe peticiones estructuradas alineadas con los campos relacionales de la entidad (tipo, cantidad, fecha, usuarioId) y gestiona la persistencia en su base de datos dedicada. Incluye políticas explícitas de @CrossOrigin para el puerto 3000.

### 4. Microservicio de Logística (Logística)
- **Puerto de red:** 8083
- **Responsabilidad:** Control del flujo físico de las ayudas. Gestiona el estado de los traslados y envíos activos (Donación en preparación, Donación enviada, En camino, Llegada) para garantizar la transparencia de los despachos hacia los campamentos y zonas afectadas.


### 3. Microservicio de Necesidades (Necesidades)
- **Puerto de red:** 8084
- **Responsabilidad:** Registro y clasificación de las intenciones de ayuda en especie como ropa en buen estado, insumos básicos o materiales de construcción. Vincula las ofertas materiales con el identificador del usuario donante.

---

## Pruebas de Software (Testing)

### Pruebas Unitarias e Integración
El proyecto cuenta con una suite de pruebas automatizadas para asegurar la estabilidad de las reglas de negocio antes de cada despliegue aprovechando las mejoras de rendimiento de las características de Java 21:
- **Service Layer Testing:** Pruebas unitarias con JUnit 5 y Mockito para aislar el comportamiento de los servicios y simular las llamadas a las bases de datos (Repositores mapeados mediante mocks).
- **Controller Layer Testing:** Pruebas de integración mediante MockMvc para validar el correcto funcionamiento de los endpoints HTTP, códigos de estado (200 OK, 201 Created, 401 Unauthorized) y el parseo de estructuras JSON.

### Verificación con Postman
Todos los endpoints asincrónicos han sido probados y validados individualmente utilizando Postman, asegurando que las cabeceras de comunicación, los parámetros de ruta y los cuerpos de petición cumplan estrictamente con las especificaciones de la API REST:
- Pruebas de flujos de registro e inicio de sesión seguro.
- Validación de operaciones CRUD e inserciones en el historial de transacciones.
- Simulación de peticiones cruzadas (Preflight requests) para la validación de las cabeceras CORS.

---

## Requisitos Previos

Antes de ejecutar el sistema, es necesario contar con las siguientes herramientas instaladas de forma local:
- Git
- Docker Desktop

---

## Descarga, Instalación y Despliegue Express

Siga esta secuencia de comandos en su terminal para clonar, compilar y levantar el ecosistema completo de microservicios con sus respectivas bases de datos de forma automatizada:

### 1. Clonar el repositorio del backend
```bash
git clone https://github.com/Tom-BVM/Donaton-BackEnd-Vasquez.git
cd Donaton-BackEnd-Vasquez
```

### 2. Limpieza profunda de caché y contenedores previos
```bash
docker compose down --volumes --rmi all
docker system prune -f
```

### 3. Compilación y arranque del entorno distribuido
Este comando compilará el código fuente de los archivos Java utilizando el JDK de Java 21, ejecutará de forma automática la suite de pruebas unitarias, empaquetará los ejecutables .jar de forma aislada dentro de cada contenedor, creará las bases de datos requeridas y levantará todo el sistema en paralelo incluyendo el servidor de calidad de código:
```bash
docker compose up --build
```

### 4. Puertos de acceso y monitoreo local
- Microservicio Auths: http://localhost:8081
- Microservicio Donaciones: http://localhost:8082
- Microservicio Logística: http://localhost:8083
- Microservicio Necesidades: http://localhost:8084
- Panel de Calidad SonarQube: http://localhost:9000
