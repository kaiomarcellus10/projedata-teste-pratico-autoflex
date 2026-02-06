# Project Structure – Inventory System

Este documento descreve a organização dos arquivos e pacotes do projeto **Inventory**, explicando a responsabilidade de cada classe.

---

## 📦 Package: `com.projedata.inventory`

### 🚀 Aplicação

- **InventoryApplication.java**  
  Classe principal do Spring Boot. Responsável por inicializar a aplicação.

---

### 🎮 Controllers (Camada de Entrada – API REST)

- **HelloController.java**  
  Controller simples para teste de funcionamento da aplicação.

- **ProdutoController.java**  
  Exposição dos endpoints REST relacionados a produtos.

- **RawMaterialController.java**  
  Endpoints responsáveis pelo gerenciamento de matérias-primas.

- **ProductMaterialController.java**  
  Controller responsável por associar produtos às matérias-primas necessárias para produção.

- **ProductionController.java**  
  Endpoint responsável por executar o processo de produção de um produto, validando estoque e consumindo matérias-primas.

---

### 🧠 Services (Regras de Negócio)

- **ProdutoService.java**  
  Contém as regras de negócio relacionadas a produtos.

- **RawMaterialService.java**  
  Implementa a lógica de controle de estoque de matérias-primas.

- **ProductMaterialService.java**  
  Gerencia a relação entre produtos e matérias-primas, incluindo validações.

- **ProductionService.java**  
  Responsável pela lógica de produção, cálculo de consumo de materiais e atualização de estoque.

---

### 🗂️ Repositories (Acesso a Dados – JPA)

- **ProdutoRepository.java**  
  Interface JPA para persistência de produtos.

- **RawMaterialRepository.java**  
  Repositório responsável pelo acesso aos dados de matérias-primas.

- **ProductMaterialRepository.java**  
  Repositório da relação entre produtos e matérias-primas.

---

### 📄 Entities (Modelo de Dados)

- **Produto.java**  
  Entidade que representa um produto.

- **RawMaterial.java**  
  Entidade que representa uma matéria-prima e seu estoque.

- **ProductMaterial.java**  
  Entidade que representa a quantidade de matéria-prima necessária para produzir um produto.

---

### 📥 DTOs (Objetos de Transferência)

- **ProdutoRequestDTO.java**  
  DTO utilizado para criação e atualização de produtos via API.

- **ProductionRequest.java**  
  DTO utilizado para receber requisições de produção.

---

### ⚠️ Exceptions (Tratamento de Erros)

- **ProdutoNaoEncontradoException.java**  
  Exceção lançada quando um produto não é encontrado.

- **ProductWithoutMaterialsException.java**  
  Exceção lançada quando um produto não possui matérias-primas configuradas.

- **InsufficientStockException.java**  
  Exceção lançada quando o estoque de matéria-prima é insuficiente para a produção.

- **GlobalExceptionHandler.java**  
  Classe responsável por capturar exceções e retornar respostas HTTP padronizadas.

---

## 🛠️ Resources

- **application.properties**  
  Arquivo de configuração da aplicação (banco de dados, JPA, etc).

---

## 🧪 Testes

- **src/test/java**  
  Estrutura reservada para testes automatizados.

---

## 📌 Observações

- A aplicação segue o padrão **Controller → Service → Repository**.
- Todas as regras de negócio estão concentradas na camada **Service**.
- Controllers são responsáveis apenas por receber e responder requisições HTTP.
- O tratamento de erros é centralizado no `GlobalExceptionHandler`.
