# Itaú Unibanco — Desafio de Programação

Seja bem-vindo(a)! Este desafio propõe a criação de uma API REST focada tanto no desenvolvimento quanto na engenharia de software. Queremos avaliar sua capacidade de construir uma solução completa e bem estruturada.

---

## Índice

1. [Introdução](#1-introdução)
2. [Definição do Desafio](#2-definição-do-desafio)
   1. [Restrições Técnicas](#21-restrições-técnicas)
   2. [Endpoints da API](#22-endpoints-da-api)
      1. [Receber Transações: POST /transacao](#221-receber-transações-post-transacao)
      2. [Limpar Transações: DELETE /transacao](#222-limpar-transações-delete-transacao)
      3. [Consultar Estatísticas: GET /estatistica](#223-consultar-estatísticas-get-estatistica)
3. [Extras (Diferenciais)](#4-extras-diferenciais)
4. [Considerações Finais](#5-considerações-finais)

---

## 1. Introdução

Sua missão é construir uma **API REST** que:

- Receba transações financeiras
- Calcule estatísticas com base nas transações recebidas

A implementação deve ser feita em **Java** ou **[Kotlin](https://kotlinlang.org/)** utilizando **Spring Boot**.

Um bom ponto de partida: [Spring Initializr](https://start.spring.io/).

> **Importante:** Não existe uma única solução correta!  
> Avaliaremos critérios como qualidade e clareza do código, organização do projeto, testes, segurança, boas práticas de desenvolvimento, entre outros.

---

## 2. Definição do Desafio

Você deve criar uma API REST hospedada em um repositório público no [GitHub](https://github.com/) ou [GitLab](https://gitlab.com/).

### 2.1. Restrições Técnicas

- **Deve** estar em repositório próprio (não faça fork).
- **Deve** conter pelo menos 1 commit por endpoint (mínimo de 3 commits).
- Todos os commits devem ser feitos pelo mesmo usuário que criou o repositório.
- **Deve** seguir exatamente o formato de endpoints e campos conforme descrito.
- **Não deve** utilizar bancos de dados ou caches externos — tudo deve ser armazenado **em memória**.
- **Deve** aceitar e retornar apenas dados no formato **JSON**.

> **Atenção:** O projeto precisa ser **público** para a avaliação. Após ser corrigido, você pode torná-lo privado.

---

## 3. Endpoints da API

### 3.1. Receber Transações: `POST /transacao`

Recebe uma transação contendo:

```json
{
  "valor": 123.45,
  "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```

| Campo      | Tipo           | Obrigatório | Descrição                                      |
|------------|----------------|-------------|------------------------------------------------|
| `valor`    | Decimal         | Sim         | Valor da transação                             |
| `dataHora` | ISO 8601 (data)  | Sim         | Data e hora em que a transação ocorreu          |

**Regras de validação:**
- `valor` e `dataHora` devem estar preenchidos.
- A `dataHora` **não** pode ser futura.
- `valor` **não** pode ser negativo (valor ≥ 0).

**Respostas esperadas:**
- `201 Created` — Transação registrada com sucesso.
- `422 Unprocessable Entity` — Dados inválidos (ex.: valor negativo ou data futura).
- `400 Bad Request` — Requisição inválida (ex.: JSON mal formatado).

> **Dica:** No Spring Boot, o tipo `OffsetDateTime` é ideal para trabalhar com datas no padrão ISO 8601.

---

### 3.2. Limpar Transações: `DELETE /transacao`

Remove todas as transações armazenadas.

**Resposta esperada:**
- `200 OK` — Todas as informações foram apagadas com sucesso.

---

### 3.3. Consultar Estatísticas: `GET /estatistica`

Calcula e retorna estatísticas das transações realizadas nos últimos **60 segundos**:

```json
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}
```

| Campo  | Tipo     | Descrição                                    |
|--------|----------|----------------------------------------------|
| `count`| Inteiro  | Número de transações                         |
| `sum`  | Decimal  | Soma dos valores transacionados              |
| `avg`  | Decimal  | Média dos valores transacionados             |
| `min`  | Decimal  | Menor valor transacionado                    |
| `max`  | Decimal  | Maior valor transacionado                    |

**Observações:**
- Se não houver transações nos últimos 60 segundos, todos os campos devem ser retornados com valor `0`.
- **Dica:** `DoubleSummaryStatistics` do Java pode facilitar esse cálculo.

**Resposta esperada:**
- `200 OK` — Estatísticas retornadas corretamente.

---

## 4. Extras (Diferenciais)

Se quiser se destacar ainda mais, você pode implementar alguns (ou todos) destes extras:

1. **Testes Automatizados**  
   Unitários e de integração, cobrindo tanto casos positivos quanto negativos.

2. **Containerização**  
   Disponibilizar a aplicação em um container Docker (não é necessário publicar a imagem).

3. **Logs**  
   Registrar logs para rastrear o funcionamento da aplicação.

4. **Observabilidade**  
   Implementar um endpoint de **healthcheck** para monitorar a saúde da aplicação.

5. **Performance**  
   Medir o tempo de execução da geração de estatísticas.

6. **Tratamento Personalizado de Erros**  
   Substituir os erros padrões por mensagens mais descritivas e adequadas.

7. **Documentação da API**  
   Utilizar ferramentas como [Swagger](https://swagger.io/) ou [RAML](http://raml.org/) para documentar os endpoints.

8. **Guia de Execução**  
   Criar um passo a passo para construção e execução da aplicação, facilitando para quem for rodá-la pela primeira vez.

9. **Configuração de Intervalo**  
   Tornar o intervalo de cálculo das estatísticas configurável (default: 60 segundos, mas podendo ser alterado para 120 segundos, por exemplo).

---

## 5. Considerações Finais

Este desafio é uma excelente oportunidade para demonstrar suas habilidades técnicas, atenção a detalhes e boas práticas de desenvolvimento.  
Capriche na implementação e na documentação. Boa sorte! 🚀
```