import loginPage from "./pageObjects/loginPage"

//Criando um comando no cypress para realizar o login
Cypress.Commands.add('logar', (username, password) => {
    loginPage.logar(username, password)
})

//Criando um comando no cypresss para acessar o sistema
Cypress.Commands.add('acessarSistema', () => {
    cy.visit("https://opensource-demo.orangehrmlive.com")
})