#language: pt

@cadastro
Funcionalidade: Cadastro
	Como um visitante
	Quero cadastrar uma conta no sistema
	Para que eu possa ter acesso as funcionalidades do banco
	
	Cenário: Realizar cadastro
		Dado que sou um visitante
		E que estou na tela de login
		Quando eu clicar em Registrar
		E digitar o e-mail "nimaiqa@test.com" na tela de cadastro
		E digitar o nome "Nimai"
		E digitar a senha "nimai123" na tela de cadastro
		E digitar a senha novamente "nimai123" na tela de cadastro
		E clicar em Cadastrar
		Então deve aparecer que a conta foi criada com sucesso
		
#	Cenário: Tentar cadastrar conta sem dados
#		Dado que sou um visitante
#		E que estou na tela de login
#		Quando eu clicar em Registrar
#		E clicar em Cadastrar
#		Então deve informar que o campo e-mail é obrigatório na tela de cadastro
#		E deve informar que o campo nome é obrigatório
#		E deve informar que o campo senha é obrigatório na tela de cadastro
#		E deve informar que o campo confirmação de senha é obrigatório

#	Cenário: Tentar cadastrar conta com e-mail fora dos padrões
#		Dado que sou um visitante
#		E que estou na tela de login
#		Quando eu clicar em Registrar
#		E digitar o e-mail "nimaiqa.com"
#		E digitar o nome "Nimai"
#		E digitar a senha "nimai123" na tela de cadastro
#		E digitar a senha novamente "nimai123" na tela de cadastro
#		E clicar em Cadastrar
#		Então deve informar que o formato do e-mail está inválido na tela de cadastro

#	Cenário: Tentar criar conta sem e-mail
#		Dado que sou um visitante
#		E que estou na tela de login
#		Quando eu clicar em Registrar
#		E digitar o nome "Nimai"
#		E digitar a senha "nimai123" na tela de cadastro
#		E digitar a senha novamente "nimai123" na tela de cadastro
#		E clicar em Cadastrar
#		Então deve informar que o campo e-mail é obrigatório na tela de cadastro

#	Cenário: Tentar criar conta sem nome
#		Dado que sou um visitante
#		E que estou na tela de login
#		Quando eu clicar em Registrar
#		E digitar o e-mail "nimaiqa@test.com" na tela de cadastro
#		E digitar a senha "nimai123" na tela de cadastro
#		E digitar a senha novamente "nimai123" na tela de cadastro
#		E clicar em Cadastrar
#		Então deve informar que o campo nome é obrigatório

#	Cenário: Tentar criar conta sem senha
#		Dado que sou um visitante
#		E que estou na tela de login
#		Quando eu clicar em Registrar
#		E digitar o e-mail "nimaiqa@test.com" na tela de cadastro
#		E digitar o nome "Nimai"
#		E clicar em Cadastrar
#		Então deve informar que o campo senha é obrigatório na tela de cadastro
#		E deve informar que o campo confirmar senha é obrigatório na tela de cadastro


