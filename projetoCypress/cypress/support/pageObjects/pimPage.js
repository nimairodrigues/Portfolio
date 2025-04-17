//Ativa os comandos do Cypress no código
/// <reference types="cypress" />

import menuPage from "./menuPage"

//Classe de Page contendo os métodos de interação com a tela de login
class PimPage {

    //Clicar no botão para adicionar um novo empregado
    clicarBotaoNovoEmployee() {
        cy.get('[class="oxd-button oxd-button--medium oxd-button--secondary"]').click()
    }
    
    //Digitar no campo firstname
    digitarFirstName(firstName) {
        cy.get('[name="firstName"]').type(firstName)
    }

    //Digitar no campo lastName
    digitarLastName(lastName) {
        cy.get('[name="lastName"]').type(lastName)
    }

    //Clicar no botão para salvar
    clicarBotaoSave() {
        cy.get('[type="submit"]').click()
    }

    //Verificando se a mensagem do toast contain o texto recebido no método
    msgToastContains(textoToast) {
        cy.get('[class="oxd-toast-container oxd-toast-container--bottom"]').should('contain', textoToast)
    }

    //Verificando se o span do campo firstname tem o texto recebido no método
    textSpanFirstNameShouldBe(spanMsg) {
        cy.get('[class="--name-grouped-field"] > div:eq(0) span').should('contain', spanMsg)
    }

    //Verificando se o span do campo lastname tem o texto recebido no método
    textSpanLastNameShouldBe(spanMsg) {
        cy.get('[class="--name-grouped-field"] > div:eq(2) span').should('contain', spanMsg)
    }

    //Digitar no campo de employee ID
    digitarEmployeeId(id) {
        cy.get('[class="oxd-form-row"] > div:eq(1) input').clear().type(id)
    }

    //Verificando se o span do campo Employee ID tem o texto recebido no método
    textSpanEmployeeIdShouldBe(spanMsg) {
        cy.get('[class="oxd-form-row"] > div:eq(1) span').should('contain', spanMsg)
    }

    //Clicar no switch de create login details, para preencher o resto do formulário
    clicarCreateLoginDetails() {
        cy.get('[class="oxd-form-row user-form-header"] > div').click()
        cy.get('[class="oxd-form-row user-password-row"]').should('be.visible')
    }

    //Digitar no campo username de login details
    digitarUsername(username) {
        const numeroUnico = Date.now().toString().slice(-3);
        cy.get('[class="oxd-form-row"]:eq(1) [class="oxd-input oxd-input--active"]').clear().type(username + numeroUnico)
    }

    //Digitar no campo password de login details
    digitarPassword(password) {
        cy.get('[class="oxd-form-row user-password-row"] [type=password]:eq(0)').type(password)
    }

    //Digitar no campo confirm password de login details
    digitarConfirmPassword(confirmPass) {
        cy.get('[class="oxd-form-row user-password-row"] [type=password]:eq(1)').type(confirmPass)
    }

    //Verificando se o span do campo username tem o texto recebido no método
    textSpanUsernameShouldBe(spanMsg) {
        cy.get('[class="oxd-form-row"]:eq(1)  [class="oxd-grid-item oxd-grid-item--gutters"]:eq(0) span').should('contain', spanMsg)
    }

    //Verificando se o span do campo password tem o texto recebido no método
    textSpanPasswordShouldBe(spanMsg) {
        cy.get('.user-password-cell span').should('contain', spanMsg)
    }

    //Verificando se o span do campo confirm password tem o texto recebido no método
    textSpanConfirmPassShouldBe(spanMsg) {
        cy.get('[class="oxd-form-row user-password-row"] [class="oxd-grid-item oxd-grid-item--gutters"] span').should('contain', spanMsg)
    }

    //Clicar no botão de ajuda
    clicarHelp() {
        //Capturando o objeto window do navegador e passa para a função dentro do then
        cy.window().then(win => {
            //Substituindo a função window.open por uma função personalizada
            cy.stub(win, 'open').callsFake(url => {
                //Redireciona para a url na mesma aba (evita abrir nova aba)
                win.location.href = url; 
            });
        });
        
        //Clicando no botão de ajuda
        cy.get('[title="Help"] [class="oxd-icon bi-question-lg"]').click()

        //Mudando o contexto do teste para a página redirecionada
        cy.origin('https://starterhelp.orangehrm.com', () => {
            //Fazendo assertiva em cima do título
            cy.title().should('be.equal', 'How to Add an Employee – OrangeHRM')
        })
    }
    
    //Digitar no campo de Employee Name dos filtros
    typeFilterEmployeeName(employeeName) {
        //Digitando no campo
        cy.get('[class="oxd-grid-4 orangehrm-full-width-grid"] > div:eq(0) input').type(employeeName)
        //usei como tempo de espera, para esperar até o div que contenha searching não exista para continuar o fluxo
        cy.get('[class="oxd-grid-4 orangehrm-full-width-grid"] > div:eq(0) [class="oxd-autocomplete-wrapper"] > div:eq(1) > div:contains("Searching...")').should('not.exist')
        //Clicar na opção do select, aqui vai clicar na primeira opção, já que não faz diferença a escolha
        cy.get('[class="oxd-grid-4 orangehrm-full-width-grid"] > div:eq(0) [class="oxd-autocomplete-wrapper"] > div:eq(1) > div:eq(0)').click()
        //Capturando as 5 primeiras letras do nome selecionado e criando um alias para ele
        cy.get('[class="oxd-grid-4 orangehrm-full-width-grid"] > div:eq(0) input').invoke('val').then(text => {
            cy.wrap(text.slice(0, 5)).as('iniciaisDoNome')
        })
    }

    //Clicar no botão de search
    clicarBotaoSearch() {
        //antes de fazer a requisição que é após o click, foi necessário adicionar um intercept pra ele capturar a requisição e posteriormente
        //colocar um wait nessa requisição para que ele possa continuar os testes após esse get (os testes são muito rápidos e não tava dando
        //tempo para carregar a lista)
        //coloquei um asterisco no empNumber, pois ele altera a depender do usuário que foi pesquisado no filtro
        cy.intercept('GET', '/web/index.php/api/v2/pim/employees?limit=50&offset=0&model=detailed&empNumber=*&includeEmployees=onlyCurrent&sortField=employee.firstName&sortOrder=ASC')
            .as('getUsersList')
        //Clicando no botão de search
        cy.get('[class="oxd-table-filter-area"] [type="submit"]').click()
    }

    //Verificar o nome dos usuários na tabela, se o nome recebido está na tabela
    verifyNameUsersTable(nome) {
        //Aguardando a requisição getUsersList ser feita para continuar o fluxo
        cy.wait('@getUsersList')
        //Verificando n coluna de nome da tabela se há o nome recebido no método
        cy.get('[class="oxd-table-body"] [class="oxd-table-cell oxd-padding-cell"]:nth-child(3)').then($el => {
            $el.each(() => {
                cy.wrap($el).should('contain', nome)
            })
        })
    }

    //Método para criar um novo employee a partir da tela de Dashboard
    criarNovoEmployee(firstName, lastName) {
        menuPage.acessarOpcaoMenu('PIM')
        this.clicarBotaoNovoEmployee()
        this.digitarFirstName(firstName)
        cy.wrap(firstName).as('firstNameUserCreated')
        this.digitarLastName(lastName)
        this.clicarBotaoSave()
        this.msgToastContains('Successfully Saved')
        menuPage.acessarOpcaoMenu('Dashboard')
    }
}

// Exporta a classe para uso dos métodos nos testes
export default new PimPage