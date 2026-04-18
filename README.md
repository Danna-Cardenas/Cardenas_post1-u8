# Estudiantes App - CRUD con Spring Boot y JPA/Hibernate

AplicaciÃ³n web para gestionar un CRUD completo de estudiantes utilizando Spring Boot, Spring Data JPA, Hibernate y MySQL.

## Requisitos Previos

- **Java 17+** instalado y configurado en PATH
- **MySQL 8.x** instalado y en ejecuciÃ³n
- **Maven 3.x** (incluido en el wrapper de Spring Boot)
- **IDE**: IntelliJ IDEA o VS Code con extensiones Java

## ConfiguraciÃ³n Inicial

### 1. Crear la Base de Datos MySQL

Ejecuta los siguientes comandos en MySQL:

```sql
mysql -u root -p
mysql> CREATE DATABASE estudiantes_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
mysql> CREATE USER "appuser"@"localhost" IDENTIFIED BY "apppass";
mysql> GRANT ALL PRIVILEGES ON estudiantes_db.* TO "appuser"@"localhost";
mysql> FLUSH PRIVILEGES;
mysql> EXIT;
```

### 2. ConfiguraciÃ³n de application.properties

El archivo `src/main/resources/application.properties` ya estÃ¡ configurado con los valores predeterminados:

- **URL**: `jdbc:mysql://localhost:3306/estudiantes_db`
- **Usuario**: `appuser`
- **ContraseÃ±a**: `apppass`
- **Puerto de servidor**: `8080`

Si necesitas cambiar estas configuraciones, edita el archivo `application.properties`.

## CÃ³mo Ejecutar

### OpciÃ³n 1: Con Maven Wrapper (recomendado)

```bash
cd c:\Users\DANNA\Documents\Visual Studio Code\Estudiantes
./mvnw spring-boot:run
```

### OpciÃ³n 2: Con Maven instalado globalmente

```bash
mvn spring-boot:run
```

### OpciÃ³n 3: Compilar y ejecutar JAR

```bash
./mvnw clean package
java -jar target/estudiantes-1.0.0.jar
```

## Acceso a la AplicaciÃ³n

Una vez iniciada, accede a:

- **URL**: http://localhost:8080/estudiantes
- **Listado de estudiantes**: http://localhost:8080/estudiantes
- **Crear nuevo estudiante**: http://localhost:8080/estudiantes/nuevo

## Operaciones CRUD

### 1. Crear Estudiante
- Haz clic en "**+ Nuevo Estudiante**"
- Completa el formulario con:
  - **Nombre**: (2-100 caracteres)
  - **Apellido**: (obligatorio)
  - **Correo**: (email vÃ¡lido, Ãºnico)
  - **Carrera**: (obligatoria)
- Haz clic en "Guardar"

### 2. Leer/Listar Estudiantes
- Accede a http://localhost:8080/estudiantes
- Se mostrarÃ¡ la tabla con todos los estudiantes registrados

### 3. Editar Estudiante
- En la tabla, haz clic en el botÃ³n "**Editar**" del estudiante
- Modifica los datos que desees
- Haz clic en "Guardar"

### 4. Eliminar Estudiante
- En la tabla, haz clic en el botÃ³n "**Eliminar**"
- Confirma la eliminaciÃ³n en la pÃ¡gina de confirmaciÃ³n

## Validaciones

El formulario aplica las siguientes validaciones:

| Campo | ValidaciÃ³n |
|-------|-----------|
| **Nombre** | Obligatorio, 2-100 caracteres |
| **Apellido** | Obligatorio |
| **Correo** | Obligatorio, debe ser un email vÃ¡lido, Ãºnico en BD |
| **Carrera** | Obligatorio |

## Evidencias del Taller (Capturas)

### Captura 1 - creaciÃ³n de la tabla "estudiantes" generado por Hibernate
![Captura 1 - creaciÃ³n de la tabla "estudiantes" generado por Hibernate](./././capturas/Captura1.png)

### Captura 2 - Listado de estudiantes en el navegador
![Captura 2 - Listado de estudiantes en el navegador](./././capturas/captura2.png)

### Captura 3 - Verificar en MySQL: SELECT * FROM estudiantes
![Captura 3 - Verificar en MySQL: SELECT * FROM estudiantes](./././capturas/captura3.png)

### Captura 4 - Edicion de estudiante
![Captura 4 - Edicion de estudiante](./././capturas/captura4.png)

### Captura 5 - Eliminar estudiante
![Captura 5 - Eliminar estudiante](./././capturas/captura5.png)

### Captura 6 - Validacion de correo duplicado (mensaje de error)
![Captura 6 - Validacion de correo duplicado (mensaje de error)](./././capturas/captura6.png)



