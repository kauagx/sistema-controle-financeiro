# API de Controle Financeiro Pessoal

API REST para cadastrar e gerenciar transacoes financeiras pessoais.

## Tecnologias

- Java 21
- Spring Boot
- Maven
- Spring Data JPA / Hibernate
- MySQL

## Configuracao do MySQL

Confira as credenciais em `src/main/resources/application.properties` e altere se necessario:

```properties
spring.datasource.username=root
spring.datasource.password=
```

Com o MySQL em execucao, a aplicacao cria o banco `controle_financeiro` automaticamente, caso o usuario tenha permissao.

## Executar

No PowerShell, na pasta do projeto:

```powershell
mvn spring-boot:run
```

A API sera iniciada em `http://localhost:8080`.

## Endpoints

| Metodo | Caminho | Acao |
| --- | --- | --- |
| POST | `/transacoes` | Cadastra uma transacao |
| GET | `/transacoes` | Lista todas as transacoes |
| GET | `/transacoes/{id}` | Busca uma transacao pelo id |
| PUT | `/transacoes/{id}` | Atualiza uma transacao |
| DELETE | `/transacoes/{id}` | Exclui uma transacao |

## Exemplo de corpo para POST e PUT

```json
{
  "descricao": "Salario",
  "valor": 3500.00,
  "tipo": "RECEITA",
  "data": "2026-08-18",
  "categoria": "Trabalho"
}
```
