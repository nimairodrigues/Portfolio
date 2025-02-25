import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps'
import loginPage from '../../../support/pageObjects/loginPage'

Given('Estou na tela de login', () => {
    cy.visit("https://opensource-demo.orangehrmlive.com")
})

Given('Tenho uma conta válida', () => {

})

When('Eu digito o usuário {string}', (username) => {
    loginPage.digitarUsername(username)
})

When('Eu clico em forgot your password', () => {
    loginPage.clicarForgotPassword()
})

And('Eu digito a senha {string}', (password) => {
    loginPage.digitarPassword(password)
})

And('Clico no botão de login', () => {
    loginPage.clicarLogin()
})

And('Eu clico no botão de Cancelar', () => {
    loginPage.clicarCancelarForgotPass()
})

And('Eu digito no campo de username {string}', (username) => {
    loginPage.digitarUsernameForgotPass(username)
})

And('Eu clico no botão reset password', () => {
    loginPage.clicarResetPass()
})

Then('Eu visualizo a dashboard de usuário', () => {
    loginPage.isDashboardVisible()
})

Then('Deve aparecer mensagem de Invalid Credentials', () => {
    loginPage.isInvalidCredVisible()
})

Then('Deve aparecer required abaixo de username', () => {
    loginPage.isRequiredUsernameVisible()
})

Then('Deve aparecer required abaixo de username em forgot password', () => {
    loginPage.isRequiredUsernameForgotPassVisible()
})

Then('Deve aparecer a tela de esqueceu a senha', () => {
    loginPage.isTitleForgotPassHaveText('Reset Password')
})

Then('Deve aparecer a tela de login', () => {
    loginPage.isTelaLoginVisible()
})

Then('Deve aparecer mensagem confirmando o envio do link no email', () => {
    loginPage.isTitleForgotPassHaveText('Reset Password link sent successfully')
})


And('Deve aparecer required abaixo de password', () => {
    loginPage.isRequiredPasswordVisible()
})
