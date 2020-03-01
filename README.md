# ejercicio-api-rest
Ejercicio api rest swagger

#### Nombre de la base de datos `liverpool`

```
create database liverpool;
```

#### Dll para la tabla `articulo`

```
DROP TABLE IF EXISTS `articulo`;
CREATE TABLE `articulo` (
  `id` varchar(10) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `precio` decimal(6,2) DEFAULT NULL,
  `modelo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
```
####Clonar repositorio

```
git clone git@github.com:montse2081/ejercicio-api-rest.git
```

####Ejecutar en consola de comandos 

```
mvn spring-boot:run
```


####Validar en la siguiente ruta que el servicio este activo.

[http://127.0.0.1:8080/swagger-ui.html](http://127.0.0.1:8080/swagger-ui.html)


