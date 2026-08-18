# API de Controle Financeiro Pessoal

API REST para cadastrar e gerenciar transacoes financeiras pessoais.

## Tecnologias

- Java 21
- Spring Boot
- Maven
- Spring Data JPA / Hibernate
- MySQL

## Configuracao do MySQL

Verifica a conexão com o banco em `application.properties` e muda se for preciso:

```properties
spring.datasource.username=root
spring.datasource.password=
```

A aplicacao cria o banco `controle_financeiro` automaticamente se o usuario tiver permissao.

## Executar

Pra executar, bastar rodar o seguinte comando:

```bash
mvn spring-boot:run
```

A API sera iniciada em `http://localhost:8080`.

## Endpoints

| Metodo | Caminho | Ação |
| --- | --- | --- |
| POST | `/transacoes` | Cadastra uma transacao |
| GET | `/transacoes` | Lista todas as transacoes |
| GET | `/transacoes/{id}` | Busca uma transacao pelo id |
| PUT | `/transacoes/{id}` | Atualiza uma transacao |
| DELETE | `/transacoes/{id}` | Exclui uma transacao |

## Exemplo de corpo

```json
{
  "descricao": "Salario",
  "valor": 3500.00,
  "tipo": "RECEITA",
  "data": "2026-08-18",
  "categoria": "Trabalho"
}
```
