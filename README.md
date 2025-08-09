# Prisma Backend - App de Citas ![Java](https://img.shields.io/badge/Java-17+-orange.svg?logo=openjdk&logoColor=white) [![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F.svg?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot) [![Docker](https://img.shields.io/badge/Docker-2496ED.svg?logo=docker&logoColor=white)](https://www.docker.com/)

## Desarrolladores

-   **Mily Sierra** - [GitHub](https://github.com/MilySierra)
-   **Maria Agudelo** - [GitHub](https://github.com/MariAgudelo2)
-   **Shara Olaya** - [GitHub](https://github.com/olayashara)
-   **Jhomar Arrieta**

### Tecnologías y Herramientas Utilizadas

-   ![Java](https://img.shields.io/badge/Java-17+-orange.svg?logo=openjdk&logoColor=white)
-   ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F.svg?logo=springboot&logoColor=white)
-   ![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F.svg?logo=springsecurity&logoColor=white)
-   ![JPA / Hibernate](https://img.shields.io/badge/JPA%20/%20Hibernate-59666C.svg?logo=hibernate&logoColor=white)
-   ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1.svg?logo=postgresql&logoColor=white)
-   ![Docker](https://img.shields.io/badge/Docker-2496ED.svg?logo=docker&logoColor=white)
-   ![Maven](https://img.shields.io/badge/Maven-C71A36.svg?logo=apachemaven&logoColor=white)
-   ![JWT](https://img.shields.io/badge/JWT-000000.svg?logo=jsonwebtokens&logoColor=white)

> [!NOTE]
> Este proyecto corresponde al **backend** de una aplicación de citas. Expone una API RESTful para ser consumida por un cliente frontend.

---

## Descripción del Proyecto 💘

**Prisma Backend** es el corazón de una aplicación de citas, diseñado para gestionar usuarios, preferencias, y la lógica de "matches". La API permite registrar usuarios, gestionar perfiles, establecer preferencias de búsqueda y conectar personas con intereses compatibles. La seguridad se gestiona mediante JSON Web Tokens (JWT) para proteger los endpoints.

El proyecto está completamente **dockerizado**, lo que simplifica enormemente su despliegue y ejecución en cualquier entorno que soporte Docker.

## Requisitos Previos ⚙️

Para poder ejecutar este proyecto, solo necesitas tener instalado:

-   **Docker:** Asegúrate de que el servicio de Docker esté corriendo en tu máquina.
-   **Docker Compose:** Usualmente viene incluido con la instalación de Docker Desktop.

No es necesario instalar Java, Maven o PostgreSQL localmente, ya que todo se ejecuta dentro de contenedores de Docker.

## Instalación y Ejecución 🚀

El proyecto está configurado para levantarse con un solo comando gracias a Docker Compose.

1.  **Clona el repositorio:**
    ```bash
    git clone https://github.com/JhomarArrieta/Prisma-Backend.git
    ```

2.  **Levanta los contenedores:**
    Desde la raíz del proyecto (donde se encuentra el archivo `compose.yaml` o `docker-compose.yml`), ejecuta el siguiente comando:
    ```bash
    docker-compose up --build
    ```
    -   El flag `--build` asegura que se construya la imagen de la aplicación Java desde el `Dockerfile` la primera vez o si hay cambios.
    -   Este comando iniciará dos servicios principales:
        -   **`backend-app`:** El contenedor con la aplicación Spring Boot.
        -   **`db`:** El contenedor con la base de datos PostgreSQL.

3.  **¡Listo! La aplicación estará funcionando:**
    -   La **API RESTful** estará disponible en: `http://localhost:8080`
    -   La **base de datos PostgreSQL** estará accesible en el puerto: `5432` (principalmente para la comunicación interna entre contenedores, pero puedes conectarte desde un cliente local si lo necesitas).

    Las tablas y la base de datos se crearán automáticamente al levantar los contenedores, según la configuración de Spring Boot y JPA.

## Estructura del Proyecto 📂

El proyecto sigue una arquitectura por capas, facilitando la mantenibilidad y escalabilidad.


/
├── src

│   └── main

│       └── java

│           └── com/talentotech/prisma/backend

│               ├── config/         # Configuración general (ej. CORS).

│               ├── controllers/    # Controladores REST (Match, Preferencias, Usuario).

│               ├── dto/            # Data Transfer Objects (AuthResponse, Login, UserCompletedDTO).

│               ├── entities/       # Entidades JPA (Match, Preferencias, Usuario).

│               ├── repositories/   # Repositorios Spring Data JPA.

│               ├── security/       # Configuración de Spring Security y JWT (JwtUtil, SecurityConfig).

│               └── services/       # Lógica de negocio (interfaces e implementaciones).

├── resources/

│   ├── 01-BD-Prisma_Scheme_postgres.sql # Script SQL inicial (si aplica).

│   └── application.properties    # Propiedades de la aplicación.

├── Dockerfile                  # Define la imagen Docker para la app Spring Boot.

├── compose.yaml                # Orquesta los servicios de la app y la base de datos.

└── pom.xml                     # Dependencias y configuración de Maven.



-   **`controllers`**: Exponen los endpoints de la API al exterior.
-   **`dto`**: Objetos planos para transferir datos entre el cliente y el servidor, evitando exponer las entidades de la base de datos directamente.
-   **`entities`**: Clases que mapean las tablas de la base de datos.
-   **`repositories`**: Interfaces que proveen los métodos CRUD y consultas personalizadas a la base de datos.
-   **`security`**: Contiene toda la lógica de autenticación y autorización mediante JWT.
-   **`services`**: Implementa la lógica de negocio, actuando como intermediario entre los controladores y los repositorios.
