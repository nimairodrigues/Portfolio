/// <reference types="cypress" />

class PimPage {
    clicarBotaoNovoEmployee() {
        cy.get('[class="oxd-button oxd-button--medium oxd-button--secondary"]').click()
    }
    
    digitarFirstName(firstName) {
        cy.get('[name="firstName"]').type(firstName)
    }

    digitarLastName(lastName) {
        cy.get('[name="lastName"]').type(lastName)
    }

    clicarBotaoSave() {
        cy.get('[type="submit"]').click()
    }

    msgToastContains(textoToast) {
        cy.get('[class="oxd-toast-container oxd-toast-container--bottom"]').should('contain', textoToast)
    }

    textSpanFirstNameShouldBe(spanMsg) {
        cy.get('[class="--name-grouped-field"] > div:eq(0) span').should('contain', spanMsg)
    }

    textSpanLastNameShouldBe(spanMsg) {
        cy.get('[class="--name-grouped-field"] > div:eq(2) span').should('contain', spanMsg)
    }

    digitarEmployeeId(id) {
        cy.get('[class="oxd-form-row"] > div:eq(1) input').clear().type(id)
    }

    textSpanEmployeeIdShouldBe(spanMsg) {
        cy.get('[class="oxd-form-row"] > div:eq(1) span').should('contain', spanMsg)
    }

}

export default new PimPage