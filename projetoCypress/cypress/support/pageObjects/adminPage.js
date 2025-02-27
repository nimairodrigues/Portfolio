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
        const numeroUnico = Date.now().toString().slice(-6);
        cy.get('[class="oxd-grid-2 orangehrm-full-width-grid"]').first().find('input[class="oxd-input oxd-input--active"]').type(username + numeroUnico)
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

    pegarColuna4(string) {
        let colunaIndex = 0
        cy.get(".oxd-table .oxd-table-header > div > div").each($el => {
            colunaIndex++ 
            console.log("Coluna: " + colunaIndex + "\n Element: " + $el.text().includes(string))
        })
    }

    apagarUser1(username) {
        let linhaIndex = -1
        let index = -1
        cy.get(".oxd-table .oxd-table-body div[role='row'] > [class='oxd-table-cell oxd-padding-cell']:nth-child(2)").each($el => {
            index++
            if($el.text().includes(username)) {
                linhaIndex = index
            }
            // console.log('Linha: ' + linhaIndex + '\n Element: ' + $el.text().includes(username))
            console.log('Linha: ' + linhaIndex + '\n Element: ' + $el.text())
        }).then(() => {
            cy.get(".oxd-table .oxd-table-body div[role='row'] > [class='oxd-table-cell oxd-padding-cell']:nth-child(6):eq("+linhaIndex+") i[class='oxd-icon bi-trash']").then(el => {
                console.log(el)
            })
        })
    }

    apagarUser(username) {
        let linhaIndex = -1
        let index = -1
        cy.get(".oxd-table .oxd-table-body div[role='row'] > [class='oxd-table-cell oxd-padding-cell']:nth-child(2)").each($el => {
            index++
            console.log("Linha: " + index + " " + ($el.text() === username))
            if($el.text() === username) {
                linhaIndex = index
            }
        }).then(() => {
            cy.get(".oxd-table .oxd-table-body div[role='row'] > [class='oxd-table-cell oxd-padding-cell']:nth-child(6):eq("+linhaIndex+") i[class='oxd-icon bi-trash']").then(el => {
                console.log(el)
            }).click()
        })
    }

}

export default new AdminPage