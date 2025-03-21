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

    clicarCreateLoginDetails() {
        cy.get('[class="oxd-form-row user-form-header"] > div').click()
        cy.get('[class="oxd-form-row user-password-row"]').should('be.visible')
    }

    digitarUsername(username) {
        const numeroUnico = Date.now().toString().slice(-3);
        cy.get('[class="oxd-form-row"]:eq(1) [class="oxd-input oxd-input--active"]').clear().type(username + numeroUnico)
    }

    digitarPassword(password) {
        cy.get('[class="oxd-form-row user-password-row"] [type=password]:eq(0)').type(password)
    }

    digitarConfirmPassword(confirmPass) {
        cy.get('[class="oxd-form-row user-password-row"] [type=password]:eq(1)').type(confirmPass)
    }

    textSpanUsernameShouldBe(spanMsg) {
        cy.get('[class="oxd-form-row"]:eq(1)  [class="oxd-grid-item oxd-grid-item--gutters"]:eq(0) span').should('contain', spanMsg)
    }

    textSpanPasswordShouldBe(spanMsg) {
        cy.get('.user-password-cell span').should('contain', spanMsg)
    }

    textSpanConfirmPassShouldBe(spanMsg) {
        cy.get('[class="oxd-form-row user-password-row"] [class="oxd-grid-item oxd-grid-item--gutters"] span').should('contain', spanMsg)
    }

    clicarHelp() {
        cy.window().then((win) => {
            cy.stub(win, 'open').callsFake((url) => {
              win.location.href = url; // Redireciona na mesma aba
            });
          });
          
        cy.get('[title="Help"] [class="oxd-icon bi-question-lg"]').invoke('removeAttr', 'target').click()
        cy.origin('https://starterhelp.orangehrm.com', () => {
            console.log(cy.title())
            cy.title().should('be.equal', 'How to Add an Employee – OrangeHRM')
          })
    }
    
    typeFilterEmployeeName(employeeName) {
            cy.get('[class="oxd-grid-4 orangehrm-full-width-grid"] > div:eq(0) input').type(employeeName)
            //usei como tempo de espera, para esperar até o div que contenha searching não exista para continuar o fluxo
            cy.get('[class="oxd-grid-4 orangehrm-full-width-grid"] > div:eq(0) [class="oxd-autocomplete-wrapper"] > div:eq(1) > div:contains("Searching...")').should('not.exist')
            cy.get('[class="oxd-grid-4 orangehrm-full-width-grid"] > div:eq(0) [class="oxd-autocomplete-wrapper"] > div:eq(1) > div:eq(0)').click().then($el => {
                // cy.wrap($el).invoke('text').then(textOption => {
                //     console.log('1')
                //     return textOption
                // })
                cy.get('[class="oxd-grid-4 orangehrm-full-width-grid"] > div:eq(0) input').invoke('val').then(text => {
                    return text.slice(0, 5)
                })
            })
    }

    clicarBotaoSearch() {
        //antes de fazer a requisição que é após o click, foi necessário adicionar um intercept pra ele capturar a requisição e posteriormente
        //colocar um wait nessa requisição para que ele possa continuar os testes após esse get (os testes são muito rápidos e não tava dando
        //tempo para carregar a lista)
        //coloquei um asterisco no empNumber, pois ele altera a depender do usuário que foi pesquisado no filtro
        cy.intercept('GET', '/web/index.php/api/v2/pim/employees?limit=50&offset=0&model=detailed&empNumber=*&includeEmployees=onlyCurrent&sortField=employee.firstName&sortOrder=ASC')
            .as('getUsersList')
        cy.get('[class="oxd-table-filter-area"] [type="submit"]').click()
    }

    
    verificarUserRoleTable(role) {
        cy.wait('@getUsersList')
        console.log('2')
        // cy.wrap(role).should('not.be.undefined')
        console.log("esse é o role: " + role)
        cy.get('[class="oxd-table-body"] [class="oxd-table-cell oxd-padding-cell"]:nth-child(3)').then($el => {
            $el.each(() => {
                cy.wrap($el).should('contain', role)
            })
        })
    }

    escreveClicaEVerificaFiltro(employeeName) {
        //Variavel para receber o nome do usuario que sera pesquisado (já que ele é aleatório)
        let te = null

        //Escrever no campo de empregado no filtro
        cy.get('[class="oxd-grid-4 orangehrm-full-width-grid"] > div:eq(0) input').type(employeeName)
        //usei como tempo de espera, para esperar até o div que contenha searching não exista para continuar o fluxo
        cy.get('[class="oxd-grid-4 orangehrm-full-width-grid"] > div:eq(0) [class="oxd-autocomplete-wrapper"] > div:eq(1) > div:contains("Searching...")').should('not.exist')

        //Aqui foi necessário capturar texto do campo de empregado do filtro, para realizar assertiva depois
        cy.get('[class="oxd-grid-4 orangehrm-full-width-grid"] > div:eq(0) [class="oxd-autocomplete-wrapper"] > div:eq(1) > div:eq(0)').click().then($el => {
            cy.wrap($el).invoke('text').then(textOption => {
        //Usei o slice para salvar apenas o inicio da string, pois na tabela é dividido o nome e sobrenome, e no campo de empregado aparece tudo junto, que é o campo que a gente
        // captura o usuário que foi pesquisado
                te = textOption.slice(0, 5)
            })
        }).then(() => {
            this.clicarBotaoSearch() 
            this.verificarUserRoleTable(te)
        })
    }
}

export default new PimPage