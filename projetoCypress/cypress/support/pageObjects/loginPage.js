/// <reference types="cypress" />

class LoginPage {

    digitarUsername(username) {
        cy.get('[name=username]').type(username)
    }

    digitarPassword(password) {
        cy.get('[name=password]').type(password)
    }

    clicarLogin() {
        cy.get('button[type=submit]').click()
    }
    
    isDashboardVisible() {
        cy.get('div[class="oxd-grid-3 orangehrm-dashboard-grid"]').should('be.visible')
    }

    isInvalidCredVisible() {
        cy.get("div[class='oxd-alert oxd-alert--error']").should('contain', 'Invalid credentials')
    }

    isRequiredUsernameVisible() {
        cy.get("[name='username']").parent().siblings('span').should('have.text', 'Required')
    }

    isRequiredPasswordVisible() {
        cy.get("[name='password']").parent().siblings('span').should('have.text', 'Required')
    }

    clicarForgotPassword() {
        cy.get('[class="oxd-text oxd-text--p orangehrm-login-forgot-header"]').click()
    }

    isTitleForgotPassHaveText(text) {
        cy.get('[class="oxd-text oxd-text--h6 orangehrm-forgot-password-title"]').should('have.text', text)
    }

    clicarCancelarForgotPass() {
        cy.get('[class="oxd-button oxd-button--large oxd-button--ghost orangehrm-forgot-password-button orangehrm-forgot-password-button--cancel"]')
            .click()
    }

    isTelaLoginVisible() {
        cy.get('[class="oxd-text oxd-text--h5 orangehrm-login-title"]').should('be.visible')
    }

    digitarUsernameForgotPass(username) {
        cy.get('[name="username"]').type(username)
    }

    clicarResetPass() {
        cy.get('.orangehrm-forgot-password-button--reset').click()
    }

    isRequiredUsernameForgotPassVisible() {
        cy.get("[name='username']").parent().siblings('span').should('have.text', 'Required')
    }
}

export default new LoginPage