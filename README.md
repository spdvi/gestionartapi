# gestionartapi

## Adding JWT Authentication and Authorization to the API
- https://www.javainuse.com/spring/boot-jwt
- Need to add the javax.xml.bind jaxb-api dependency to the pom.xml file
- To avoid circular dependendy injection, make WebSecurityConfig passwordEncoder static.

##Deploy to Azure 
En PowerShell Ir al directorio del projecto y ejecutar:

>az login<br/>
>.\mvnw com.microsoft.azure:azure-webapp-maven-plugin:2.3.0:config<br/>
>.\mvnw package azure-webapp:deploy<br/>
