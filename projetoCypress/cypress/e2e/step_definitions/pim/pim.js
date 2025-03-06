import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps'
import loginPage from '../../../support/pageObjects/loginPage'
import menuPage from '../../../support/pageObjects/menuPage'
import pimPage from '../../../support/pageObjects/pimPage'

Given('Eu estou logado no sistema', () => {
    cy.acessarSistema()
    cy.logar('Admin', 'admin123')
    loginPage.isDashboardVisible()
})

And('Estou na tela de dashboard', () => {
    loginPage.isDashboardVisible()
})

When('Eu clicar em {string} na barra de menu', (opcaoMenu) => {
    menuPage.acessarOpcaoMenu(opcaoMenu)
})

And('Clicar no botão de criar novo empregado', () => {
    pimPage.clicarBotaoNovoEmployee()
})

And('Digitar no campo First Name {string}', firstName => {
    pimPage.digitarFirstName(firstName)
})

And('Digitar no campo Last Name {string}', lastName => {
    pimPage.digitarLastName(lastName)
})

And('Clicar no botão de save', () => {
    pimPage.clicarBotaoSave()
})

Then('Deve aparecer um toast informando {string}', textoToast => {
    pimPage.msgToastContains(textoToast)
})

Then('Deve aparecer uma mensagem span embaixo de first name escrito {string}', msgSpan => {
    pimPage.textSpanFirstNameShouldBe(msgSpan)
})

Then('Deve aparecer uma mensagem span embaixo de employee id escrito {string}', msgSpan => {
    pimPage.textSpanEmployeeIdShouldBe(msgSpan)
})

And('Deve aparecer uma mensagem span embaixo de last name escrito {string}', msgSpan => {
    pimPage.textSpanLastNameShouldBe(msgSpan)
})

And('Digitar no campo Employee Id {string}', employeeId => {
    pimPage.digitarEmployeeId(employeeId)
})