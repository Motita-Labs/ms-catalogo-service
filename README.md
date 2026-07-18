# ms-catalogo-service

Microservicio de catálogo de productos (Spring Boot 4, Java 17).

## Endpoints

Base: `/api/v1/producto`

| Método | Ruta                  | Descripción            |
|--------|-----------------------|------------------------|
| POST   | /api/v1/producto      | Crear producto         |
| GET    | /api/v1/producto      | Listar productos       |
| GET    | /api/v1/producto/{id} | Obtener por id         |
| PUT    | /api/v1/producto/{id} | Editar producto        |
| DELETE | /api/v1/producto/{id} | Eliminar producto      |

Puerto: `8080`. Health: `/actuator/health`.

## Build y test

```bash
mvn clean verify
```

## Docker

```bash
docker build -t arriendos/ms-catalogo:latest .
docker run -p 8080:8080 -e DB_URL=jdbc:mysql://host:3306/catalogo arriendos/ms-catalogo:latest
```

Variables: `DB_URL`, `DB_USER`, `DB_PASSWORD`.

## CI/CD

`.github/workflows/ci-cd.yml`: build + test (`mvn verify`) y publicación de imagen en GHCR.
