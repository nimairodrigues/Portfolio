//Ativa os comandos do Cypress no código
/// <reference types="cypress" />

//Classe de Page contendo os métodos de interação com a tela de login
class BuzzPage {

    //Digitar no campo de Post da tela de Buzz
    digitarCampoPost(texto) {
        //Digitando no campo depois de apagar o campo
        cy.get('.oxd-buzz-post-input').clear().type(texto)
    }

    //Clicar no botão de postar
    clicarBotaoPostNew() {
        cy.get('[type="submit"]:eq(0)').click()
    }

    //Verificando se a mensagem do toast contain o texto recebido no método
    msgToastContains(textoToast) {
        cy.get('[class="oxd-toast-container oxd-toast-container--bottom"]').should('contain', textoToast)
    }
    
    //Clicar no options do post de acordo com o nome recebido no método, encontrando o primeiro post com o nome
    clicarOptionsPost(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-buzz-post-header-config"]').click()
    }

    //Clicar na opção delete do options do post de acordo com o nome recebido no método (não sei se precisava do nome)
    clicarOptionDelete(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [role=menu] > li:eq(0)').click()
    }

    //Clicar na opção edit do options do post de acordo com o nome recebido no método (não sei se precisava do nome)
    clicarOptionEdit(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [role=menu] > li:eq(1)').click()
    }

    //Clicar no botão de confirmar exclusão de post
    clicarConfirmDelete() {
        cy.get('[class="oxd-dialog-container-default"] [class="oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin"]').click()
        this.msgToastContains('Successfully Deleted')
    }

    //Digitar no campo de editar post recebendo o texto para ser escrito no campo
    digitarCampoEditPost(texto) {
        cy.get('[class="oxd-dialog-container-default"] textarea').type(texto)
    }

    //Clicar no botão para salvar a edição
    clicarFinalizarEdicao() {
        cy.get('[class="oxd-dialog-container-default"] [class="oxd-form-actions orangehrm-buzz-post-modal-actions"] button').click()
    }
    
    //Método para criar um post (necessário em alguns testes, pois não da pra garantir que um post irá existir pra usar nos testes)
    fazerPost() {
        this.digitarCampoPost('Texto qualquer')
        this.clicarBotaoPostNew()
        this.msgToastContains('Successfully Saved')
    }

    //Clicar no botão de like de um post de acordo com o nome recebido no método (não da pra garantir que vá existir um post)
    clicarLikeAPost(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-heart-icon"]').click()
    }

    //Verificando se o post do nome recebido pelo método está curtido
    isLiked(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-buzz-stats-row"] p').should('contain', '1 Like')
    }

    //Verificando se o post do nome recebido pelo método não está curtido
    isNotLiked(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-buzz-stats-row"] p').should('contain', '0 Likes')
    }

    //Clicar no botão de curtir o post pelo nome recebido pelo método
    clicarShareAPost(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="oxd-icon bi-share-fill"]').click()
    }

    //Clicar no botão de confirmar compartilhamento
    clicarConfirmShare() {
        cy.get('[class="oxd-dialog-container-default"] [type=submit]').click()
    }

    //Clicar no ícone de comentar post
    clicarCommentPost(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="oxd-icon bi-chat-text-fill"]').click()
    }

    //Digitar no campo de comentário aberto recebendo pelo método o texto a ser escrito como comentário
    digitarCampoComentario(comentario) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"] input').type(comentario)
    }

    //Método para fazer um comentário
    fazerComentario() {
        //Get para pegar as iniciais do usuário logado
        //Aqui foi necessário pois o nome do usuário logado PODE ser diferente do que é apresentado no nome de dono do post
        //Por isso o método para pegar apenas as 5 primeiras letras
        cy.get('[class="oxd-userdropdown-name"]').invoke('text').then(texto => {
            //Encapsulando para o cypress o nome e capturando apenas as 5 primeiras letras, finalizando com um alias
            //para usar no próximo código
            cy.wrap(texto.trim().slice(0, 5)).as('usuarioLogado')
        })
        cy.get('@usuarioLogado').then((usuario) => {
            this.clicarCommentPost(usuario)
            this.digitarCampoComentario('Comentario Qualquer')
            this.digitarCampoComentario('{ENTER}')
            this.msgToastContains('Successfully Saved')
        });
    }

    //Clicar para dar like em um comentário recebendo o nome do dono do comentário no método
    clicarLikeComment(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-buzz-comment"] [class="orangehrm-comment-wrapper"]:eq(0) p:contains(\'Like\')').click()
    }

    //Clicar para editar um comentário recebendo o nome do dono do comentário no método
    clicarEditComment(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-buzz-comment"] [class="orangehrm-comment-wrapper"]:eq(0) p:contains(\'Edit\')').click()
    }

    //Clicar para apagar um comentário recebendo o nome do dono do comentário no método
    clicarDeleteComment(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-buzz-comment"] [class="orangehrm-comment-wrapper"]:eq(0) p:contains(\'Delete\')').click()
    }

    //Verificar se o comentário está curtido
    isCommentLiked(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-buzz-comment"] [class="orangehrm-comment-wrapper"]:eq(0) [class="orangehrm-post-comment-stats"]').should('contain', '1')
    }

    //Digitar no campo de editar comentário, recebendo o nome do dono do comentário e o texto para editar o comentário
    digitarCampoEditComment(nome, comentario) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-buzz-comment"] [class="orangehrm-comment-wrapper"]:eq(0) input').type(comentario)
    }
}

// Exporta a classe para uso dos métodos nos testes
export default new BuzzPage