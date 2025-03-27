# TECNOLOGIAS 
java 17
spring boot 3.2.5
rest template (para poder leer el api)
## PARA EJECUCION DEL PROYECTO 
mvn clean install  
mvn spring-boot:run  
#PARA ACCESO A LOS SEVICIOS DE CONSUMOS 
#POR PROVINCIA
http://localhost:8080/api/ubicacion/provincias
#POR CANTON
http://localhost:8080/api/ubicacion/cantones/{provinciaId}
#POR PARROQUIA
http://localhost:8080/api/parroquias/{provinciaId}/{cantonId}
# PARA LA PARTE DE FRONTEND USE THYMELEAF QUE VIENE INTEGRADO CON SPRING BOOT, QUE SE ENCUENTRA EN LA CARPETA TEMPLATES
http://localhost:8080/
