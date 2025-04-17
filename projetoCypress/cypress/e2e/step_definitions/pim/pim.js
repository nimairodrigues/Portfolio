// Importa os steps do Cucumber pro Cypress (Given, When, Then)
import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps'

//Importando page para a classe de testes
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

And('Tenho um usuario criado para utilizar', () => {
    pimPage.criarNovoEmployee('Marcelo', 'Freitas')
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

And('Clicar no switch de create login details', () => {
    pimPage.clicarCreateLoginDetails()
})

And('Digitar no campo username {string}', username => {
    pimPage.digitarUsername(username)
})

And('Digitar no campo password {string}', password => {
    pimPage.digitarPassword(password)
})

And('Digitar no campo confirm password {string}', confirmPass => {
    pimPage.digitarConfirmPassword(confirmPass)
})

And('Clicar no botão de help', () => {
    pimPage.clicarHelp()
})

And('Digitar no campo de employee name de filtro', () => {
    cy.get('@firstNameUserCreated').then(firstName => {
        pimPage.typeFilterEmployeeName(firstName)
    })
})

And('Clicar no botão de pesquisar', () => {
    pimPage.clicarBotaoSearch()
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

Then('Deve aparecer uma mensagem span embaixo de username escrito {string}', msgSpan => {
    pimPage.textSpanUsernameShouldBe(msgSpan)
})

Then('Deve aparecer alguns usuarios no resultado da pesquisa', () => {
    cy.get('@iniciaisDoNome').then(initialsName => {
        pimPage.verifyNameUsersTable(initialsName)
    }) 
})

And('Deve aparecer uma mensagem span embaixo de password escrito {string}', msgSpan => {
    pimPage.textSpanPasswordShouldBe(msgSpan)
})

And('Deve aparecer uma mensagem span embaixo de confirm password escrito {string}', msgSpan => {
    pimPage.textSpanConfirmPassShouldBe(msgSpan)
})

And('Deve aparecer uma mensagem span embaixo de last name escrito {string}', msgSpan => {
    pimPage.textSpanLastNameShouldBe(msgSpan)
})

And('Digitar no campo Employee Id {string}', employeeId => {
    pimPage.digitarEmployeeId(employeeId)
})