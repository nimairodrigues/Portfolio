#language: pt

Funcionalidade: Transferência
	Como um usuário
	Quero realizar uma transferência
	Para que eu possa eu possa enviar dinheiro para outra conta
	
#	Cenário: Realizar transferência
#		Dado que sou um usuário
#		E que há uma conta criada para receber o valor
#		E que tenho valores disponíveis na minha conta
#		E que tenho uma conta criada
#		E que estou na dashboard de usuário
#		Quando eu clicar em Transferência
#		E digitar um número da conta
#		E digitar um dígito
#		E digitar o valor da tranferência 5
#		E digitar uma descrição
#		E clicar em Transferir agora
#		Então deve aparecer que a transferência foi realizada com sucesso
		
#	Cenário: Tentar transferir valores sem dados
#		Dado que sou um usuário
#		E que estou na dashboard de usuário
#		Quando eu clicar em Transferência
#		E clicar em Transferir agora
#		Então deve informar que o campo número da conta é obrigatório
#		E deve informar que o campo dígito é obrigatório
#		E deve informar que o campo valor da transferência é obrigatório
#		
#	Cenário: Tentar transferir valores sem dados do cartão
#		Dado que sou um usuário
#		E que estou na dashboard de usuário
#		Quando eu clicar em Transferência
#		E digitar um valor da transferência
#		E digitar a descrição "Pagamento"
#		E clicar em Transferir agora
#		Então deve informar que o campo número da conta é obrigatório
#		E deve informar que o campo dígito é obrigatório
		
#	Cenário: Tentar transferir valores sem valor da transferência
#		Dado que sou um usuário
#		E que há uma conta criada para receber o valor
#		E que tenho valores disponíveis na minha conta
#		E que tenho uma conta criada
#		E que estou na dashboard de usuário
#		Quando eu clicar em Transferência
#		E digitar um número da conta
#		E digitar um dígito
#		E digitar a descrição "Pagamento"
#		E clicar em Transferir agora
#		Então deve informar que o campo valor da transferência é obrigatório
		
#	Cenário: Tentar transferir valores sem descrição
#		Dado que sou um usuário
#		E que há uma conta criada para receber o valor
#		E que tenho valores disponíveis na minha conta
#		E que tenho uma conta criada
#		E que estou na dashboard de usuário
#		Quando eu clicar em Transferência
#		E digitar um número da conta
#		E digitar um dígito
#		E digitar o valor da transferência 5
#		E clicar em Transferir agora
#		Então deve aparecer que a transferência foi realizada com sucesso
		
	Cenário: Tentar transferir valores para número da conta contendo letra
		Dado que sou um usuário
		E que há uma conta criada para receber o valor
		E que tenho valores disponíveis na minha conta
		E que tenho uma conta criada
		E que estou na dashboard de usuário
		Quando eu clicar em Transferência
		E digitar o número da conta "N333"
		E digitar um dígito
		E digitar o valor da transferência "5"
		E digitar a descrição "Aluguel"
		E clicar em Transferir agora
		Então deve informar que o campo número da conta está inválido