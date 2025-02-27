class MenuPage {

    acessarOpcaoMenu(opcao) {
        cy.get("[class='oxd-main-menu-item'] span:contains("+opcao+")").click()
    }
}

export default new MenuPage