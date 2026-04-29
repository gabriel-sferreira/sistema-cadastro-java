# 📋 Sistema de Cadastro de Clientes

Sistema de cadastro de clientes desenvolvido em Java com banco de dados PostgreSQL.

## 🚀 Tecnologias utilizadas
- Java
- PostgreSQL 15
- JDBC
- Docker

## ⚙️ Funcionalidades
- ✅ Cadastrar cliente
- ✅ Listar todos os clientes
- ✅ Buscar cliente por ID
- ✅ Atualizar cliente
- ✅ Deletar cliente

## 🐳 Como rodar o banco de dados
```bash
docker run --name postgres-cadastro -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=cadastro_db -p 5433:5432 -d postgres:15
```

## ▶️ Como compilar e rodar
```bash
javac -cp "lib/postgresql-42.7.3.jar" -d out src/database/ConexaoDB.java src/model/Cliente.java src/repository/ClienteRepository.java src/Main.java

java -cp "out;lib/postgresql-42.7.3.jar" Main
```