
**Cadastro de Clientes**

O projeto foi estruturado em módulos Maven, principalmente quatro módulos são identificados:

 - Um para o domínio, "Glue"
 - Um para persistência, "DAO", implementado com Spring JdbcTemplate
 - Um de serviço "Serviço", qual é a própria api
 - E finalmente um de exposição da API, "End Point", implementado com Spring Boot.

Docker Compose é usado para fornecer um ambiente de execução.

