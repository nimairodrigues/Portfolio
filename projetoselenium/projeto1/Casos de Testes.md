# Casos de Testes

# ID 01
Funcionalidade: Login
Título: Login com usuário e senha correta
Pré-condições: Usuário e senha devem ser válidos
Passo a passo para execução:
    1- Acessar site do rh: opensource-demo.orangehrmlive.com
    2- Colocar usuario correto
    3- Colocar senha correta
    4- Clicar em logar
Resultado: Deve visualizar a home do usuário (dashboard do usuário)
Status: OK
Observação:

# ID 02
Funcionalidade: Login
Título: Login com usuário incorreto e senha incorreta
Pré-condições: Usuário e senha devem ser inválidos
Passo a passo para execução:
    1- Estando na home do site: opensource-demo.orangehrmlive.com
    2- Colocar usuario correto incorreto
    3- Colocar senha incorreta
    4- Clicar em logar
Resultado: Deve aparecer “credenciais inválidas” no topo da caixa de login
Status: OK
Observação:

# ID 03
Funcionalidade: Login
Título: Login com usuário incorreto e senha correta
Pré-condições: Usuário deve ser inválida Senha deve ser válida
Passo a passo para execução:
    1- Estando na home do site: opensource-demo.orangehrmlive.com
    2- Colocar usuario correto incorreto
    3- Colocar senha correta
    4- Clicar em logar
Resultado: Deve aparecer “credenciais inválidas” no topo da caixa de login
Status: OK
Observação:

# ID 04
Funcionalidade: Login
Título: Login com usuário correto e senha incorreta
Pré-condições: Usuário deve ser válido
Passo a passo para execução:
    1- Estando na home do site: opensource-demo.orangehrmlive.com
    2- Colocar usuario correto
    3- Colocar senha incorreta
    4- Clicar em logar
Resultado: Deve aparecer “credenciais inválidas” no topo da caixa de login
Status: OK
Observação:

# ID 05
Funcionalidade: Login
Título: Login sem usuário e sem senha
Pré-condições:
Passo a passo para execução:
    1- Estando na home do site: opensource-demo.orangehrmlive.com
    2- Clicar em logar
Resultado: Deve aparecer “Obrigatório” embaixo do campo de usuário e de senha e ambos os campos devem estar destacados em vermelho.
Status: OK
Observação:

# ID 06
Funcionalidade: Login
Título: Login sem usuário e com senha qualquer preenchida
Pré-condições:
Passo a passo para execução:
    1- Estando na home do site: opensource-demo.orangehrmlive.com
    2- Colocar senha correta
    3- Clicar em logar
    4- Deve aparecer que é necessário digitar usuário
Resultado: Deve aparecer “Obrigatório” em baixo do campo de usuário e deve estar destacado em vermelho.
Status: OK
Observação:

# ID 07
Funcionalidade: Login
Título: Login com usuário correto preenchido e sem senha
Pré-condições:
Passo a passo para execução:
    1- Estando na home do site: opensource-demo.orangehrmlive.com
    2- Quando colocar usuario correto
    3- Quando clicar em logar
Resultado: Deve aparecer “Obrigatório” em baixo do campo de senha e deve estar destacado em vermelho.
Status: OK
Observação:

# ID 08
Funcionalidade: Login
Título: Esqueceu a senha
Pré-condições:
Passo a passo para execução:
    1- Estando na home do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Forgot your password?”
Resultado: Deve aparecer a tela de esquecer a senha assim como o campo para digitar o usuário que deseja resetar a senha
Status: OK
Observação:

# ID 09
Funcionalidade: Login
Título: Cancelar resetar senha
Pré-condições:
Passo a passo para execução:
    1- Estando na home do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Forgot your password?”
    3- Clicar em voltar
Resultado: Deve voltar para a tela de login
Status: OK
Observação:

# ID 10
Funcionalidade: Login
Título: Resetar senha de usuário válido
Pré-condições:
Passo a passo para execução:
    1- Estando na home do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Forgot your password?”
    3- Digitar Usuário válido
Resultado: Deve enviar para o e-mail cadastrado no usuário um link para resetar a senha
Status: OK
Observação:

# ID 11
Funcionalidade: Login
Título: Resetar senha com usuário não preenchido
Pré-condições:
Passo a passo para execução:
    1- Estando na home do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Forgot your password?”
    3- Clicar em Resetar Senha
Resultado: Deve aparecer em baixo do campo de Usuário “Required” em vermelho
Status: OK
Observação:

# ID 12
Funcionalidade: Login
Título: Resetar senha de usuário inválido
Pré-condições:
Passo a passo para execução:
    1- Estando na home do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Forgot your password?”
    3- Digitar Usuário válido
Resultado: Deve aparecer que vai enviar para o e-mail cadastrado no usuário um link para resetar a senha, mesmo que o usuário não exista, para fins de segurança
Status: OK
Observação:


# ID 13
Funcionalidade: Admin
Título: Criar novo usuário
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Admin” no menu do site
    3- Clicar no botão de Criar novo usuário
    4- Preencher campo User Role
    5- Preencher campo Employee Name
    6- Preencher campo Status
    7- Preencher campo Username
    8- Preencher campo password
    9- Preencher campo Confirm Password
    10- Clicar em Salvar
Resultado: Deve aparecer um pop up com título “Success” escrito “Successfully saved”
Status: OK
Observação: 

# ID 14
Funcionalidade: Admin
Título: Apagar um usuário
Pré-condições: Deve conter um usuário cadastrado no sistema
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Admin” no menu do site
    3- Clicar no botão de apagar do respectivo usuário
    4- Confirmar para apagar o usuário
Resultado: Deve aparecer um pop up com título “Success” escrito “Successfully Deleted”
Status: OK
Observação: 

# ID 15
Funcionalidade: Admin
Título: Editar um usuário
Pré-condições: Deve conter um usuário cadastrado no sistema
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Admin” no menu do site
    3- Clicar no botão de editar do respectivo usuário
    4- Alterar username
    5- Clicar em Salvar
Resultado: Deve aparecer um pop up com título “Success” escrito “Successfully Updated”
Status: OK
Observação: 

# ID 16
Funcionalidade: Admin
Título: Criar novo usuário com username menor que 5 caracteres
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Admin” no menu do site
    3- Clicar no botão de Criar novo usuário
    4- Preencher campo User Role
    5- Preencher campo Employee Name
    6- Preencher campo Status
    7- Preencher campo Username com “test”
    8- Preencher campo Password
    9- Preencher campo Confirm Password
    10- Clicar em Salvar
Resultado: Deve aparecer em baixo do campo de username “Should be at least 5 characters” em vermelho
Status: OK
Observação: 

# ID 17
Funcionalidade: Admin
Título: Criar novo usuário com senha menor que 7 caracteres
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Admin” no menu do site
    3- Clicar no botão de Criar novo usuário
    4- Preencher campo User Role
    5- Preencher campo Employee Name
    6- Preencher campo Status
    7- Preencher campo Username
    8- Preencher campo Password com “123456”
    9- Preencher campo Confirm Password com “123456”
    10- Clicar em Salvar
Resultado: Deve aparecer em baixo do campo de senha “Should have at least 7 characters” em vermelho
Status: OK
Observação: 

# ID 18
Funcionalidade: Admin
Título: Criar novo usuário com senha diferente na confirmação
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Admin” no menu do site
    3- Clicar no botão de Criar novo usuário
    4- Preencher campo User Role
    5- Preencher campo Employee Name
    6- Preencher campo Status
    7- Preencher campo Username
    8- Preencher campo Password com “123456”
    9- Preencher campo Confirm Password com “234567”
    10- Clicar em Salvar
Resultado: Deve aparecer em baixo do campo de usuário “Passwords do not match” em vermelho
Status: OK
Observação: 

# ID 19
Funcionalidade: Admin
Título: Criar novo usuário sem nenhum dado
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Admin” no menu do site
    3- Clicar no botão de Criar novo usuário
    4- Clicar em Salvar
Resultado: Deve aparecer em baixo dos campos obrigatórios “Required” em vermelho
Status: OK
Observação: 

# ID 20
Funcionalidade: Admin
Título: Criar novo usuário faltando preencher apenas o usuário e senha
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Admin” no menu do site
    3- Clicar no botão de Criar novo usuário
    4- Preencher campo User Role
    5- Preencher campo Employee Name
    6- Preencher campo Status
    7- Clicar em Salvar
Resultado: Deve aparecer em baixo dos campos de username, password e Confirm Password “Required” em vermelho
Status: OK
Observação: 

# ID 21
Funcionalidade: Admin
Título: Criar novo usuário faltando preencher apenas a senha
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Admin” no menu do site
    3- Clicar no botão de Criar novo usuário
    4- Preencher campo User Role
    5- Preencher campo Employee Name
    6- Preencher campo Status
    7- Preencher campo Username
    8- Clicar em Salvar
Resultado: Deve aparecer em baixo do campo de Password “Required” em vermelho
Status: OK
Observação: 

# ID 22
Funcionalidade: Admin
Título: Pesquisar por grupo de Administrador
Pré-condições: Deve conter um usuário cadastrado no sistema
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Admin” no menu do site
    3- Clicar no botão de User Role
    4- Selecionar Admin
    5- Clicar em Search
Resultado: Deve aparecer como resultado apenas usuários da role Admin
Status: OK
Observação: 

# ID 23
Funcionalidade: PIM
Título: Criar novo empregado com sucesso
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “PIM” no menu do site
    3- Clicar no botão de Criar Novo Empregado
    4- Digitar o primeiro nome “Silvaney”
    5- Digitar o ultimo nome “Junior”
    6- Clicar em Salvar
Resultado: Deve aparecer um pop up com título “Success” escrito “Successfully saved”
Status: OK
Observação: 

# ID 24
Funcionalidade: PIM
Título: Criar novo empregado sem dados
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “PIM” no menu do site
    3- Clicar no botão de Criar Novo Empregado
    4- Clicar em Salvar
Resultado: Deve aparecer em baixo dos campos de First Name e Last Name “Required” em vermelho
Status: OK
Observação: 

# ID 25
Funcionalidade: PIM
Título: Criar novo empregado com ID contendo 10 digitos
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “PIM” no menu do site
    3- Clicar no botão de Criar Novo Empregado
    4- Digitar o primeiro nome “Silvaney”
    5- Digitar o ultimo nome “Junior”
    6- Digitar o Employee ID “1234567890”
    6- Clicar em Salvar
Resultado: Deve aparecer em baixo do campo de Employee ID “Should not exceed 10 characters” em vermelho
Status: OK
Observação: 

# ID 26
Funcionalidade: PIM
Título: Criar novo empregado com ID “000”
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “PIM” no menu do site
    3- Clicar no botão de Criar Novo Empregado
    4- Digitar o primeiro nome “Silvaney”
    5- Digitar o ultimo nome “Junior”
    6- Digitar o Employee ID “000”
    6- Clicar em Salvar
Resultado: Deve aparecer em baixo do campo de Employee ID “ID should not be less than 1” em vermelho
Status: NOK
Observação: 

# ID 27
Funcionalidade: PIM
Título: Criar novo empregado com ID negativo
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “PIM” no menu do site
    3- Clicar no botão de Criar Novo Empregado
    4- Digitar o primeiro nome “Silvaney”
    5- Digitar o ultimo nome “Junior”
    6- Digitar o Employee ID “-100”
    6- Clicar em Salvar
Resultado: Deve aparecer em baixo do campo de Employee ID “ID should not be less than 1” em vermelho
Status: NOK
Observação: 

# ID 28
Funcionalidade: PIM
Título: Criar novo empregado sem ID
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “PIM” no menu do site
    3- Clicar no botão de Criar Novo Empregado
    4- Digitar o primeiro nome “Silvaney”
    5- Digitar o ultimo nome “Junior”
    6- Deixar campo Employee ID vazio
    6- Clicar em Salvar
Resultado: Deve aparecer em baixo do campo de Employee ID “Required” em vermelho
Status: NOK
Observação: 

# ID 29
Funcionalidade: PIM
Título: Criar novo empregado com novo login com sucesso
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “PIM” no menu do site
    3- Clicar no botão de Criar Novo Empregado
    4- Digitar o primeiro nome “Thanara”
    5- Digitar o ultimo nome “Silva”
    6- Clicar em Create Login Details
    7- Digitar username o mesmo que o ID
    8- Digitar password “123456a”
    9- Digitar Confirm Password “123456a”
    10- Clicar em Salvar
Resultado: Deve aparecer um pop up com título “Success” escrito “Successfully saved”
Status: 
Observação: 

# ID 30
Funcionalidade: PIM
Título: Criar novo empregado com novo login mas sem usuário e senha preenchidos
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “PIM” no menu do site
    3- Clicar no botão de Criar Novo Empregado
    4- Digitar o primeiro nome “Thanara”
    5- Digitar o ultimo nome “Silva”
    6- Clicar em Create Login Details
    7- Clicar em Salvar
Resultado: Deve aparecer em baixo do campo de Username, Password e Confirm Password “Required” em vermelho
Status: 
Observação: 

# ID 31
Funcionalidade: PIM
Título: Clicar no suporte de adicionar novo empregado
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “PIM” no menu do site
    3- Clicar no botão de Criar novo Empregado
Resultado: Deve abrir site ensinando a como adicionar novo empregado
Status: 
Observação: 

# ID 32
Funcionalidade: PIM
Título: Fazer pesquisa de nome de usuário na lista de empregados
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “PIM” no menu do site
    3- Clicar em Search
Resultado: Deve aparecer como resultado alguns usuários
Status: OK
Observação: 

# ID 33
Funcionalidade: Buzz
Título: Fazer um post 
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Buzz” no menu do site
    3- Digitar “Sou bonito” no campo do post
    4- Clicar em Post
Resultado: Deve aparecer um pop up com título “Success” escrito “Successfully Saved”
Status: OK
Observação: 

# ID 34
Funcionalidade: Buzz
Título: Apagar um post
Pré-condições: Deve existir um Post
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Buzz” no menu do site
    3- Clicar nos 3 pontos do post escolhido
    4- Clicar em Delete Post
    5- Confirmar Deletar Post
Resultado: Deve aparecer um pop up com título “Success” escrito “Successfully Deleted”
Status: OK
Observação: 

# ID 35
Funcionalidade: Buzz
Título: Alterar um post
Pré-condições: Deve existir um Post
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Buzz” no menu do site
    3- Clicar nos 3 pontos do post escolhido
    4- Clicar em Edit Post
    5- Alterar o texto para “Sou lindo alterado”
    6- Clicar em Post
Resultado: Deve aparecer um pop up com título “Success” escrito “Successfully Updated”
Status: OK
Observação: 

# ID 36
Funcionalidade: Buzz
Título: Fazer um post contendo mais de 65530 caracteres
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Buzz” no menu do site
    3- Digitar qualquer texto maior que 65530 caracteres no campo do post
    4- Clicar em Post
Resultado: Deve aparecer em baixo do campo de post “Should not exceed 65530 characters” em vermelho
Status: NOK
Observação: Incapaz de ser feito, alto tempo de resposta para escrever muitos caracteres no campo

# ID 37
Funcionalidade: Buzz
Título: Dar like em algum post
Pré-condições: Deve existir um Post
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Buzz” no menu do site
    3- Clicar no coração de like de algum post
Resultado: Deve fazer a contagem de like atual acrescentando 1
Status: OK
Observação: feita através de um mesmo método (darLikeEmAlgunPost())

# ID 38
Funcionalidade: Buzz
Título: Tirar o like de algum post
Pré-condições: Deve existir um Post e deve estar curtido pelo próprio usuário
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Buzz” no menu do site
    3- Clicar no coração de like de algum post
Resultado: Deve fazer a contagem de like atual subtraindo 1
Status: OK
Observação: feita através de um mesmo método (darLikeEmAlgunPost())

# ID 39
Funcionalidade: Buzz
Título: Compartilhar um post
Pré-condições: Deve existir um Post
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Buzz” no menu do site
    3- Clicar no botão de Compartilhar do post
    4- Clicar no botão Share
Resultado: Deve aparecer um pop up com título “Success” escrito “Successfully Saved”
Status: OK
Observação: 

# ID 40
Funcionalidade: Buzz
Título: Comentar um post
Pré-condições: Deve existir um Post
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Buzz” no menu do site
    3- Clicar no botão de Comentar do post
    4- Digitar “Testando comentário” no campo
    5- Clicar no botão de enviar comentário
Resultado: Deve aparecer um pop up com título “Success” escrito “Successfully Saved”
Status: OK
Observação: 

# ID 41
Funcionalidade: Buzz
Título: Curtir um comentário um post
Pré-condições: Deve existir um Post e um comentário neste mesmo post
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Buzz” no menu do site
    3- Clicar em curtir do comentário de algum post
Resultado: Deve fazer a contagem de like atual acrescentando 1
Status: OK
Observação: 

# ID 42
Funcionalidade: Buzz
Título: Editar o próprio comentário de um post
Pré-condições: Deve existir um Post e um comentário neste mesmo post do próprio usuário
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Buzz” no menu do site
    3- Clicar em Edit do comentário do próprio usuário
    4- Acrescentar “Alterado” ao texto atual
Resultado: Deve aparecer um pop up com título “Success” escrito “Successfully Updated”
Status: OK
Observação: 

# ID 43
Funcionalidade: Buzz
Título: Deletar o próprio comentário de um post
Pré-condições: Deve existir um Post e um comentário neste mesmo post do próprio usuário
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Buzz” no menu do site
    3- Clicar em Delete do comentário do próprio usuário
Resultado: Deve aparecer um pop up com título “Success” escrito “Successfully Deleted”
Status: OK
Observação: 

# ID 44
Funcionalidade: Recruitment
Título: Criar novo candidato
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Recruitment” no menu do site
    3- Clicar em botão de Adicionar novo candidato
    4- Preencher First Name “Joselito”
    5- Preencher Last Name “Silveira”
    6- Preencher e-mail “joselitosilveira@diferente.com”
    7- Clicar em Salvar
Resultado: Deve aparecer um pop up com título “Success” escrito “Successfully Saved”
Status: OK
Observação: 

# ID 45
Funcionalidade: Recruitment
Título: Criar novo candidato sem dados
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Recruitment” no menu do site
    3- Clicar em botão de Adicionar novo candidato 
    4- Clicar em Salvar
Resultado: Deve aparecer em baixo do campo de First Name, Last Name e Email “Required” em vermelho
Status: OK
Observação: 

# ID 46
Funcionalidade: Recruitment
Título: Criar novo candidato com e-mail formatado incorretamente
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Recruitment” no menu do site
    3- Clicar em botão de Adicionar novo candidato
    4- Preencher First Name “Joselito” 
    5- Preencher Last Name “Silveira” 
    6- Preencher e-mail “joselitosilveira#diferente.com” 
    7- Clicar em Salvar
Resultado: Deve aparecer em baixo do campo de Email “Expected format: admin@example.com” em vermelho
Status: OK
Observação: 

# ID 47
Funcionalidade: Recruitment
Título: Criar novo candidato e atribui-lo a alguma vaga
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Recruitment” no menu do site
    3- Clicar em botão de Adicionar novo candidato
    4- Preencher First Name “Joselito”
    5- Preencher Last Name “Silveira”
    6- Clicar no box Vacancy
    7- Clicar opção “Senior QA Lead”
    8- Preencher e-mail “joselitosilveira@diferente.com”
    9- Clicar em Salvar
Resultado: Deve aparecer um pop up com título “Success” escrito “Successfully Saved”
Status: OK
Observação: 

# ID 48
Funcionalidade: Recruitment
Título: Apagar um candidato
Pré-condições: Deve ter cadastrado no sistema algum candidato
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Recruitment” no menu do site
    3- Clicar no botão de Apagar do respectivo candidato
    4- Clicar no botão de confirmar
Resultado: Deve aparecer um pop up com título “Success” escrito “Successfully Deleted”
Status: OK
Observação: 

# ID 49
Funcionalidade: Recruitment
Título: Pesquisar por grupo de Titulo de trabalho “QA Lead”
Pré-condições: Deve ter cadastrado no sistema algum candidato a vaga de “Senior QA Lead”
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Recruitment” no menu do site
    3- Clicar em Job Title
    4- Clicar opção “QA Lead”
    5- Clicar em Search
Resultado: Deve aparecer como resultado apenas candidatos a vaga de “Senior QA Lead”
Status: OK
Observação: 

# ID 50
Funcionalidade: Recruitment
Título: Clicar em ver mais detalhes sobre o candidato
Pré-condições: 
Passo a passo para execução:
    1- Estando na dashboard do usuário do site: opensource-demo.orangehrmlive.com
    2- Clicar em “Recruitment” no menu do site
    3- Clicar na opção de Ver Mais sobre o respectivo candidato
Resultado: Deve aparecer a tela com mais informações sobre o candidato
Status: OK
Observação: 

