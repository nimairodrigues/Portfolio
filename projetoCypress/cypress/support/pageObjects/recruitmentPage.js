//Ativa os comandos do Cypress no código
/// <reference types="cypress" />

import menuPage from "./menuPage"

//Classe de Page contendo os métodos de interação com a tela de login
class RecruitmentPage {

    //Clicar no botão de adicionar um novo candidato
    clicarBotãoNewCandidate() {
        cy.get('[class="oxd-button oxd-button--medium oxd-button--secondary"]').click()
    }

    //Digitar no campo de FirstName
    typeFirstNameField(firstName) {
        cy.get('[name="firstName"]').type(firstName)
    }

    //Digitar no campo de LastName
    typeLastNameField(lastName) {
        cy.get('[name="lastName"]').type(lastName)
    }

    //Digitar no campo de email
    typeEmailField(email) {
        cy.get('[class="oxd-form-row"]:nth-child(3) > div > div:nth-child(1) input').type(email)
    }

    //Clicar no botão de salvar
    clickSaveButton() {
        cy.get('[type="submit"]').click()
    }

    //Verificando se a mensagem do toast contain o texto recebido no método
    msgToastContains(textoToast) {
        cy.get('[class="oxd-toast-container oxd-toast-container--bottom"]').should('contain', textoToast)
    }

    //Verificando se o span do campo firstName contém o texto recebido no método
    textSpanFirstNameShouldBe(msgSpan) {
        cy.get('[class="oxd-form-row"]:nth-child(1) [class="oxd-input-group oxd-input-field-bottom-space"]:nth-child(1) span').should('contain', msgSpan)
    }

    //Verificando se o span do campo LastName contém o texto recebido no método
    textSpanLastNameShouldBe(msgSpan) {
        cy.get('[class="oxd-form-row"]:nth-child(1) [class="oxd-input-group oxd-input-field-bottom-space"]:nth-child(3) span').should('contain', msgSpan)
    }

    //Verificando se o span do campo email contém o texto recebido no método
    textSpanEmailShouldBe(msgSpan) {
        cy.get('[class="oxd-form-row"]:nth-child(3) [class="oxd-input-group oxd-input-field-bottom-space"]:nth-child(1) span').should('contain', msgSpan)
    }

    //Selecionar a vaga pelo número da opção recebida no método // aqui o selecionado não faz diferença, podendo ser qualquer um
    selectVacancyNumOption(numOption) {
        //Clicando no select
        cy.get('[class="oxd-form-row"]:nth-child(2) [class="oxd-select-wrapper"]').click()

        //Clicando na opção de acordo com a ordem numérica
        cy.get("[class='oxd-select-dropdown --positon-bottom'] div:eq("+numOption+")").click()
    }

    //Método para criar um novo candidato para ser usado em outros testes
    addNewCandidate(firstName, lastName, emailAddress) {
        menuPage.acessarOpcaoMenu('Recruitment')
        this.clicarBotãoNewCandidate()
        this.typeFirstNameField(firstName)
        this.typeLastNameField(lastName)
        this.typeEmailField(emailAddress)
        
        //Encapsulando a string do firstName para ser usado posteriormente e adicionando a ele um alias
        cy.wrap(firstName).as('firstNameWritten')
        this.clickSaveButton()
        this.msgToastContains('Successfully Saved')
        menuPage.acessarOpcaoMenu('Dashboard')
    }

    //Clicar no ícone de deletar candidato pelo firstName recebido no método
    clicarDeleteCandidatePerFirstName(firstName) {
        cy.get('[class="oxd-table-row oxd-table-row--with-border"]:contains('+firstName+'):eq(0) [class="oxd-icon bi-trash"]').click()
    }

    //Clicar no botão de confirmar exclusão do candidato
    clicarConfirmApagarCandidate() {
        cy.get("[class='oxd-dialog-container-default--inner'] [class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']").click()
    }

    //Selecionar o trabalho no filtro
    selectJobTitleFilter(jobName) {
        //Clicando no select
        cy.get('[class="oxd-select-text oxd-select-text--active"]:eq(0)').click()
        //Clicando na opção de acordo com o nome do jobName
        cy.get("[role=\"listbox\"] div:contains("+jobName+")").click()

        //Encapsulando a string do jobName para ser usado posteriormente e adicionando a ele um alias
        cy.wrap(jobName).as('jobNameWritten')
    }

    //Clicar no botão de search
    clicarBotaoSearch() {
        //Capturando uma requisição feita pelo sistema, pois após o click em submit é necessário aguardar essa requisição para continuar o fluxo dos testes
        //E adicionando um alias a ela
        cy.intercept('GET', '/web/index.php/api/v2/recruitment/candidates?limit=50&offset=0&jobTitleId=8&model=list&sortField=candidate.dateOfApplication&sortOrder=DESC').as('getCandidateList')
        cy.get('[type="submit"]').click()
    }

    //Verificar se na tabela contém apenas o nome do trabalho recebido no método
    verificarJobsCandidateTable(role) {
        //Aguardando a requisição getCandidateList ser feita para continuar o fluxo
        cy.wait('@getCandidateList')

        //Verificando se nas colunas de Role da tabela aparecem apenas o que for introduzido no método
        cy.get(".oxd-table .oxd-table-body div[role='row'] > [class='oxd-table-cell oxd-padding-cell']:nth-child(2)").each($el => {
            cy.wrap($el).should('contain', role)
        })
    }

    //Clicar no ícone de visualizar perfil do candidato através do first name recebido no método
    clicarViewCandidateProfilePerFirstName(firstName) {
        cy.get('[class="oxd-table-row oxd-table-row--with-border"]:contains('+firstName+'):eq(0) [class="oxd-icon bi-eye-fill"]').click()
    }

    //Verificando se a tela de perfil do candidato está visível
    isProfileCandidateVisible() {
        cy.get('[class="oxd-text oxd-text--h6 orangehrm-main-title"]').should('contain', 'Candidate Profile')
    }
}

// Exporta a classe para uso dos métodos nos testes
export default new RecruitmentPage