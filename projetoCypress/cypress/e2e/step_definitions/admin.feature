Feature: admin

Scenario: Criar novo usuário
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "Admin" na barra de menu
And Clicar no botão de criar novo usuário
And Selecionar opcao no campo User Role uma opcao qualquer
And Digitar no campo Employee Name "a"
And Selecionar opcao no campo Status uma opcao qualquer
And Digitar no campo Username "username"
And Digitar no campo Password "senhaQualquer1"
And Digitar no campo Confirm Password "senhaQualquer1"
And Clicar no botão de salvar
Then Deve aparecer um toast informando "Successfully Saved"

Scenario: Apagar um usuário
Given Eu estou logado no sistema
And Estou na tela de dashboard
And Tenho um usuário para utilizar
When Eu clicar em "Admin" na barra de menu
And Clicar no ícone de excluir de um usuário qualquer
And Clicar para confirmar a exclusão
Then Deve aparecer um toast informando "Successfully Deleted"

Scenario: Editar um usuário
Given Eu estou logado no sistema
And Estou na tela de dashboard
And Tenho um usuário para utilizar
When Eu clicar em "Admin" na barra de menu
And Clicar no ícone de editar de um usuário qualquer
And Digitar no campo Username "usernameEditado"
And Clicar no botão de salvar
Then Deve aparecer um toast informando "Successfully Updated"

Scenario: Criar novo usuário com username menor que 5 caracteres
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "Admin" na barra de menu
And Clicar no botão de criar novo usuário
And Selecionar opcao no campo User Role uma opcao qualquer
And Digitar no campo Employee Name "a"
And Selecionar opcao no campo Status uma opcao qualquer
And Digitar no campo Username "a"
And Digitar no campo Password "senhaQualquer1"
And Digitar no campo Confirm Password "senhaQualquer1"
And Clicar no botão de salvar
Then Deve aparecer uma mensagem span embaixo de username escrito "Should be at least 5 characters"
@focus 
Scenario: Criar novo usuário com senha menor que 7 caracteres
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "Admin" na barra de menu
And Clicar no botão de criar novo usuário
And Selecionar opcao no campo User Role uma opcao qualquer
And Digitar no campo Employee Name "a"
And Selecionar opcao no campo Status uma opcao qualquer
And Digitar no campo Username "userQualquer"
And Digitar no campo Password "senha"
And Digitar no campo Confirm Password "senha"
And Clicar no botão de salvar
Then Deve aparecer uma mensagem span embaixo de password escrito "Should have at least 7 characters"