/// <reference types="cypress" />

class BuzzPage {

    digitarCampoPost(texto) {
        // cy.intercept('GET', '/web/index.php/api/v2/buzz/feed?limit=10&offset=0&sortOrder=DESC&sortField=share.createdAtUtc').as('page')
        // cy.wait('@page')
        // cy.wait('@page')
        cy.get('.oxd-buzz-post-input').clear().type(texto)
    }

    clicarBotaoPostNew() {
        cy.get('[type="submit"]:eq(0)').click()
    }

    clicarBotaoPostEdit() {
        cy.get('[type="submit"]:eq(1)').click()
    }

    msgToastContains(textoToast) {
        cy.get('[class="oxd-toast-container oxd-toast-container--bottom"]').should('contain', textoToast)
    }

    clicarOptionsPost(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-buzz-post-header-config"]').click()
    }

    clicarOptionDelete(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [role=menu] > li:eq(0)').click()
    }

    clicarOptionEdit(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [role=menu] > li:eq(1)').click()
    }

    clicarConfirmDelete() {
        cy.get('[class="oxd-dialog-container-default"] [class="oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin"]').click()
        this.msgToastContains('Successfully Deleted')
    }

    digitarCampoEditPost(texto) {
        cy.get('[class="oxd-dialog-container-default"] textarea').type(texto)
    }

    clicarFinalizarEdicao() {
        cy.get('[class="oxd-dialog-container-default"] [class="oxd-form-actions orangehrm-buzz-post-modal-actions"] button').click()
    }
    
    deletarPost(nome) {
        this.clicarOptionsPost(nome)
        this.clicarOptionDelete(nome)
        this.clicarConfirmDelete()
    }

    fazerPost() {
        this.digitarCampoPost('Texto qualquer')
        this.clicarBotaoPostNew()
        this.msgToastContains('Successfully Saved')
    }

    clicarLikeAPost(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-heart-icon"]').click()
    }

    isLiked(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-buzz-stats-row"] p').should('contain', '1 Like')
    }

    isNotLiked(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-buzz-stats-row"] p').should('contain', '0 Likes')
    }

    clicarShareAPost(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="oxd-icon bi-share-fill"]').click()
    }

    clicarConfirmShare() {
        cy.get('[class="oxd-dialog-container-default"] [type=submit]').click()
    }

    clicarCommentPost(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="oxd-icon bi-chat-text-fill"]').click()
    }

    digitarCampoComentario(comentario) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"] input').type(comentario)
    }

    fazerComentario() {
        cy.get('[class="oxd-userdropdown-name"]').invoke('text').then(texto => {
            cy.wrap(texto.trim().slice(0, 5)).as('usuarioLogado')
        })
        cy.get('@usuarioLogado').then((usuario) => {
            this.clicarCommentPost(usuario)
            this.digitarCampoComentario('Comentario Qualquer')
            this.digitarCampoComentario('{ENTER}')
            this.msgToastContains('Successfully Saved')
        });
    }

    clicarLikeComment(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-buzz-comment"] [class="orangehrm-comment-wrapper"]:eq(0) p:contains(\'Like\')').click()
    }

    clicarEditComment(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-buzz-comment"] [class="orangehrm-comment-wrapper"]:eq(0) p:contains(\'Edit\')').click()
    }

    clicarDeleteComment(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-buzz-comment"] [class="orangehrm-comment-wrapper"]:eq(0) p:contains(\'Delete\')').click()
    }

    isCommentLiked(nome) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-buzz-comment"] [class="orangehrm-comment-wrapper"]:eq(0) [class="orangehrm-post-comment-stats"]').should('contain', '1')
    }

    digitarCampoEditComment(nome, comentario) {
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] [class="oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz"]:contains('+nome+'):eq(0) [class="orangehrm-buzz-comment"] [class="orangehrm-comment-wrapper"]:eq(0) input').type(comentario)
    }
}

export default new BuzzPage