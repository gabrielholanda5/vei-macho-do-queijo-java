# Véi Macho do Queijo — Java

Este projeto marca o início de uma jornada de evolução em Java,
usando como base uma experiência real com uma antiga loja.

A ideia é desenvolver o mesmo sistema em três etapas:

1️⃣ CRUD em Java puro  
2️⃣ Java + banco de dados (JDBC)  
3️⃣ API REST com Spring Boot  

Este repositório representa a **primeira etapa**, focada em
fundamentos da linguagem, orientação a objetos e lógica.

✅ Etapa 1 — Java puro (concluída)

Nesta primeira fase, desenvolvi um sistema de controle de estoque utilizando apenas Java, rodando no console.

Funcionalidades implementadas:

Cadastro de produtos

Listagem de produtos

Atualização de produto por ID

Exclusão de produto por ID

Geração automática de ID

Menu interativo no console

Validação das entradas do usuário:

Apenas números onde necessário

Apenas texto no nome do produto

Bloqueio de valores inválidos (quantidade e preço)

🗂 Organização do código

O projeto segue uma estrutura simples e organizada:

model
Contém a entidade Produto, com seus atributos e métodos de acesso.

service
Contém a classe ProdutoService, responsável pelas regras de negócio (CRUD).

main
Contém a classe Main, responsável pela interação com o usuário e validação das entradas.

🚧 Projeto em desenvolvimento.

