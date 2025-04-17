Feature: Pim

Scenario: CT-23 Criar novo empregado com sucesso
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "PIM" na barra de menu
And Clicar no botão de criar novo empregado
And Digitar no campo First Name "Juscelino"
And Digitar no campo Last Name "Kubitschek"
And Clicar no botão de save
Then Deve aparecer um toast informando "Successfully Saved"

Scenario: CT-24 Criar novo empregado sem dados
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "PIM" na barra de menu
And Clicar no botão de criar novo empregado
And Clicar no botão de save
Then Deve aparecer uma mensagem span embaixo de first name escrito "Required"
And Deve aparecer uma mensagem span embaixo de last name escrito "Required"

Scenario: CT-25 Criar novo empregado com ID contendo 10 digitos
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "PIM" na barra de menu
And Clicar no botão de criar novo empregado
And Digitar no campo First Name "Juscelino"
And Digitar no campo Last Name "Kubitschek"
And Digitar no campo Employee Id "12345678901"
And Clicar no botão de save
Then Deve aparecer uma mensagem span embaixo de employee id escrito "Should not exceed 10 characters"

Scenario: CT-26 Criar novo empregado com ID 000 [deve dar erro]
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "PIM" na barra de menu
And Clicar no botão de criar novo empregado
And Digitar no campo First Name "Juscelino"
And Digitar no campo Last Name "Kubitschek"
And Digitar no campo Employee Id "000"
And Clicar no botão de save
Then Deve aparecer uma mensagem span embaixo de employee id escrito "Should not be less than 1"

Scenario: CT-27 Criar novo empregado com ID negativo [deve dar erro]
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "PIM" na barra de menu
And Clicar no botão de criar novo empregado
And Digitar no campo First Name "Juscelino"
And Digitar no campo Last Name "Kubitschek"
And Digitar no campo Employee Id "-2"
And Clicar no botão de save
Then Deve aparecer uma mensagem span embaixo de employee id escrito "Should not be less than 1"

Scenario: CT-28 Criar novo empregado com ID 000 [deve dar erro]
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "PIM" na barra de menu
And Clicar no botão de criar novo empregado
And Digitar no campo First Name "Juscelino"
And Digitar no campo Last Name "Kubitschek"
And Digitar no campo Employee Id "{CTRL}"
And Clicar no botão de save
Then Deve aparecer uma mensagem span embaixo de employee id escrito "Should not be less than 1"

Scenario: CT-29 Criar novo empregado com novo login com sucesso
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "PIM" na barra de menu
And Clicar no botão de criar novo empregado
And Digitar no campo First Name "Juscelino"
And Digitar no campo Last Name "Kubitschek"
And Clicar no switch de create login details
And Digitar no campo username "juscelino"
And Digitar no campo password "senhaQualquer1"
And Digitar no campo confirm password "senhaQualquer1"
And Clicar no botão de save
Then Deve aparecer um toast informando "Successfully Saved"

Scenario: CT-30 Criar novo empregado com novo login mas sem usuário e senha preenchidos
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "PIM" na barra de menu
And Clicar no botão de criar novo empregado
And Digitar no campo First Name "Juscelino"
And Digitar no campo Last Name "Kubitschek"
And Clicar no switch de create login details
And Clicar no botão de save
Then Deve aparecer uma mensagem span embaixo de username escrito "Required"
And Deve aparecer uma mensagem span embaixo de password escrito "Required"
And Deve aparecer uma mensagem span embaixo de confirm password escrito "Passwords do not match"

Scenario: CT-31 Clicar no suporte de adicionar novo empregado
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "PIM" na barra de menu
And Clicar no botão de criar novo empregado
And Clicar no botão de help


Scenario: CT-32 Fazer pesquisa de nome de usuário na lista de empregados
Given Eu estou logado no sistema
And Estou na tela de dashboard
And Tenho um usuario criado para utilizar
When Eu clicar em "PIM" na barra de menu
And Digitar no campo de employee name de filtro
And Clicar no botão de pesquisar 
Then Deve aparecer alguns usuarios no resultado da pesquisa