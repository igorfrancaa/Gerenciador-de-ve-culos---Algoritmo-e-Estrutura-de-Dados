# Gerenciador de Veículos

## 🔗 Link da Apresentação em Vídeo

> **Link da Apresentação em Vídeo:** [https://www.youtube.com/watch?v=ZMG2QOFYzuY]

## 📋 Sobre o projeto

Aplicação Java de console para gerenciamento de veículos, desenvolvida para demonstrar uma estrutura de dados e as operações CRUD (Create, Read, Update e Delete).

Cada veículo possui ID, marca, modelo, ano e placa.

## 🛠️ Tecnologias

- Java
- Scanner
- HashMap
- Programação Orientada a Objetos

## 🗂️ Estrutura

```text
aesa-atividades/
├── README.md
└── src/
    └── br/
        └── edu/
            └── aesa/
                ├── model/
                │   └── Veiculo.java
                ├── service/
                │   └── VeiculoService.java
                └── app/
                    └── Main.java
```

## 🧱 Estrutura de dados escolhida

Foi escolhido o `HashMap<Integer, Veiculo>`. O ID do veículo é usado como chave e o objeto `Veiculo` como valor.

A escolha ocorre porque o sistema trabalha frequentemente com um identificador único. O `HashMap` permite localizar um registro pela chave com complexidade média O(1), tornando busca, atualização e remoção eficientes.

## ⏱️ Complexidade

| Operação | Complexidade média |
|---|---|
| Cadastro | O(1) |
| Busca por ID | O(1) |
| Atualização | O(1) |
| Remoção | O(1) |
| Listagem | O(n) |

O consumo de memória é O(n), proporcional à quantidade de veículos armazenados.

## 🔄 CRUD

- **Create:** `cadastrar(Veiculo veiculo)` valida o objeto, o ID e impede duplicidade.
- **Read:** `buscarPorId(int id)` busca um veículo e `listarTodos()` retorna todos.
- **Update:** `atualizar(int id, Veiculo novosDados)` substitui os dados de um registro existente.
- **Delete:** `remover(int id)` remove o registro pelo ID.

## 🖥️ Funcionalidades

```text
[1] Cadastrar veículo
[2] Listar veículos
[3] Buscar veículo por ID
[4] Atualizar veículo
[5] Remover veículo
[0] Sair
```

O sistema trata ID duplicado, ID inválido, registros inexistentes, lista vazia e entradas numéricas inválidas.

## ▶️ Como executar

Abra o projeto em uma IDE compatível com Java e execute:

`src/br/edu/aesa/app/Main.java`

## 🎥 Demonstração sugerida

Para o vídeo, demonstre:

1. Cadastro de pelo menos 3 veículos;
2. Listagem dos veículos;
3. Busca de um ID existente;
4. Busca de um ID inexistente;
5. Atualização de um veículo;
6. Nova listagem para comprovar a alteração;
7. Remoção de um veículo;
8. Nova listagem para comprovar a exclusão;
9. Encerramento pelo menu.
