<h1 align="center">
    Users-API-Ecommerce
</h1>


# ℹ️ Sobre

<p>
Projeto de construção de um e-commerce utilizando o conceito de microserviços. 
</p>
  <br>

# 🛠 Tecnologias

As seguintes tecnologias foram utilizadas na construção do projeto:
  
- Maven
- Java 11
- Spring Boot
- Spring Data
- Spring JPA
- Lombok
- MySQL
- Docker
  <br><br>

# 🚀 Como executar

Clone o projeto e acesse a pasta.

```
$ git clone https://github.com/rodrigorvix/users-api.git
$ cd users-api
```

# ℹ️ Rotas

Segue abaixo os endpoints disponíveis no projeto.


<details><summary><b>Rotas de usuário (Clique aqui)</b></summary>

1 - POST - http://localhost:8081/v1/users

```
{
	"name":"Teste01",
	"username":"teste01",
	"password":"123456",
	"profile":"ADMIN",
	"birthDate":"1995-05-30"
}
```
2- GET - http://localhost:8081/v1/users

```

```

3 - PATCH - http://localhost:8081/v1/users/{user_id}

```
{
	"name":"Teste01",
	"username":"teste01",
	"password":"123456",
	"profile":"ADMIN",
	"birthDate":"1995-05-30"
}
```

4 - DELETE - http://localhost:8081/v1/users/{user_id}

```

```
</details>
