Feature: Recruitment

Scenario: CT-44 Criar novo candidato
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "Recruitment" na barra de menu
And Clicar no botão de criar novo candidato
And Digitar no campo First Name o nome "Jurandir"
And Digitar no campo Last Name o nome "Marcedo"
And Digitar no campo email o email "jurandir@email.com"
And Clicar no botão de salvar
Then Deve aparecer um toast informando "Successfully Saved"

Scenario: CT-45 Criar novo candidato sem dados
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "Recruitment" na barra de menu
And Clicar no botão de criar novo candidato
And Clicar no botão de salvar
Then Deve aparecer uma mensagem span embaixo de first name escrito "Required"
And Deve aparecer uma mensagem span embaixo de last name escrito "Required"
And Deve aparecer uma mensagem span embaixo de email escrito "Required"

Scenario: CT-46 Criar novo candidato com e-mail formatado incorretamente
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "Recruitment" na barra de menu
And Clicar no botão de criar novo candidato
And Digitar no campo First Name o nome "Jurandir"
And Digitar no campo Last Name o nome "Marcedo"
And Digitar no campo email o email "jurandir#email.com"
And Clicar no botão de salvar
And Deve aparecer uma mensagem span embaixo de email escrito "Expected format: admin@example.com"

Scenario: CT-47 Criar novo candidato e atribui-lo a alguma vaga
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "Recruitment" na barra de menu
And Clicar no botão de criar novo candidato
And Digitar no campo First Name o nome "Jurandir"
And Digitar no campo Last Name o nome "Marcedo"
And Selecionar opcao no campo Vacancy uma opcao qualquer
And Digitar no campo email o email "jurandir@email.com"
And Clicar no botão de salvar
Then Deve aparecer um toast informando "Successfully Saved"


Scenario: CT-48 Apagar candidato
Given Eu estou logado no sistema
And Estou na tela de dashboard
And Tenho um candidato adicionado
When Eu clicar em "Recruitment" na barra de menu
And Clicar no ícone de lixeira de um candidato
And Clicar no botão de confirmar a exclusão
Then Deve aparecer um toast informando "Successfully Deleted"

Scenario: CT-49 Pesquisar por grupo de Titulo de trabalho “QA Lead”
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "Recruitment" na barra de menu
And Selecionar opcao no campo Job Title do filtro a opcao "QA Lead"
And Clicar no botão de search
Then Deve aparecer apenas usuarios do job pesquisado na tabela

Scenario: CT-50 Clicar em ver mais detalhes sobre o candidato
Given Eu estou logado no sistema
And Estou na tela de dashboard
And Tenho um candidato adicionado
When Eu clicar em "Recruitment" na barra de menu
And Clicar no ícone de olho de um candidato
Then Deve aparecer o perfil do candidato