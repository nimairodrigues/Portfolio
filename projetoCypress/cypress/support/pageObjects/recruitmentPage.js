/// <reference types="cypress" />

import menuPage from "./menuPage"

class RecruitmentPage {

    clicarBotãoNewCandidate() {
        cy.get('[class="oxd-button oxd-button--medium oxd-button--secondary"]').click()
    }

    typeFirstNameField(firstName) {
        cy.get('[name="firstName"]').type(firstName)
    }

    typeLastNameField(lastName) {
        cy.get('[name="lastName"]').type(lastName)
    }

    typeEmailField(email) {
        cy.get('[class="oxd-form-row"]:nth-child(3) > div > div:nth-child(1) input').type(email)
    }

    clickSaveButton() {
        cy.get('[type="submit"]').click()
    }

    msgToastContains(textoToast) {
        cy.get('[class="oxd-toast-container oxd-toast-container--bottom"]').should('contain', textoToast)
    }

    textSpanFirstNameShouldBe(msgSpan) {
        cy.get('[class="oxd-form-row"]:nth-child(1) [class="oxd-input-group oxd-input-field-bottom-space"]:nth-child(1) span').should('contain', msgSpan)
    }

    textSpanLastNameShouldBe(msgSpan) {
        cy.get('[class="oxd-form-row"]:nth-child(1) [class="oxd-input-group oxd-input-field-bottom-space"]:nth-child(3) span').should('contain', msgSpan)
    }

    textSpanEmailShouldBe(msgSpan) {
        cy.get('[class="oxd-form-row"]:nth-child(3) [class="oxd-input-group oxd-input-field-bottom-space"]:nth-child(1) span').should('contain', msgSpan)
    }

    selectVacancyNumOption(numOption) {
        cy.get('[class="oxd-form-row"]:nth-child(2) [class="oxd-select-wrapper"]').click()
        cy.get("[class='oxd-select-dropdown --positon-bottom'] div:eq("+numOption+")").click()
    }

    getFirstNameWritten() {
        
    }

    addNewCandidate(firstName, lastName, emailAddress) {
        menuPage.acessarOpcaoMenu('Recruitment')
        this.clicarBotãoNewCandidate()
        this.typeFirstNameField(firstName)
        this.typeLastNameField(lastName)
        this.typeEmailField(emailAddress)
        
        cy.wrap(firstName).as('firstNameWritten')
        this.clickSaveButton()
        this.msgToastContains('Successfully Saved')
        menuPage.acessarOpcaoMenu('Dashboard')
    }

    clicarDeleteCandidatePerFirstName(firstName) {
        cy.get('[class="oxd-table-row oxd-table-row--with-border"]:contains('+firstName+'):eq(0) [class="oxd-icon bi-trash"]').click()
    }

    clicarConfirmApagarCandidate() {
        cy.get("[class='oxd-dialog-container-default--inner'] [class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']").click()
    }

    selectJobTitleFilter(jobName) {
            cy.get('[class="oxd-select-text oxd-select-text--active"]:eq(0)').click()
            cy.get("[role=\"listbox\"] div:contains("+jobName+")").click()
            cy.wrap(jobName).as('jobNameWritten')
    }

    clicarBotaoSearch() {
        cy.intercept('GET', '/web/index.php/api/v2/recruitment/candidates?limit=50&offset=0&jobTitleId=8&model=list&sortField=candidate.dateOfApplication&sortOrder=DESC').as('getCandidateList')
        cy.get('[type="submit"]').click()
    }

    verificarJobsCandidateTable(role) {
        cy.wait('@getCandidateList')

        cy.get(".oxd-table .oxd-table-body div[role='row'] > [class='oxd-table-cell oxd-padding-cell']:nth-child(2)").each($el => {
            cy.wrap($el).should('contain', role)
        })
    }

    clicarViewCandidateProfilePerFirstName(firstName) {
        cy.get('[class="oxd-table-row oxd-table-row--with-border"]:contains('+firstName+'):eq(0) [class="oxd-icon bi-eye-fill"]').click()
    }

    isProfileCandidateVisible() {
        cy.get('[class="oxd-text oxd-text--h6 orangehrm-main-title"]').should('contain', 'Candidate Profile')
    }
}

export default new RecruitmentPage