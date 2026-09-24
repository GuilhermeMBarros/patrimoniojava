# Sistema de Gerenciamento de Patrimônio

Sistema desktop voltado para o controle e gestão do patrimônio de uma instituição de educação profissional. O projeto visa registrar, movimentar, categorizar e dar baixa em bens patrimoniais de forma eficiente e estruturada.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java
* **Banco de Dados:** MySQL
* **Paradigma:** Programação Orientada a Objetos (POO) + Princípios **SOLID**
* **Interface Gráfica:** Java Swing / AWT (Janelas)

---

## 🏗️ Arquitetura e Estrutura de Pacotes

O projeto foi estruturado buscando a separação clara de responsabilidades (Single Responsibility Principle):

* `POJO` *(Plain Old Java Object)*: Contém os modelos/entidades do sistema (classes com atributos, getters e setters).
* `DAO` *(Data Access Object)*: Responsável por toda a manipulação e persistência de dados junto ao banco de dados MySQL.
* `Janela`: Contém as interfaces gráficas (telas do sistema).
* `Imagens`: Armazena os recursos visuais e ícones utilizados nas interfaces.

---

## 🗄️ Banco de Dados

O banco de dados do sistema é denominado **`laranchinha`** e conta com as seguintes tabelas[cite: 1]:

| Tabela | Descrição |
| :--- | :--- |
| `baixas_patrimonio`[cite: 1] | Registro de baixas e descarte de bens patrimoniais |
| `categorias`[cite: 1] | Categorização dos bens (ex: Informática, Mobiliário, Equipamentos) |
| `cursos`[cite: 1] | Cursos vinculados aos locais ou uso dos bens |
| `locais`[cite: 1] | Mapeamento de salas, laboratórios e setores |
| `movimentacoes`[cite: 1] | Histórico de movimentação dos bens entre locais/responsáveis |
| `patrimonios`[cite: 1] | Cadastro principal dos bens patrimoniais da instituição |
| `usuarios`[cite: 1] | Usuários do sistema e seus níveis de acesso |

```sql
CREATE DATABASE  IF NOT EXISTS `laranchinha` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `laranchinha`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: laranchinha
-- ------------------------------------------------------
-- Server version	26.7.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '27350081-a149-11f1-9102-a68eb6e053f4:1-20';

--
-- Table structure for table `baixas_patrimoniais`
--

DROP TABLE IF EXISTS `baixas_patrimoniais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baixas_patrimoniais` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patrimonio_id` int NOT NULL,
  `usuario_registro_id` int NOT NULL,
  `tipo_baixa` enum('Descarte','Venda','Doação','Furto/Roubo','Extravio') NOT NULL,
  `motivo` text NOT NULL,
  `valor_recuperado` decimal(10,2) DEFAULT '0.00',
  `documento_comprobatorio` varchar(100) DEFAULT NULL,
  `data_baixa` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `patrimonio_id` (`patrimonio_id`),
  KEY `usuario_registro_id` (`usuario_registro_id`),
  CONSTRAINT `baixas_patrimoniais_ibfk_1` FOREIGN KEY (`patrimonio_id`) REFERENCES `patrimonios` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `baixas_patrimoniais_ibfk_2` FOREIGN KEY (`usuario_registro_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baixas_patrimoniais`
--

LOCK TABLES `baixas_patrimoniais` WRITE;
/*!40000 ALTER TABLE `baixas_patrimoniais` DISABLE KEYS */;
/*!40000 ALTER TABLE `baixas_patrimoniais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `sigla` varchar(10) NOT NULL,
  `criado_por` int DEFAULT NULL,
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `criado_por` (`criado_por`),
  CONSTRAINT `cursos_ibfk_1` FOREIGN KEY (`criado_por`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locais`
--

DROP TABLE IF EXISTS `locais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locais` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `criado_por` int DEFAULT NULL,
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `criado_por` (`criado_por`),
  CONSTRAINT `locais_ibfk_1` FOREIGN KEY (`criado_por`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locais`
--

LOCK TABLES `locais` WRITE;
/*!40000 ALTER TABLE `locais` DISABLE KEYS */;
/*!40000 ALTER TABLE `locais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimentacoes`
--

DROP TABLE IF EXISTS `movimentacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimentacoes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patrimonio_id` int NOT NULL,
  `usuario_registro_id` int NOT NULL,
  `tipo_movimentacao` enum('Empréstimo','Devolução','Envio Manutenção','Retorno Manutenção','Transferência de Local','Baixa') NOT NULL,
  `responsavel_destino` varchar(150) DEFAULT NULL,
  `documento_responsavel` varchar(50) DEFAULT NULL,
  `data_saida` datetime DEFAULT CURRENT_TIMESTAMP,
  `data_prevista_retorno` datetime DEFAULT NULL,
  `data_retorno_efetivo` datetime DEFAULT NULL,
  `observacoes` text,
  PRIMARY KEY (`id`),
  KEY `patrimonio_id` (`patrimonio_id`),
  KEY `usuario_registro_id` (`usuario_registro_id`),
  CONSTRAINT `movimentacoes_ibfk_1` FOREIGN KEY (`patrimonio_id`) REFERENCES `patrimonios` (`id`) ON DELETE CASCADE,
  CONSTRAINT `movimentacoes_ibfk_2` FOREIGN KEY (`usuario_registro_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimentacoes`
--

LOCK TABLES `movimentacoes` WRITE;
/*!40000 ALTER TABLE `movimentacoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimentacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patrimonios`
--

DROP TABLE IF EXISTS `patrimonios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patrimonios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero_tombamento` varchar(50) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `descricao` text,
  `curso_id` int DEFAULT NULL,
  `local_id` int DEFAULT NULL,
  `categoria_id` int DEFAULT NULL,
  `status` enum('Disponível','Emprestado','Em Manutenção','Baixado/Inativo') DEFAULT 'Disponível',
  `valor_aquisicao` decimal(10,2) DEFAULT NULL,
  `data_aquisicao` date DEFAULT NULL,
  `criado_por` int NOT NULL,
  `atualizado_por` int DEFAULT NULL,
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `atualizado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_tombamento` (`numero_tombamento`),
  KEY `curso_id` (`curso_id`),
  KEY `local_id` (`local_id`),
  KEY `categoria_id` (`categoria_id`),
  KEY `criado_por` (`criado_por`),
  KEY `atualizado_por` (`atualizado_por`),
  CONSTRAINT `patrimonios_ibfk_1` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`id`) ON DELETE SET NULL,
  CONSTRAINT `patrimonios_ibfk_2` FOREIGN KEY (`local_id`) REFERENCES `locais` (`id`) ON DELETE SET NULL,
  CONSTRAINT `patrimonios_ibfk_3` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`) ON DELETE SET NULL,
  CONSTRAINT `patrimonios_ibfk_4` FOREIGN KEY (`criado_por`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `patrimonios_ibfk_5` FOREIGN KEY (`atualizado_por`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patrimonios`
--

LOCK TABLES `patrimonios` WRITE;
/*!40000 ALTER TABLE `patrimonios` DISABLE KEYS */;
/*!40000 ALTER TABLE `patrimonios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha_hash` varchar(255) NOT NULL,
  `perfil` enum('Administrador','Coordenador','Assistente') DEFAULT 'Assistente',
  `ativo` tinyint(1) DEFAULT '1',
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `atualizado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Pedro','pedro@email.com','58184999a139ca29db8e63417d9b49baf03ebc2150e925d08c8e45c6a57150a6','Administrador',1,'2026-08-27 12:27:28','2026-08-27 12:27:28'),(2,'Igor','igor@email.com','58184999a139ca29db8e63417d9b49baf03ebc2150e925d08c8e45c6a57150a6','Administrador',1,'2026-08-27 12:29:07','2026-08-27 12:29:07'),(3,'Marcelo','Marcelo@email.com','58184999a139ca29db8e63417d9b49baf03ebc2150e925d08c8e45c6a57150a6','Administrador',1,'2026-08-27 12:30:10','2026-08-27 12:30:10'),(4,'Guilherme','guilherme@email.com','58184999a139ca29db8e63417d9b49baf03ebc2150e925d08c8e45c6a57150a6','Administrador',1,'2026-08-27 12:34:54','2026-08-27 12:34:54'),(52,'isa','isa','isa','Coordenador',1,'2026-09-10 12:42:50','2026-09-10 12:42:50');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-09-24  9:32:01


```




---

## 🧩 Princípios SOLID Aplicados

1. **SRP (Single Responsibility Principle):** Separação estrita entre modelo (`POJO`), acesso ao banco (`DAO`) e interface visual (`Janela`).
2. **OCP (Open/Closed Principle):** Estrutura aberta para expansão de novos relatórios e telas sem alterar o núcleo das entidades.
3. **LSP (Liskov Substitution Principle):** Utilização de interfaces e heranças consistentes para classes de dados e acesso a dados.
4. **ISP (Interface Segregation Principle):** Interfaces de persistência enxutas e específicas para cada entidade.
5. **DIP (Dependency Inversion Principle):** Desacoplamento entre as regras de negócio e os módulos de persistência/interface.

---

## 🚀 Como Executar o Projeto

1. **Clonar o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)