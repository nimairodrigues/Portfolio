//Ativa os comandos do Cypress no código
/// <reference types="cypress" />

//Classe de Page contendo os métodos de interação com a tela de login
class AdminPage {
    
    //Clicar no botão pra adicionar um novo usuário
    clicarBotaoNovoUsuario() {
        cy.get('[class="oxd-button oxd-button--medium oxd-button--secondary"]').click()
    }

    //Selecionar a Role pela ordem numérica
    selectRoleNumOption(numOption) {
        //Clicando no select
        cy.get('[class="oxd-select-text oxd-select-text--active"]:eq(0)').click()
        //Clicando na opção pela ordem recebida pelo método
        cy.get("[class='oxd-select-dropdown --positon-bottom'] div:eq("+numOption+")").click()
    }

    //Digitar no campo de Employee Name
    digitarEmployeeName(name) {
        //Aqui eu coloquei pra digitar apenas a letra A, pois ele vai pesquisar algum nome que contenha a letra A e vai mostrar na lista
        //Os nomes dessa lista sempre vão mudar de acordo com o uso dos outros usuários, por isso deixei pra pesquisar a letra A
        //De forma que quase sempre terá nomes nessa lista que contenham a letra.
        
        //Digitando no campo de Employee Name
        cy.get('[class="oxd-autocomplete-wrapper"] input').type(name)
        //usei como tempo de espera, para esperar até o div que contenha searching não exista para continuar o fluxo
        cy.get('[class="oxd-autocomplete-wrapper"] > div:eq(1) > div:contains("Searching...")').should('not.exist')
        //Clicando na primeira opção que aparecer
        cy.get('[class="oxd-autocomplete-wrapper"] > div:eq(1) > div:eq(0)').click()
    }

    //Selecionar o Status da conta pelo nome da opção, Enabled ou Disabled
    selectStatusNameOption(nameOption) {
        //Clicando no select de status
        cy.get('[class="oxd-select-text oxd-select-text--active"]:eq(1)').click()
        //Clicando na opção de acordo com o que foi recebido pelo método
        cy.get("[class='oxd-select-dropdown --positon-bottom'] div:contains("+nameOption+")").click()
    }

    //Digitar no campo de username
    digitarUsername(username) {
        // Gera número único com os 3 últimos dígitos do timestamp atual
        //Para dificultar que o teste tente criar um usuário que já exista
        const numeroUnico = Date.now().toString().slice(-3);
        // Busca o primeiro input ativo dentro da grade de formulário
        //e escreve no campo de username com o número único após limpar o campo
        cy.get('[class="oxd-grid-2 orangehrm-full-width-grid"]').first().find('input[class="oxd-input oxd-input--active"]').clear().type(username + numeroUnico)
        //vai retornar o username escrito junto com o número único para uso em outros testes
        cy.wrap(username + numeroUnico).as('usernameEscrito')
    }

    //Digitar no campo de password
    digitarPassword(password) {
        //Escrevendo no campo de password
        cy.get('[class="oxd-form-row user-password-row"] [class="oxd-grid-item oxd-grid-item--gutters user-password-cell"] input').type(password)
    }

    //Digitar no campo de confirmação de password
    digitarConfirmPassword(confirmPassword) {
        //Escrevendo no campo de confirmação de password
        cy.get('[class="oxd-form-row user-password-row"] [class="oxd-grid-item oxd-grid-item--gutters"] input').type(confirmPassword)
    }

    //Clicar no botão de salvar para adicionar o usuário
    clicarSalvar() {
        //Clicando no botão de salvar
        cy.get('button:contains("Save")').click()
    }

    //Verificando se a mensagem do toast contain o texto recebido no método
    msgToastContains(textoToast) {
        cy.get('[class="oxd-toast-container oxd-toast-container--bottom"]').should('contain', textoToast)
    }

    //Método para criar um usuário, recebendo o nome do empregado
    //status da conta, username e password
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

    //Método para clicar no ícone de apagar o usuário criado, recebendo o alias do username criado
    clicarApagarUser(username) {
        cy.get(".oxd-table-body .oxd-table-card:contains('"+username+"') i[class='oxd-icon bi-trash']").click()
    }

    //Clicar no botão de confirmar para apagar o usuário
    clicarConfirmApagarUser() {
        cy.get("[class='oxd-dialog-container-default--inner'] [class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']").click()
    }

    //Método para clicar no ícone de editar o usuário criado, recebendo o alias do username criado
    clicarEditarUser(username) {
        cy.get(".oxd-table-body .oxd-table-card:contains('"+username+"') i[class='oxd-icon bi-pencil-fill']").click()
    }

    //Verificando se o span do campo username tem o texto recebido no método
    textSpanUsernameShouldBe(textSpan) {
        cy.get('[class="oxd-grid-2 orangehrm-full-width-grid"]:eq(0) [class="oxd-input-group oxd-input-field-bottom-space"]:eq(3) span')
            .should('have.text', textSpan)
    }

    //Verificando se o span do campo password contém o texto recebido no método
    textSpanPasswordShouldBe(textSpan) {
        cy.get('[class="oxd-form-row user-password-row"] [class="oxd-grid-item oxd-grid-item--gutters user-password-cell"]:eq(0) span')
            .should('contain', textSpan)
    }

    //Verificando se o span do campo confirm password tem o texto recebido no método
    textSpanConfirmPassShouldBe(textSpan) {
        cy.get('[class="oxd-form-row user-password-row"] [class="oxd-grid-item oxd-grid-item--gutters"] span').should('have.text', textSpan)
    }

    //Verificando se o span do select status tem o texto recebido no método
    textSpanStatusShouldBe(textSpan) {
        cy.get('[class="oxd-form-row"] > div > div:eq(2) span').should('have.text', textSpan)
    }

    //Verificando se o span do select User Role tem o texto recebido no método
    textSpanUserRoleShouldBe(textSpan) {
        cy.get('[class="oxd-form-row"] > div > div:eq(0) span').should('have.text', textSpan)
    }

    //Verificando se o span do campo employee name tem o texto recebido no método
    textSpanEmployeeNameShouldBe(textSpan) {
        cy.get('[class="oxd-form-row"] > div > div:eq(0) span').should('have.text', textSpan)
    }

    //selecionar o user role do filtro através do nome da role
    selectFilterUserRole(roleName) {
        //Clicando no select
        cy.get('[class="oxd-select-text oxd-select-text--active"]:eq(0)').click()
        //Clicando na opção de acordo com o nome da role
        cy.get("[class='oxd-select-dropdown --positon-bottom'] div:contains("+roleName+")").click()
    }

    //Clicar no botão de Search
    clicarBotaoSearch() {
        //antes de fazer a requisição que é após o click, foi necessário adicionar um intercept pra ele capturar a requisição e posteriormente
        //colocar um wait nessa requisição para que ele possa continuar os testes após esse get (os testes são muito rápidos e não tava dando
        //tempo para carregar a lista)
        cy.intercept('GET', '/web/index.php/api/v2/admin/users?limit=50&offset=0&userRoleId=1&sortField=u.userName&sortOrder=ASC')
            .as('getUsersList')
        //Clicando no botão de search
        cy.get('[class="oxd-table-filter-area"] [type="submit"]').click()
    }

    //Verifica se na tabela contém apenas a user role recebida no método
    verificarUserRoleTable(role) {
        //Aguardando a requisição getUsersList ser feita para continuar o fluxo
        cy.wait('@getUsersList')

        //verificando se a tabela contém apenas usuários da role recebida pelo método
        cy.get(".oxd-table .oxd-table-body div[role='row'] > [class='oxd-table-cell oxd-padding-cell']:nth-child(3)").each($el => {
            cy.wrap($el).should('have.text', role)
        })
    }
}

// Exporta a classe para uso dos métodos nos testes
export default new AdminPage