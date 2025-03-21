Feature: Buzz

Scenario: Fazer um post
Given Eu estou logado no sistema
And Estou na tela de dashboard
When Eu clicar em "Buzz" na barra de menu
And Digitar no campo de post "Sou bonito"
And Clicar no botão de post
Then Deve aparecer um toast informando "Successfully Saved"

Scenario: Apagar um post
Given Eu estou logado no sistema
And Estou na tela de dashboard
And Tenho um post criado
When Eu clicar em "Buzz" na barra de menu
And Clicar nos 3 pontos do post escolhido
And Clicar em Delete Post
And Confirmar Deletar Post
Then Deve aparecer um toast informando "Successfully Deleted"

Scenario: Alterar um post
Given Eu estou logado no sistema
And Estou na tela de dashboard
And Tenho um post criado
When Eu clicar em "Buzz" na barra de menu
And Clicar nos 3 pontos do post escolhido
And Clicar em Edit Post
And Digitar no campo de edição " Editado"
And Clicar no botão de finalizar a edição
Then Deve aparecer um toast informando "Successfully Updated"

Scenario: Dar like em algum post
Given Eu estou logado no sistema
And Estou na tela de dashboard
And Tenho um post criado
When Eu clicar em "Buzz" na barra de menu
And Eu clicar no ícone de coração de um post
Then Deve acrescentar o número de like em 1

Scenario: Tirar like de algum post
Given Eu estou logado no sistema
And Estou na tela de dashboard
And Tenho um post criado
When Eu clicar em "Buzz" na barra de menu
And Eu clicar no ícone de coração de um post
And Eu clicar no ícone de coração de um post
Then Deve diminuir o número de like em 1

Scenario: Compartilhar um post
Given Eu estou logado no sistema
And Estou na tela de dashboard
And Tenho um post criado
When Eu clicar em "Buzz" na barra de menu
And Clicar no ícone de compartilhar de um post
And Clicar em confirmar compartilhamento
Then Deve aparecer um toast informando "Successfully Saved"

Scenario: Comentar um post
Given Eu estou logado no sistema
And Estou na tela de dashboard
And Tenho um post criado
When Eu clicar em "Buzz" na barra de menu
And Clicar no ícone de comentar de um post
And Comentar "Texto123"
And Apertar a tecla enter
Then Deve aparecer um toast informando "Successfully Saved"

Scenario: Curtir um comentário um post
Given Eu estou logado no sistema
And Estou na tela de dashboard
And Tenho um post criado e tenho um comentário neste post
When Eu clicar em "Buzz" na barra de menu
And Clicar no ícone de comentar de um post
And Clicar no ícone de Like do comentário
Then Deve aparecer o número 1 de like no comentário

Scenario: Editar o próprio comentário de um post
Given Eu estou logado no sistema
And Estou na tela de dashboard
And Tenho um post criado e tenho um comentário neste post
When Eu clicar em "Buzz" na barra de menu
And Clicar no ícone de comentar de um post
And Clicar no ícone de Edit do comentário
And Digitar no campo de edição do comentário " Editado"
And Apertar a tecla enter no comentario
Then Deve aparecer um toast informando "Successfully Updated"
@focus 
Scenario: Deletar o próprio comentário de um post
Given Eu estou logado no sistema
And Estou na tela de dashboard
And Tenho um post criado e tenho um comentário neste post
When Eu clicar em "Buzz" na barra de menu
And Clicar no ícone de comentar de um post
And Clicar no ícone de Delete do comentário
And Confirmar Deletar comentario
Then Deve aparecer um toast informando "Successfully Deleted"