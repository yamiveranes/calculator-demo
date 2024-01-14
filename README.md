# Calculator Demo

------

![](https://img.shields.io/badge/Lenguaje-java-blue.svg?style=for-the-badge)![](https://img.shields.io/badge/version-v0.0.1-success.svg?style=for-the-badge)

------

## Ejecución
Para compilar y ejecutar siga los siguientes pasos:

1. Instalar librería de traceo en el repositorio maven
     ```bash
     $ mvn install:install-file -Dfile=tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true
     ```
2. Compilar y ejecutar el proyecto
     ```bash
     $ cd ./calculator-demo
     $ mvn package
     $ java -jar target/calculator-demo-0.0.1-SNAPSHOT.jar
     ```

Ver la interfaz de swagger en la siguiente url  [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
