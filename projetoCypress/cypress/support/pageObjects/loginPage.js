//Ativa os comandos do Cypress no código
/// <reference types="cypress" />

//Classe de Page contendo os métodos de interação com a tela de login
class LoginPage {

    //Digitando no campo de username
    digitarUsername(username) {
        cy.get('[name=username]').type(username)
    }

    //Digitando no campo de password
    digitarPassword(password) {
        cy.get('[name=password]').type(password)
    }

    //Clicar no botão de login da tela de login
    clicarLogin() {
        cy.get('button[type=submit]').click()
    }

    //Método para realizar o login, recebendo username e password
    logar(username, password) {
        this.digitarUsername(username)
        this.digitarPassword(password)
        this.clicarLogin()
    }
    
    //Verificando se a dashboard está visível
    isDashboardVisible() {
        cy.get('div[class="oxd-grid-3 orangehrm-dashboard-grid"]').should('be.visible')
    }

    //Verificando se a mensagem Invalid Credential ta visível
    isInvalidCredVisible() {
        cy.get("div[class='oxd-alert oxd-alert--error']").should('contain', 'Invalid credentials')
    }

    //Verificando se o span Required ta visível no campo username
    isRequiredUsernameVisible() {
        cy.get("[name='username']").parent().siblings('span').should('have.text', 'Required')
    }

    //Verificando se o span Required ta visível no campo password
    isRequiredPasswordVisible() {
        cy.get("[name='password']").parent().siblings('span').should('have.text', 'Required')
    }

    //Clicando no link de esqueceu a senha
    clicarForgotPassword() {
        cy.get('[class="oxd-text oxd-text--p orangehrm-login-forgot-header"]').click()
    }

    //Verificando se o título da tela após o envio do usuário para resetar a senha é igual ao que recebe na variável do método
    isTitleForgotPassHaveText(text) {
        cy.get('[class="oxd-text oxd-text--h6 orangehrm-forgot-password-title"]').should('have.text', text)
    }

    //Clicar no ícone de cancelar da tela de esqueceu a senha
    clicarCancelarForgotPass() {
        cy.get('[class="oxd-button oxd-button--large oxd-button--ghost orangehrm-forgot-password-button orangehrm-forgot-password-button--cancel"]')
            .click()
    }

    //Verificando se a tela de login está visível
    isTelaLoginVisible() {
        cy.get('[class="oxd-text oxd-text--h5 orangehrm-login-title"]').should('be.visible')
    }

    //Escrever no campo de username da tela de esqueceu a senha
    digitarUsernameForgotPass(username) {
        cy.get('[name="username"]').type(username)
    }

    //Clicar no botão de resetar senha da tela de esqueceu a senha
    clicarResetPass() {
        cy.get('.orangehrm-forgot-password-button--reset').click()
    }

    //Verificando se o span Required aparece no campo username da tela de esqueceu a senha
    isRequiredUsernameForgotPassVisible() {
        cy.get("[name='username']").parent().siblings('span').should('have.text', 'Required')
    }
}

// Exporta a classe para uso dos métodos nos testes
export default new LoginPage