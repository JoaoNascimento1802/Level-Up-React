# Level Up - React & Spring Boot CRUD

![GitHub repo size](https://img.shields.io/github/repo-size/JoaoNascimento1802/Level-Up-React?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/JoaoNascimento1802/Level-Up-React?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/JoaoNascimento1802/Level-Up-React?style=for-the-badge)
![GitHub issues](https://img.shields.io/github/issues/JoaoNascimento1802/Level-Up-React?style=for-the-badge)
![GitHub pull requests](https://img.shields.io/github/issues-pr/JoaoNascimento1802/Level-Up-React?style=for-the-badge)

> Este projeto é um CRUD completo de gerenciamento de videogames, utilizando **React** no front-end e **Spring Boot** no back-end. Os dados são persistidos em um banco de dados **MySQL** e a API REST permite operações de criação, leitura, atualização e remoção de jogos eletrônicos.

## 🧩 Tecnologias Utilizadas

- ✅ React (Front-end)
- ✅ Spring Boot (Back-end)
- ✅ Java 21
- ✅ MySQL
- ✅ Axios
- ✅ Bootstrap

## 📁 Estrutura

- `Main_App` – Contém o código-fonte do front-end em React.
- `Main_Backend` – Contém o código-fonte do back-end em Spring Boot.

## 💻 Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:

- [Node.js](https://nodejs.org/)
- [Java 21](https://jdk.java.net/21/)
- [MySQL](https://www.mysql.com/)
- [Maven](https://maven.apache.org/)

## 🚀 Executando o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/JoaoNascimento1802/Level-Up-React.git
cd Level-Up-React
```

### 2. Inicie o back-end

```bash
git checkout main_backend
# Configure o application.properties com as credenciais do MySQL
./mvnw spring-boot:run
```

### 3. Inicie o front-end

```bash
git checkout main
npm install
npm run dev
```

Acesse o projeto em `http://localhost:5173` (ou conforme o indicado no terminal).

## 🕹 Funcionalidades

- ✅ Cadastrar videogames
- ✅ Listar videogames cadastrados
- ✅ Editar informações de um videogame
- ✅ Excluir videogames
- ✅ Comunicação total com a API RESTful via Axios

## 🤝 Desenvolvedores

- João Emanuel – [@JoaoNascimento1802](https://github.com/JoaoNascimento1802)  
- Felipe Araújo – [@fearaujo293](https://github.com/fearaujo293)  
- Nicolas Henrique – [@Nicoo200](https://github.com/Nicoo200)  

## 📝 Licença

Este projeto está licenciado sob os termos do arquivo [LICENSE](LICENSE.md).

> Projeto desenvolvido como parte da formação técnica no SENAI, com foco em aplicações web fullstack.
