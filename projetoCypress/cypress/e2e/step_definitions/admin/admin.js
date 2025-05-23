// Importa os steps do Cucumber pro Cypress (Given, When, Then)
import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps'

//Importando page para a classe de testes
import adminPage from "../../../support/pageObjects/adminPage";
import loginPage from '../../../support/pageObjects/loginPage';
import menuPage from '../../../support/pageObjects/menuPage';

let username = null

// G I V E N 
Given('Eu estou logado no sistema', () => {
    cy.acessarSistema()
    cy.logar('Admin', 'admin123')
    loginPage.isDashboardVisible()
})

And('Estou na tela de dashboard', () => {
    loginPage.isDashboardVisible()
})

And('Tenho um usuário para utilizar', () => {
    menuPage.acessarOpcaoMenu('Admin')
    adminPage.criarUser('a', 'Enabled', 'juliano', 'senhaqualquer1')
    menuPage.acessarOpcaoMenu('Dashboard')
    
})

// W H E N 
When('Eu clicar em {string} na barra de menu', (opcaoMenu) => {
    menuPage.acessarOpcaoMenu(opcaoMenu)
})

And('Clicar no botão de criar novo usuário', () => {
    adminPage.clicarBotaoNovoUsuario()
})

And('Selecionar opcao no campo User Role uma opcao qualquer', () => {
    adminPage.selectRoleNumOption(1)
})

And('Digitar no campo Employee Name {string}', name => {
    adminPage.digitarEmployeeName(name)
})

And('Selecionar opcao no campo Status uma opcao qualquer', () => {
    adminPage.selectStatusNameOption('Enabled')
})

And('Digitar no campo Username {string}', username => {
    adminPage.digitarUsername(username)
})

And('Digitar no campo Password {string}', password => {
    adminPage.digitarPassword(password)
})

And('Digitar no campo Confirm Password {string}', confirmPassword => {
    adminPage.digitarConfirmPassword(confirmPassword)
})

And('Clicar no botão de salvar', () => {
    cy.get('button:contains("Save")').click()
})

And('Clicar no ícone de excluir de um usuário qualquer', () => {
    cy.get('@usernameEscrito').then(usernameEscrito => {
        adminPage.clicarApagarUser(usernameEscrito)
    })
})

And('Clicar para confirmar a exclusão', () => {
    adminPage.clicarConfirmApagarUser()
})

And('Clicar no ícone de editar de um usuário qualquer', () => {
    cy.get('@usernameEscrito').then(usernameEscrito => {
        adminPage.clicarEditarUser(usernameEscrito)
    })
})

And('Selecionar opcao no campo User Role do filtro opcao administrador', () => {
    adminPage.selectFilterUserRole('Admin')
})

And('Clicar no botão de search', () => {
    adminPage.clicarBotaoSearch()
})

// T H E N
Then('Deve aparecer um toast informando {string}', textoToast => {
    adminPage.msgToastContains(textoToast)
})

Then('Deve aparecer uma mensagem span embaixo de username escrito {string}', textSpan => {
    adminPage.textSpanUsernameShouldBe(textSpan)
})

Then('Deve aparecer uma mensagem span embaixo de password escrito {string}', textSpan => {
    adminPage.textSpanPasswordShouldBe(textSpan)
})

Then('Deve aparecer uma mensagem span embaixo de confirm password escrito {string}', textSpan => {
    adminPage.textSpanConfirmPassShouldBe(textSpan)
})

Then('Deve aparecer uma mensagem span embaixo de user role escrito {string}', textSpan => {
    adminPage.textSpanUserRoleShouldBe(textSpan)
})

Then('Deve aparecer apenas usuarios admin na tabela', () => {
    adminPage.verificarUserRoleTable('Admin')
})

And('Deve aparecer uma mensagem span embaixo de employee name escrito {string}', textSpan => {
    adminPage.textSpanEmployeeNameShouldBe(textSpan)
})

And('Deve aparecer uma mensagem span embaixo de status escrito {string}', textSpan => {
    adminPage.textSpanStatusShouldBe(textSpan)
})
