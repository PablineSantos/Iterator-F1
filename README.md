# 🏎️ Sistema de Listagem de Pilotos de Fórmula 1 com Estruturas de Dados

Aplicação web desenvolvida em **Java** com **Spring Boot** que realiza a leitura e exibição de dados de pilotos de Fórmula 1 a partir de um arquivo CSV.

O projeto foi criado com o objetivo de estudar e aplicar, na prática, o **padrão Iterator**, além de reforçar conceitos de **estruturas de dados**, **leitura de arquivos**, **arquitetura em camadas** e integração com o ecossistema Spring.

---

## 🎯 Objetivo do Projeto

Este projeto foi desenvolvido para:

- Estudar o padrão de projeto **Iterator** na prática
- Trabalhar com diferentes **estruturas de dados do Java**
- Praticar leitura de arquivos CSV
- Desenvolver uma aplicação web com **Spring Boot**
- Utilizar **Thymeleaf** para renderização das páginas
- Reforçar a organização de um projeto em camadas

---

## 🧠 Padrão de Projeto Aplicado

### 🔹 Iterator

O padrão **Iterator** foi utilizado para permitir a navegação padronizada sobre diferentes estruturas de dados que armazenam os pilotos.

A ideia principal é que a camada de serviço consiga percorrer os elementos **sem depender da implementação interna da coleção utilizada**.

No projeto, a classe `Persistencia` lê os dados do arquivo CSV, armazena os pilotos em uma estrutura específica e retorna um `Iterator<Piloto>`.

Dessa forma, a camada `Service` pode percorrer os pilotos sempre da mesma maneira, utilizando os métodos:

- `hasNext()`
- `next()`

independentemente de os dados estarem em:

- `HashSet`
- `TreeSet`
- `ArrayDeque`
- `HashMap`
- `Stack`

#### Exemplo de uso

```java
while (iteratorDePilotos.hasNext()) {
    Piloto pilotoAtual = iteratorDePilotos.next();
    pilotosParaExibicao.add(pilotoAtual);
}
```

#### Fluxo de funcionamento

```text
PilotoService
    ↓
recebe o tipo de estrutura escolhido
    ↓
Persistencia
    ↓
lê o arquivo CSV
    ↓
armazena os pilotos na estrutura escolhida
    ↓
retorna Iterator<Piloto>
    ↓
PilotoService percorre com hasNext() e next()
    ↓
dados enviados para a view
```

---

## 🏗 Arquitetura do Projeto

O sistema segue uma arquitetura em camadas:

```text
Controller
   ↓
Service
   ↓
Persistencia
   ↓
Entity
   ↓
Arquivo CSV
```

### Controller

Responsável por receber as requisições HTTP e encaminhar os dados para as páginas.

- `PilotoController`

### Service

Contém a lógica de seleção da estrutura de dados e o processamento dos pilotos para exibição.

- `PilotoService`

### Persistência

Responsável por ler o arquivo CSV, montar a coleção correspondente e retornar um iterador.

- `Persistencia`

### Entity

Representa os dados do piloto.

- `Piloto`

### View

Interface web renderizada com Thymeleaf.

- `index.html`
- `pilotos.html`

---

## 🔄 Fluxo do Sistema

### Escolha da estrutura de dados

```text
Usuário acessa /
        ↓
Página inicial (index)
        ↓
Usuário seleciona uma estrutura
        ↓
Requisição para /pilotos
        ↓
PilotoController
        ↓
PilotoService
        ↓
Persistencia
        ↓
Leitura do arquivo CSV
        ↓
Criação da estrutura escolhida
        ↓
Retorno de Iterator<Piloto>
        ↓
Percurso dos elementos
        ↓
Envio para a view
        ↓
Exibição na página pilotos
```

---

## 📚 Estruturas de Dados Trabalhadas

### `HashSet`

Estrutura que não permite elementos duplicados e não garante ordem de exibição.

### `TreeSet`

Estrutura que não permite duplicados e mantém os elementos ordenados com base no método `compareTo()` da classe `Piloto`.

### `ArrayDeque`

Estrutura baseada em deque, permitindo inserções e remoções eficientes nas extremidades.

### `HashMap`

Estrutura baseada em chave e valor. No projeto, os pilotos são armazenados com chave numérica e exibidos por meio dos valores do mapa.

### `Stack`

Estrutura baseada no conceito **LIFO** (*Last In, First Out*), em que o último elemento inserido é o primeiro a sair.

---

## 🧱 Classe Principal da Entidade

A classe `Piloto` representa cada piloto de Fórmula 1 carregado do arquivo CSV.

### Atributos

- `id`
- `nome`
- `nacionalidade`
- `idade`
- `equipe`
- `motor`
- `pontos`

### Implementações importantes

- `Comparable<Piloto>` para ordenação por nome
- `equals()` e `hashCode()` com base no atributo `nome`
- Construtor que recebe uma linha do arquivo CSV e transforma em objeto

---

## 🛠 Tecnologias Utilizadas

- Java
- Spring Boot
- Spring MVC
- Thymeleaf
- Maven
- Coleções do Java Framework
- Leitura de arquivos com `BufferedReader` e `FileReader`

---

## 📂 Estrutura do Projeto

```text
src
 └─ main
     ├─ java
     │   └─ com.senai.pabline.f1
     │       ├─ controller
     │       │   └─ PilotoController.java
     │       ├─ entity
     │       │   └─ Piloto.java
     │       ├─ persistencia
     │       │   └─ Persistencia.java
     │       └─ service
     │           └─ PilotoService.java
     └─ resources
         ├─ dados
         │   └─ DadosDosPilotosF1.csv
         └─ templates
             ├─ index.html
             └─ pilotos.html
```

---

## ▶ Como Executar o Projeto

### 1️⃣ Clone o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

### 2️⃣ Abra o projeto na sua IDE

Exemplo: **IntelliJ IDEA**

### 3️⃣ Execute a aplicação

Execute a classe principal do Spring Boot.

### 4️⃣ Acesse no navegador

```text
http://localhost:8080/
```

---

## 📌 Funcionalidades

- Leitura de pilotos a partir de arquivo CSV
- Exibição dos dados em página web
- Escolha da estrutura de dados para processamento
- Percurso dos elementos com `Iterator`
- Comparação prática entre diferentes coleções do Java

---

## 👩‍💻 Autor

**Pabline Pereira**

Estudante de Engenharia de Software, com interesse em desenvolvimento backend, Java, Spring Boot e arquitetura de sistemas.
