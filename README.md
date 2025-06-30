# Projeto de Treino - PokéAPI com Java

Este é um projeto de treino em Java que consome a [PokéAPI](https://pokeapi.co/) para buscar informações de um Pokémon digitado pelo usuário (por nome ou ID).

## Funcionalidades

- Busca Pokémon pelo nome ou ID
- Mostra no console:
  - Nome
  - ID
  - Tipos
  - Habilidades
  - Link da imagem (sprite)
- Usa a biblioteca Gson com deserializador personalizado

## Tecnologias usadas

- Java 17
- Gson
- HttpClient (Java nativo)
- Scanner (entrada de dados)
- Swing (opcional, para exibir imagem)

## Como usar

1. Clone o repositório
2. Compile com sua IDE ou pelo terminal
3. Execute a classe `Main.java`
4. Digite o nome ou ID de um Pokémon

## Exemplo

Insira o nome do Pokémon ou seu ID: bulbasaur

Nome: bulbasaur
Id: 1
Tipos: grass, poison
Habilidades: overgrow, chlorophyll
Sprite: https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png


## Objetivo

Este projeto foi feito para praticar:

- Requisições HTTP em Java
- Leitura e tratamento de JSON com Gson
- Organização de projeto em pacotes

---

Feito por Fernando Calisto
