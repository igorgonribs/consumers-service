# consumers-service
Inicialmente o projeto nasceu on premise, mas após a implementação das funcionalidades básicas os componentes do sistema foram completamente migrados para o Microsoft Azure.

## Desenho da solução atual
![alt text](https://github.com/igorgonribs/consumers-service/blob/main/desenho_solucao.png?raw=true)

## A aplicação Java
Desenvolvida com Spring Boot eJava 11, foi criada uma imagem docker da aplicação utilizando um Dockerfile, e, em seguida, a aplicação foi implantada no Microsoft Azure através do Serviço de Instâncias de Contêiner

## Autenticação
Foi implementada uma autenticação básica http com o Spring Security. Por se tratar de um projeto com efeitos de demonstração, as credenciais válidas são armazenadas em memória durante o start da aplicação.
Para realização de testes, seguem as credenciais válidas:

```bash
username: bankxpto
password: bankxptopassword

username: appxpto
password: appxptopassword

username: userxpto
password: userxptopassword
```

## Base de dados A e B
Para as bases de dados A e B decidiu-se utilizar um banco de dados relacional. Inicialmente foi usado o banco h2, um banco de dados em memória, a fim de agilizar o desenvolvimento.
Em seguida, foi realizada a migração da base de dados para um banco de dados Azure SQL Database, serviço Paas oferecido pelo Microsoft Azure.

## Base de dados C
Para a base de dados C, optou-se pelo uso de um banco de dados NOSql, o MongoDB. O desenvolvimento inicial foi feito utilizando contêiner docker para o banco de dados.
Em seguida, foi realizada a migração da base de dados para uma API do Azure Cosmos DB para conta do MongoDB.

## Testando a aplicação
Para testar a aplicação, basta importar o arquivo *consumer.postman_collection.json* no software *Postman* (ou algum semelhante) e realizar os requests contidos na pasta *cloud* da collection.
As requisições contidas na pasta *local* da collection só devem funcionar caso a aplicação esteja sendo executada localmente.
Entretanto, com a versão atual do projeto não será possível executar a aplicação localmente pois algumas informações de acesso aos bancos de dados foram omitidas do repositório públio do Github.

## Planos Futuros
* Adicionar [Criptografia em repouso](https://docs.microsoft.com/pt-br/azure/security/fundamentals/encryption-atrest) e [Criptografia em trânsito](https://docs.microsoft.com/pt-br/compliance/assurance/assurance-encryption-in-transit) às bases de dados A e B para acrescentar segurança aos dados sensíveis.
* Utilizar o serviço [Azure Key Vault](https://docs.microsoft.com/pt-br/azure/key-vault/general/basic-concepts) para armazenar informações de acesso aos bancos de dados em segurança.
* Avaliar a necessidade de incluir um Gateway de Aplicação na frente do contêiner que executa a aplicação java. O uso de serviço [Application gateway](https://docs.microsoft.com/pt-br/azure/application-gateway/overview) do azure pode trazer benefícios como balanceamento de carga e redirecionamento.
* Avaliar a necessidade de escalar a aplicação, fazendo o deploy de novos contêineres.
