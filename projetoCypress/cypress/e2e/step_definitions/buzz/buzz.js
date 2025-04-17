/// <reference types="cypress" />

// Importa os steps do Cucumber pro Cypress (Given, When, Then)
import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps'

//Importando page para a classe de testes
import loginPage from '../../../support/pageObjects/loginPage'
import menuPage from '../../../support/pageObjects/menuPage'
import buzzPage from '../../../support/pageObjects/buzzPage'

Given('Eu estou logado no sistema', () => {
    cy.viewport(1200, 768)
    cy.acessarSistema()
    cy.logar('Admin', 'admin123')
    loginPage.isDashboardVisible()
})

And('Estou na tela de dashboard', () => {
    loginPage.isDashboardVisible()
})

And('Tenho um post criado', () => {
    menuPage.acessarBuzz()
    buzzPage.fazerPost()
    menuPage.acessarOpcaoMenu('Dashboard')
})

And('Tenho um post criado e tenho um comentário neste post', () => {
    menuPage.acessarBuzz()
    buzzPage.fazerPost()
    buzzPage.fazerComentario()
    menuPage.acessarOpcaoMenu('Dashboard')
})

When('Eu clicar em "Buzz" na barra de menu', () => {
    menuPage.acessarBuzz()
})

And('Eu clicar no ícone de coração de um post', () => {
    cy.get('[class="oxd-userdropdown-name"]').invoke('text').then(texto => {
        cy.wrap(texto.trim().slice(0, 5)).as('usuarioLogado')
    })
    cy.get('@usuarioLogado').then((usuario) => {
        buzzPage.clicarLikeAPost(usuario)
    });
})

And('Digitar no campo de post {string}', texto => {
    buzzPage.digitarCampoPost(texto)
})

And('Clicar no botão de post', () => {
    buzzPage.clicarBotaoPostNew()
})

And('Clicar nos 3 pontos do post escolhido', () => {
    cy.get('[class="oxd-userdropdown-name"]').invoke('text').then(texto => {
        cy.wrap(texto.trim().slice(0, 5)).as('usuarioLogado')
    })
    cy.get('@usuarioLogado').then((usuario) => {
        buzzPage.clicarOptionsPost(usuario)
    });
})

And('Clicar em Delete Post', () => {
    cy.get('@usuarioLogado').then((usuario) => {
        buzzPage.clicarOptionDelete(usuario);
    });
})

And('Clicar em Edit Post', () => {
    cy.get('@usuarioLogado').then((usuario) => {
        buzzPage.clicarOptionEdit(usuario)
    });
})

And('Confirmar Deletar Post', () => {
    buzzPage.clicarConfirmDelete()
})

And('Digitar no campo de edição {string}', texto => {
    buzzPage.digitarCampoEditPost(texto)
})

And('Clicar no botão de finalizar a edição', () => {
    buzzPage.clicarFinalizarEdicao()
})

And('Clicar no ícone de compartilhar de um post', () => {
    cy.get('[class="oxd-userdropdown-name"]').invoke('text').then(texto => {
        cy.wrap(texto.trim().slice(0, 5)).as('usuarioLogado')
    })
    cy.get('@usuarioLogado').then((usuario) => {
        buzzPage.clicarShareAPost(usuario)
    });
})

And('Clicar em confirmar compartilhamento', () => {
    buzzPage.clicarConfirmShare()
})

And('Clicar no ícone de comentar de um post', () => {
    cy.get('[class="oxd-userdropdown-name"]').invoke('text').then(texto => {
        cy.wrap(texto.trim().slice(0, 5)).as('usuarioLogado')
    })
    cy.get('@usuarioLogado').then((usuario) => {
        buzzPage.clicarCommentPost(usuario)
    });
})

And('Comentar {string}', comentario => {
    buzzPage.digitarCampoComentario(comentario)
})

And('Apertar a tecla enter', () => {
    buzzPage.digitarCampoComentario('{ENTER}')
})

And('Clicar no ícone de Like do comentário', () => {
    cy.get('@usuarioLogado').then((usuario) => {
        buzzPage.clicarLikeComment(usuario)
    });
})

And('Clicar no ícone de Edit do comentário', () => {
    cy.get('@usuarioLogado').then((usuario) => {
        buzzPage.clicarEditComment(usuario)
    });
})

And('Digitar no campo de edição do comentário {string}', comentario => {
    cy.get('@usuarioLogado').then((usuario) => {
        buzzPage.digitarCampoEditComment(usuario, comentario)
    })
})

And('Apertar a tecla enter no comentario', () => {
    cy.get('@usuarioLogado').then((usuario) => {
        buzzPage.digitarCampoEditComment(usuario, '{ENTER}')
    })
})

And('Clicar no ícone de Delete do comentário', () => {
    cy.get('@usuarioLogado').then((usuario) => {
        buzzPage.clicarDeleteComment(usuario)
    })
})

And('Confirmar Deletar comentario', () => {
    buzzPage.clicarConfirmDelete()
})

Then('Deve aparecer um toast informando {string}', msgToast => {
    buzzPage.msgToastContains(msgToast)
})

Then('Deve acrescentar o número de like em 1', () => {
    cy.get('@usuarioLogado').then((usuario) => {
        buzzPage.isLiked(usuario)
    })
})

Then('Deve diminuir o número de like em 1', () => {
    cy.get('@usuarioLogado').then((usuario) => {
        buzzPage.isLiked(usuario)
    })
})

Then('Deve aparecer o número 1 de like no comentário', () => {
    cy.get('@usuarioLogado').then((usuario) => {
        buzzPage.isCommentLiked(usuario)
    })
})