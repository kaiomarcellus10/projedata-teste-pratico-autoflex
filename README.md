# Inventory Management API

API REST desenvolvida em **Spring Boot** para controle de estoque, produção e relacionamento entre produtos e matérias-primas.

Este projeto foi desenvolvido como **desafio técnico**, com foco em:
- organização de camadas
- regras de negócio claras
- tratamento de exceções
- uso de JPA com banco em memória (H2)

---

## 📌 Funcionalidades principais

- Cadastro de produtos
- Cadastro de matérias-primas
- Associação entre produto e matérias-primas (BOM – Bill of Materials)
- Execução de produção com baixa automática de estoque
- Validações de estoque insuficiente
- Tratamento global de erros com mensagens claras

---

## 🧱 Estrutura do Projeto

A estrutura completa dos arquivos e a explicação de cada classe estão documentadas em:

➡️ **[PROJECT_STRUCTURE.md](PROJECT_STRUCTURE.md)**

---

## ▶️ Como executar o projeto

### Pré-requisitos
- Java 17+
- Maven (ou Maven Wrapper)

### Executar no Linux / Mac
```bash
./mvnw spring-boot:run

### Executar no Windows
```bash
mvnw.cmd spring-boot:run

### A aplicação será iniciada em:
http://localhost:8080

## 🔗 Principais endpoints

### Produtos
- `POST /produtos`
- `GET /produtos`
- `GET /produtos/{id}`

### Matérias-primas
- `POST /raw-materials`
- `GET /raw-materials`
- `GET /raw-materials/{id}`

### Associação Produto ↔ Matéria-prima
- `POST /product-materials?productId={id}&rawMaterialId={id}&quantityNeeded={qtd}`

### Produção
- `POST /production`

#### Exemplo de payload
```json
{
  "productId": 1,
  "quantity": 1
}
## 🧪 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
