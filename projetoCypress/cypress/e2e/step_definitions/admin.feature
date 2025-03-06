Feature: admin

Scenario: CT-13 Criar novo usuário
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

Scenario: CT-14 Apagar um usuário
Given Eu estou logado no sistema
And Estou na tela de dashboard
And Tenho um usuário para utilizar
When Eu clicar em "Admin" na barra de menu
And Clicar no ícone de excluir de um usuário qualquer
And Clicar para confirmar a exclusão
Then Deve aparecer um toast informando "Successfully Deleted"

Scenario: CT-15 Editar um usuário
Given Eu estou logado no sistema
And Estou na tela de dashboard
And Tenho um usuário para utilizar
When Eu clicar em "Admin" na barra de menu
And Clicar no ícone de editar de um usuário qualquer
And Digitar no campo Username "usernameEditado"
And Clicar no botão de salvar
Then Deve aparecer um toast informando "Successfully Updated"

Scenario: CT-16 Criar novo usuário com username menor que 5 caracteres
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

Scenario: CT-17 Criar novo usuário com senha menor que 7 caracteres
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

Scenario: CT-18 Criar novo usuário com senha diferente na confirmação
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "Admin" na barra de menu
And Clicar no botão de criar novo usuário
And Selecionar opcao no campo User Role uma opcao qualquer
And Digitar no campo Employee Name "a"
And Selecionar opcao no campo Status uma opcao qualquer
And Digitar no campo Username "userQualquer"
And Digitar no campo Password "senhaNormal"
And Digitar no campo Confirm Password "senhaDiferente"
And Clicar no botão de salvar
Then Deve aparecer uma mensagem span embaixo de confirm password escrito "Passwords do not match"

Scenario: CT-19 Criar novo usuário sem nenhum dado
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "Admin" na barra de menu
And Clicar no botão de criar novo usuário
And Clicar no botão de salvar
Then Deve aparecer uma mensagem span embaixo de user role escrito "Required"
And Deve aparecer uma mensagem span embaixo de employee name escrito "Required"
And Deve aparecer uma mensagem span embaixo de status escrito "Required"
And Deve aparecer uma mensagem span embaixo de username escrito "Required"
And Deve aparecer uma mensagem span embaixo de password escrito "Required"
And Deve aparecer uma mensagem span embaixo de confirm password escrito "Passwords do not match"

Scenario: CT-20 Criar novo usuário faltando preencher apenas o usuário e senha
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "Admin" na barra de menu
And Clicar no botão de criar novo usuário
And Selecionar opcao no campo User Role uma opcao qualquer
And Digitar no campo Employee Name "a"
And Selecionar opcao no campo Status uma opcao qualquer
And Clicar no botão de salvar
Then Deve aparecer uma mensagem span embaixo de username escrito "Required"
And Deve aparecer uma mensagem span embaixo de password escrito "Required"
And Deve aparecer uma mensagem span embaixo de confirm password escrito "Passwords do not match"

Scenario: CT-21 Criar novo usuário faltando preencher apenas a senha
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "Admin" na barra de menu
And Clicar no botão de criar novo usuário
And Selecionar opcao no campo User Role uma opcao qualquer
And Digitar no campo Employee Name "a"
And Selecionar opcao no campo Status uma opcao qualquer
And Digitar no campo Username "username"
And Clicar no botão de salvar
Then Deve aparecer uma mensagem span embaixo de password escrito "Required"
And Deve aparecer uma mensagem span embaixo de confirm password escrito "Passwords do not match"

Scenario: CT-22 Pesquisar por grupo de Administrador
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "Admin" na barra de menu
And Selecionar opcao no campo User Role do filtro opcao administrador
And Clicar no botão de search
Then Deve aparecer apenas usuarios admin na tabela