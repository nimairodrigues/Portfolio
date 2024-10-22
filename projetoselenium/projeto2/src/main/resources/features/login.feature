#language: pt

@login
Funcionalidade: Login
  Como um usuário
	Quero logar no sistema
	Para que eu possa ter acesso a minha conta do banco


  Cenário: Realizar login
    Dado que sou um usuário
		E que tenho uma conta criada
		E que estou na tela de login
		Quando eu digitar o e-mail "nimaiqa@test.com"
		E digitar a senha "nimai123"
		E clicar em Acessar
		Então deve aparecer a dashboard do usuário
		
	Cenário: Tentar logar com senha inválida
		Dado que sou um usuário
		E que tenho uma conta criada
		E que estou na tela de login
		Quando eu digitar o e-mail "nimaiqa@test.com"
		E digitar a senha "senhaerrada"
		E clicar em Acessar
		Então deve aparecer uma tela informando que o usuário ou senha estão inválidos.
		
	Cenário: Tentar logar com e-mail inválido
		Dado que sou um usuário
		E que estou na tela de login
		Quando eu digitar o e-mail "emailinexistente@test.com"
		E digitar a senha "senhaQualquer"
		E clicar em Acessar
		Então deve aparecer uma tela informando que o usuário ou senha estão inválidos.
		
	Cenário: Tentar logar sem dados
		Dado que sou um usuário	
		E que estou na tela de login
		Quando eu clicar em Acessar
		Então deve informar que o campo e-mail é obrigatório
		E deve informar que o campo senha é obrigatório
		
	Cenário: Tentar logar sem senha
		Dado que sou um usuário
		E que tenho uma conta criada
		E que estou na tela de login
		Quando eu digitar o e-mail "nimaiqa@test.com"
		E clicar em Acessar
		Então deve informar que o campo senha é obrigatório
		
	Cenário: Tentar logar com e-mail fora dos padrões
		Dado que sou um usuário
		E que tenho uma conta criada
		E que estou na tela de login
		Quando eu digitar o e-mail "nimaiqatest.com"
		Então deve informar que o formato do e-mail está inválido
		
