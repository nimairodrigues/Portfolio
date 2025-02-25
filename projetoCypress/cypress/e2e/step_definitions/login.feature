Feature: login

Scenario: CT-001 Login com usuário e senha correta
Given Estou na tela de login
And Tenho uma conta válida
When Eu digito o usuário "Admin"
And Eu digito a senha "admin123"
And Clico no botão de login
Then Eu visualizo a dashboard de usuário

Scenario: CT-002 Login com usuário incorreto e senha incorreta
Given Estou na tela de login
And Tenho uma conta válida
When Eu digito o usuário "inexistente"
And Eu digito a senha "senhaerrada"
And Clico no botão de login
Then Deve aparecer mensagem de Invalid Credentials

Scenario: CT-003 Login com usuário incorreto e senha correta
Given Estou na tela de login
And Tenho uma conta válida
When Eu digito o usuário "incorreto"
And Eu digito a senha "admin123"
And Clico no botão de login
Then Deve aparecer mensagem de Invalid Credentials

Scenario: CT-004 Login com usuário correto e senha incorreta
Given Estou na tela de login
And Tenho uma conta válida
When Eu digito o usuário "Admin"
And Eu digito a senha "senhaincorreta"
And Clico no botão de login
Then Deve aparecer mensagem de Invalid Credentials

Scenario: CT-005 Login sem usuário e sem senha
Given Estou na tela de login
And Tenho uma conta válida
When Eu digito o usuário "{CTRL}"
And Eu digito a senha "{CTRL}"
And Clico no botão de login
Then Deve aparecer required abaixo de username
And Deve aparecer required abaixo de password

Scenario: CT-006 Login sem usuário e com senha qualquer preenchida
Given Estou na tela de login
And Tenho uma conta válida
When Eu digito o usuário "{CTRL}"
And Eu digito a senha "senhaqualquer"
And Clico no botão de login
Then Deve aparecer required abaixo de username

Scenario: CT-007 Login com usuário correto preenchido e sem senha
Given Estou na tela de login
And Tenho uma conta válida
When Eu digito o usuário "Admin"
And Eu digito a senha "{CTRL}"
And Clico no botão de login
Then Deve aparecer required abaixo de password

Scenario: CT-008 Esqueceu a senha
Given Estou na tela de login
When Eu clico em forgot your password
Then Deve aparecer a tela de esqueceu a senha

Scenario: CT-009 Cancelar resetar senha
Given Estou na tela de login
When Eu clico em forgot your password
And Eu clico no botão de Cancelar
Then Deve aparecer a tela de login

Scenario: CT-010 Resetar senha de usuário válido
Given Estou na tela de login
When Eu clico em forgot your password
And Eu digito no campo de username "Admin"
And Eu clico no botão reset password
Then Deve aparecer mensagem confirmando o envio do link no email

Scenario: CT-011 Resetar senha com usuário não preenchido
Given Estou na tela de login
When Eu clico em forgot your password
And Eu digito no campo de username "{CTRL}"
And Eu clico no botão reset password
Then Deve aparecer required abaixo de username em forgot password

Scenario: CT-012 Resetar senha de usuário inválido
Given Estou na tela de login
When Eu clico em forgot your password
And Eu digito no campo de username "usuarioInvalido"
And Eu clico no botão reset password
Then Deve aparecer mensagem confirmando o envio do link no email