# BUG REPORT

## Checkbox "Salvar credenciais" não aparece

Identificador exclusivo: DEF-001

Objeto de teste: Tela de Login

Ambiente de teste: Ambiente de Teste

Contexto do defeito:
- Caso de teste: CT-006
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional
- Dados de teste: 

Descrição da falha:
Ao acessar a aplicação, o checkbox de "Salvar credenciais" não aparece

Evidências:

![image](https://github.com/nimairodrigues/Portfolio/assets/112123854/b38bf0a8-e661-4863-81ba-4a07f82f59a8)

https://github.com/nimairodrigues/Portfolio/assets/112123854/29a61162-17ee-45ac-bdca-1856541188c3

Passo a passo:

  1. Acessar aplicação.

Resultados esperados: O checkbox deve aparecer para ser marcado.

Resultados reais: O checkbox não aparece.

Severidade do defeito: Baixa.

Prioridade de correção: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-006.

## Acessar caixa de mensagem de um usuário pelo swipeleft não funciona

Identificador exclusivo: DEF-002

Objeto de teste: Tela de Perfil de Usuário

Ambiente de teste: Ambiente de Teste

Contexto do defeito:
- Caso de teste: CT-016
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional
- Dados de teste: Usuário e senha para log in

Descrição da falha:
Funcionalidade swipeleft para acessar a caixa de mensagem de um perfil escolhido não funciona

Evidências:

![image](https://github.com/nimairodrigues/Portfolio/assets/112123854/7ad2e59c-78ea-4a91-860e-8662ab2f5a78)

https://github.com/nimairodrigues/Portfolio/assets/112123854/acbdd793-fb22-41b9-9d68-1438af145bea

Passo a Passo:

  1. Acessar aplicação.
  2. Realizar Login.
  3. Clicar na Lupa (Botão explorar)
  4. Deve digitar na barra Search “Mark”
  5. Deve clicar no perfil do “Mark”
  6. Deve arrastar a tela para a esquerda

Resultados esperados: Deve aparecer a tela para enviar mensagem para o perfil

Resultados reais: A tela de mensagem não aparece após fazer swipeleft

Severidade do defeito: Baixa.

Prioridade de correção: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-016.
