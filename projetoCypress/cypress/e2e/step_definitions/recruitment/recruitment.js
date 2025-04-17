// Importa os steps do Cucumber pro Cypress (Given, When, Then)
import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps'

//Importando page para a classe de testes
import loginPage from "../../../support/pageObjects/loginPage"
import menuPage from '../../../support/pageObjects/menuPage'
import recruitmentPage from '../../../support/pageObjects/recruitmentPage'

Given('Eu estou logado no sistema', () => {
    cy.viewport(1200, 768)
    cy.acessarSistema()
    cy.logar('Admin', 'admin123')
    loginPage.isDashboardVisible()
})

And('Estou na tela de dashboard', () => {
    loginPage.isDashboardVisible()
})

And('Tenho um candidato adicionado', () => {
    recruitmentPage.addNewCandidate('Jurandir3', 'Peixoto', 'jurandirpeixoto@email.com')
})

When('Eu clicar em {string} na barra de menu', menuOption => {
    menuPage.acessarOpcaoMenu(menuOption)
})

And('Clicar no botão de criar novo candidato', () => {
    recruitmentPage.clicarBotãoNewCandidate()
})

And('Digitar no campo First Name o nome {string}', firstName => {
    recruitmentPage.typeFirstNameField(firstName)
})

And('Digitar no campo Last Name o nome {string}', lastName => {
    recruitmentPage.typeLastNameField(lastName)
})

And('Digitar no campo email o email {string}', email => {
    recruitmentPage.typeEmailField(email)
})

And('Clicar no botão de salvar', () => {
    recruitmentPage.clickSaveButton()
})

And('Selecionar opcao no campo Vacancy uma opcao qualquer', () => {
    recruitmentPage.selectVacancyNumOption(4)
})


And('Clicar no ícone de lixeira de um candidato', () => {
    cy.get('@firstNameWritten').then(firstName => {
        recruitmentPage.clicarDeleteCandidatePerFirstName(firstName)
    })
})

And('Clicar no botão de confirmar a exclusão', () => {
    recruitmentPage.clicarConfirmApagarCandidate()
})

And('Selecionar opcao no campo Job Title do filtro a opcao {string}', optionJobTitleFilter => {
    recruitmentPage.selectJobTitleFilter(optionJobTitleFilter)
})

And('Clicar no botão de search', () => {
    recruitmentPage.clicarBotaoSearch()
})

And('Clicar no ícone de olho de um candidato', () => {
    cy.get('@firstNameWritten').then(firstNameWrittenn => {
        recruitmentPage.clicarViewCandidateProfilePerFirstName(firstNameWrittenn)
    })
})

Then('Deve aparecer um toast informando {string}', msgToast => {
    recruitmentPage.msgToastContains(msgToast)
})

Then('Deve aparecer uma mensagem span embaixo de first name escrito {string}', msgSpan => {
    recruitmentPage.textSpanFirstNameShouldBe(msgSpan)
})

Then('Deve aparecer apenas usuarios do job pesquisado na tabela', () => {
    cy.get('@jobNameWritten').then(jobNameWrittenn => {
        recruitmentPage.verificarJobsCandidateTable(jobNameWrittenn)
    })
}) 

Then('Deve aparecer o perfil do candidato', () => {
    recruitmentPage.isProfileCandidateVisible()
})

And('Deve aparecer uma mensagem span embaixo de last name escrito {string}', msgSpan => {
    recruitmentPage.textSpanLastNameShouldBe(msgSpan)
})

And('Deve aparecer uma mensagem span embaixo de email escrito {string}', msgSpan => {
    recruitmentPage.textSpanEmailShouldBe(msgSpan)
})
