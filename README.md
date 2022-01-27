# gestionartapi

Inicializar spring boot initialzr con Maven Spring boot 2.6.3 Java 11 jar/war?
Dependencies> Spring Web, MySQL Driver, Spring Data JDBC

##Deploy to Azure 
Nueva Web App Windows Java 11.
En PowerShell Ir al directorio del projecto y ejecutar:

>az login<br/>
>.\mvnw com.microsoft.azure:azure-webapp-maven-plugin:2.3.0:config<br/>
>.\mvnw package azure-webapp:deploy<br/>
