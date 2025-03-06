Feature: Pim

Scenario: CT-23 Criar novo empregado com sucesso
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "PIM" na barra de menu
And Clicar no botão de criar novo empregado
And Digitar no campo First Name "Juscelino"
And Digitar no campo Last Name "Kubitschek"
And Clicar no botão de save
And Deve aparecer um toast informando "Successfully Saved"

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
