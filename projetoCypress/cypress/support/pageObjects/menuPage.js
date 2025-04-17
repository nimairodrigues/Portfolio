//Ativa os comandos do Cypress no código
/// <reference types="cypress" />

//Classe de Page contendo os métodos de interação com a tela de login
class MenuPage {

    //Método para acessar as opções do menu recebendo o nome da opção
    acessarOpcaoMenu(opcao) {
        cy.get("[class='oxd-main-menu-item'] span:contains("+opcao+")").click()
        cy.get('[class="oxd-layout-context"]').should('be.visible')
    }

    //Necessário criar um método exclusivo para o buzz pois ao acessar
    //o sistema carregava a pagina 2x para ser possível digitar no campo ou fazer outra ação
    //e o cypress tentava fazer a ação já na 1º e ao sistema carregar a próxima vez, ele já se perdia
    acessarBuzz() {
        cy.get("[class='oxd-main-menu-item'] span:contains('Buzz')").click()
        //"Verificação" para aguardar o elemento ficar visível para continuar os testes
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] > div').should('be.visible')
    }
}

// Exporta a classe para uso dos métodos nos testes
export default new MenuPage