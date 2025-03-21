class MenuPage {

    acessarOpcaoMenu(opcao) {
        cy.get("[class='oxd-main-menu-item'] span:contains("+opcao+")").click()
        cy.get('[class="oxd-layout-context"]').should('be.visible')
    }

    acessarBuzz() {
        cy.get("[class='oxd-main-menu-item'] span:contains('Buzz')").click()
        cy.get('[class="oxd-grid-1 orangehrm-buzz-newsfeed-posts"] > div').should('be.visible')
    }
}

export default new MenuPage