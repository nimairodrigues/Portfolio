import './commands'

//Melhorando a ordem de prioridade que o Cypress deve seguir para escolher o melhor seletor
Cypress.SelectorPlayground.defaults({
    selectorPriority: ['data-cy', 'data-test', 'data-testid', 'id', 'class', 'attributes', 'tag', 'nth-child'],
})