# gestionartapi

##Deploy to Azure 
En PowerShell Ir al directorio del projecto y ejecutar:

>az login<br/>
>.\mvnw com.microsoft.azure:azure-webapp-maven-plugin:2.3.0:config<br/>
>.\mvnw package azure-webapp:deploy<br/>
