/// <reference types="cypress" />

class AdminPage {
    
    clicarBotaoNovoUsuario() {
        cy.get('[class="oxd-button oxd-button--medium oxd-button--secondary"]').click()
    }

    selectRoleNumOption(numOption) {
        cy.get('[class="oxd-select-text oxd-select-text--active"]:eq(0)').click()
        cy.get("[class='oxd-select-dropdown --positon-bottom'] div:eq("+numOption+")").click()
    }

    digitarEmployeeName(name) {
        cy.get('[class="oxd-autocomplete-wrapper"] input').type(name)
        //usei como tempo de espera, para esperar até o div que contenha searching não exista para continuar o fluxo
        cy.get('[class="oxd-autocomplete-wrapper"] > div:eq(1) > div:contains("Searching...")').should('not.exist')
        cy.get('[class="oxd-autocomplete-wrapper"] > div:eq(1) > div:eq(0)').click()
    }

    selectStatusNameOption(nameOption) {
        cy.get('[class="oxd-select-text oxd-select-text--active"]:eq(1)').click()
        cy.get("[class='oxd-select-dropdown --positon-bottom'] div:contains("+nameOption+")").click()
    }

    digitarUsername(username) {
        const numeroUnico = Date.now().toString().slice(-3);
        cy.get('[class="oxd-grid-2 orangehrm-full-width-grid"]').first().find('input[class="oxd-input oxd-input--active"]').clear().type(username + numeroUnico)
        return username + numeroUnico
    }

    digitarPassword(password) {
        cy.get('[class="oxd-form-row user-password-row"] [class="oxd-grid-item oxd-grid-item--gutters user-password-cell"] input').type(password)
    }

    digitarConfirmPassword(confirmPassword) {
        cy.get('[class="oxd-form-row user-password-row"] [class="oxd-grid-item oxd-grid-item--gutters"] input').type(confirmPassword)
    }

    clicarSalvar() {
        cy.get('button:contains("Save")').click()
    }

    clicarApagarUserQualquer() {
        const a = cy.get('.oxd-table .oxd-table-body > div:eq(0 > div > div:eq(1) > div').invoke('text')
        console.log(a)
    }

    msgToastContains(textoToast) {
        cy.get('[class="oxd-toast-container oxd-toast-container--bottom"]').should('contain', textoToast)
    }

    criarUser(employeeName, statusOption, username, password) {
        this.clicarBotaoNovoUsuario()
        this.selectRoleNumOption(1)
        this.digitarEmployeeName(employeeName)
        this.selectStatusNameOption(statusOption)
        this.digitarUsername(username)
        this.digitarPassword(password)
        this.digitarConfirmPassword(password)
        this.clicarSalvar()
        cy.get('[class="oxd-toast-container oxd-toast-container--bottom"]').should('be.visible')
    }

    clicarApagarUser(username) {
        let linhaIndex = -1
        let index = -1
        cy.get(".oxd-table .oxd-table-body div[role='row'] > [class='oxd-table-cell oxd-padding-cell']:nth-child(2)").each($el => {
            index++
            console.log("Linha: " + index + " " + ($el.text() === username))
            if($el.text() === username) {
                linhaIndex = index
            }
        }).then(() => {
            //se eu deixar esse cara fora do then() ele me retorna o último elemento da linha da tabela
            cy.get(".oxd-table .oxd-table-body div[role='row'] > [class='oxd-table-cell oxd-padding-cell']:nth-child(6):eq("+linhaIndex+") i[class='oxd-icon bi-trash']").click()
        })
    }

    clicarConfirmApagarUser() {
        cy.get("[class='oxd-dialog-container-default--inner'] [class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']").click()
    }

    clicarEditarUser(username) {
        let linhaIndex = -1
        let index = -1
        cy.get(".oxd-table .oxd-table-body div[role='row'] > [class='oxd-table-cell oxd-padding-cell']:nth-child(2)").each($el => {
            index++
            console.log("Linha: " + index + " " + ($el.text() === username))
            if($el.text() === username) {
                linhaIndex = index
            }
        }).then(() => {
            //se eu deixar esse cara fora do then() ele me retorna o último elemento da linha da tabela
            cy.get(".oxd-table .oxd-table-body div[role='row'] > [class='oxd-table-cell oxd-padding-cell']:nth-child(6):eq("+linhaIndex+") i[class='oxd-icon bi-pencil-fill']").click()
        })
    }

    textSpanUsernameShouldBe(textSpan) {
        cy.get('[class="oxd-grid-2 orangehrm-full-width-grid"]:eq(0) [class="oxd-input-group oxd-input-field-bottom-space"]:eq(3) span')
            .should('have.text', textSpan)
    }

}

export default new AdminPage