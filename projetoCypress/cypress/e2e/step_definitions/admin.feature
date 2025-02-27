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
@focus
Scenario: Apagar um usuário
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "Admin" na barra de menu
And Clicar no ícone de excluir de um usuário qualquer
# And Clicar para confirmar a exclusão
# Then Deve aparecer um toast informando "Successfully Deleted"