# Casos de Testes

# ID 01
Funcionalidade: Login.

Título: Login com sucesso.

Pré-condições: Usuário e senha devem ser válidos.

Passo a passo para execução:

    1- Acessar a aplicação Instagram.
    2- Digitar usuario correto.
    3- Colocar senha correta.
    4- Clicar botão "Log in".
    
Resultado esperado: Deve visualizar a Timeline da conta.

Status: OK.

Observação: 

# ID 02
Funcionalidade: Login.

Título: Login com usuário válido e senha incorreta.

Pré-condições: Usuário deve ser válido.

Passo a passo para execução:

    1- Acessar aplicação.
    2- Digitar usuário.
    3- Digitar senha.
    4- Clicar botão "Log in".
    
Resultado esperado: Deve mostrar um Alert com título "Incorrect Password" e mensagem "The password you entered is incorrect. Please try again." e um botão de "Ok".

Status: OK.

Observação:

# ID 03
Funcionalidade: Login.

Título: Tentar login apenas com usuário preenchido.

Pré-condições: 

Passo a passo para execução:

    1- Acessar aplicação.
    2- Digitar usuário.
    3- Digitar senha.
    4- Clicar botão "Log in".
    
Resultado esperado: Deve mostrar um Alert com título "Enter your password to log in"

Status: OK.

Observação:

# ID 04
Funcionalidade: Login.

Título: Tentar logar sem preencher usuário e senha.

Pré-condições: 

Passo a passo para execução:

    1- Acessar aplicação.
    2- Digitar usuário.
    3- Digitar senha.
    4- Clicar botão "Log in".
    
Resultado esperado: Deve mostrar um Alert com título "Enter your username, e-mail or mobile number to log in".

Status: OK.

Observação:

# ID 05
Funcionalidade: Login.

Título: Login com usuário inválido  e senha qualquer.

Pré-condições: 

Passo a passo para execução:

    1- Acessar aplicação.
    2- Digitar usuário.
    3- Digitar senha.
    4- Clicar botão "Log in".
    
Resultado esperado: Deve mostrar um Alert com título "Can't find account".

Status: OK.

Observação:

# ID 06
Funcionalidade: Login.

Título: Clicar checkbox "Salvar credenciais".

Pré-condições: 

Passo a passo para execução:

    1- Acessar aplicação.
    2- Clicar checkbox "Salvar credenciais".
    
Resultado esperado: Deve marcar o checkbox "Salvar credenciais".

Status: NOK.

Observação: Botão não aparece ao abrir a aplicação.

# ID 07
Funcionalidade: Explorar.

Título: Pesquisar "Mark" e abrir o perfil.

Pré-condições: Conta deve estar criada.

Passo a passo para execução:

    1- Acessar aplicação.
    2- Realizar Login.
    3- Clicar na Lupa (Botão explorar).
    4- Deve digitar na barra Search "Mark".
    5- Deve clicar no perfil do "Mark".
    
Resultado esperado: Deve visualizar o perfil do Mark Zuckerberg.

Status: OK.

Observação:

# ID 08
Funcionalidade: Explorar.

Título: Dar like em algum post do explorar.

Pré-condições: Conta deve estar criada.

Passo a passo para execução:

    1- Acessar aplicação.
    2- Realizar Login.
    3- Clicar na Lupa (Botão explorar).
    4- Deve clicar em alguma foto.
    5- Deve clicar no coração de Like.
    
Resultado esperado: Deve preencher o botão de Like em vermelho.

Status: OK.

Observação:

# ID 09
Funcionalidade: Explorar.

Título: Comentar em algum post do explorar.

Pré-condições: Conta deve estar criada.

Passo a passo para execução:

    1- Acessar aplicação.
    2- Realizar Login.
    3- Clicar na Lupa (Botão explorar).
    4- Deve clicar em alguma foto.
    5- Deve clicar no botão de Comentar foto.
    6- Deve digitar na barra de comentário.
    7- Deve clicar em enviar.
    
Resultado esperado: Deve aparecer o comentário feito na postagem.

Status: OK.

Observação:

# ID 10
Funcionalidade: Explorar.

Título: Atualizar página do explorar.

Pré-condições: Conta deve estar criada.

Passo a passo para execução:

    1- Acessar aplicação.
    2- Realizar Login.
    3- Clicar na Lupa (Botão explorar).
    4- Deve fazer scroll para baixo.
    
Resultado esperado: Deve alterar o conteúdo do explorar.

Status: OK.

Observação:

# ID 11
Funcionalidade: Explorar.

Título: Salvar algum post do explorar.

Pré-condições: Conta deve estar criada.

Passo a passo para execução:

    1- Acessar aplicação.
    2- Realizar Login.
    3- Clicar na Lupa (Botão explorar).
    4- Deve clicar em alguma foto.
    5- Deve clicar no ícone de salvar publicação.
    
Resultado esperado: Deve aparecer que a publicação foi salva.

Status: OK.

Observação:

# ID 12
Funcionalidade: Explorar.

Título: Clicar botão "não recomende posts como este".

Pré-condições: Conta deve estar criada.

Passo a passo para execução:

    1- Acessar aplicação.
    2- Realizar Login.
    3- Clicar na Lupa (Botão explorar).
    4- Deve clicar e segurar em alguma foto até aparecer as opções da imagem.
    5- Deve arrastar para a opção "Options" e soltar.
    6- Deve clicar em "Not Interested".
    
Resultado esperado: Deve aparecer um pop-up confirmando a não recomendação de posts como o que foi clicado.

Status: OK.

Observação:

# ID 13
Funcionalidade: Perfil.

Título: Clicar like em alguma foto do perfil.

Pré-condições: Conta deve estar criada.

Passo a passo para execução:

    1- Acessar aplicação.
    2- Realizar Login.
    3- Clicar na Lupa (Botão explorar).
    4- Deve digitar na barra Search "Mark".
    5- Deve clicar no perfil do "Mark".
    6- Deve clicar em alguma foto do perfil.
    7- Deve deve clicar no botão de Like.
    
Resultado esperado: Deve preencher o botão de Like em vermelho.

Status: OK.

Observação:

# ID 14
Funcionalidade: Perfil.

Título: Comentar em alguma foto através do perfil.

Pré-condições: Conta deve estar criada.

Passo a passo para execução:

    1- Acessar aplicação.
    2- Realizar Login.
    3- Clicar na Lupa (Botão explorar).
    4- Deve digitar na barra Search "Mark".
    5- Deve clicar no perfil do "Mark".
    6- Deve clicar em alguma foto do perfi.
    7- Deve escrever na barra de comentário.
    8- Deve clicar no botão de enviar comentário.
    
Resultado esperado: Deve aparecer o comentário feito na postagem.

Status: OK.

Observação:

# ID 15
Funcionalidade: Perfil.

Título: Acessar enviar mensagem arrastando para a esquerda na tela do Perfil.

Pré-condições: Conta deve estar criada.

Passo a passo para execução:

    1- Acessar aplicação.
    2- Realizar Login.
    3- Clicar na Lupa (Botão explorar).
    4- Deve digitar na barra Search "Mark"
    5- Deve clicar no perfil do "Mark".
    6- Deve arrastar a tela para a esquerda.
    
Resultado esperado: Deve aparecer a tela para enviar mensagem para o perfil.

Status: NOK.

Observação: Não conseguiu acessar a tela de mensagem fazendo swipe para esquerda.

# ID 16
Funcionalidade: Perfil.

Título: Clicar esconder stories de algum Perfil.

Pré-condições: Conta deve estar criada.

Passo a passo para execução:

    1- Acessar aplicação.
    2- Realizar Login.
    3- Clicar na Lupa (Botão explorar).
    4- Deve digitar na barra Search "Mark".
    5- Deve clicar no perfil do "Mark".
    6- Deve clicar no botão de opções do perfil.
    7- Deve clicar no botão "Hide story".
    8- Deve confirmar clicando no botão "Hide".
    
Resultado esperado: Deve aparecer o pop-up "Mark will no longer see your story".

Status: OK.

Observação: