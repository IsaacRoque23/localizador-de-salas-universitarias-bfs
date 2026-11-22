# 📍 Localizador de Salas Universitárias — BFS

## Sobre o projeto

O projeto consiste no desenvolvimento de um sistema de localização de ambientes universitários, com o objetivo de facilitar a navegação de estudantes, professores e visitantes dentro de uma universidade.

A proposta é permitir que o usuário informe um local de origem e um destino, obtendo o caminho que deverá percorrer para chegar ao ambiente desejado.

## 🎯 Objetivo

Solucionar dificuldades de localização dentro de ambientes universitários, utilizando algoritmos de busca em grafos para encontrar caminhos entre diferentes locais da instituição.

## ⚙️ Funcionamento

A universidade será representada por um grafo, onde:

- **Vértices:** representam os ambientes da universidade, como salas de aula, laboratórios, biblioteca, secretaria, cantina e auditório.
- **Arestas:** representam as conexões existentes entre esses ambientes.

O sistema utilizará o algoritmo **BFS (Breadth-First Search / Busca em Largura)** para explorar as conexões a partir do local de origem e encontrar um caminho até o destino, priorizando aquele com a menor quantidade de conexões.

## 🧠 Algoritmo utilizado

O BFS (Busca em Largura) é um algoritmo de busca em grafos que explora os vértices por níveis, utilizando uma fila (Queue) para controlar a ordem de visitação.

Em um grafo não ponderado, o BFS permite encontrar um caminho com o menor número de arestas entre o vértice de origem e o destino.

## 📌 Exemplo

**Origem:** Biblioteca

**Destino:** Auditório

**Caminho encontrado:**

Biblioteca → Secretaria → Cantina → Auditório

**Total de conexões:** 3
