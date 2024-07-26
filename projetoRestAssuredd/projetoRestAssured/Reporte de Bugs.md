# BUG REPORT

## DEF-001 - Realizar GET em https://fakestoreapi.com/products/b resulta em código 200 e sem body

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-003
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional
- Dados de teste:

Descrição da falha: 
Ao realizar a requisição GET de um produto utilizando uma letra no lugar do id no endpoint 'https://fakestoreapi.com/products/b' resulta em código 200 e sem body.

Evidências:

![image](https://github.com/user-attachments/assets/5985f547-f7df-4060-a420-2793e1b65d10)

Resultado esperado: Deve resultar em código 404 e aparecer a mensagem no body: cart id should be provided.

Resultado real: resulta em código 200 para a requisição inválida e sem body.

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-003.

## DEF-002 - Realizar GET em https://fakestoreapi.com/products/0 resulta em código 200 e sem body

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-006
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional
- Dados de teste:

Descrição da falha: 
Ao realizar a requisição GET de um produto utilizando o id '0' no endpoint 'https://fakestoreapi.com/products/0' resulta em código 200 e sem body.

Evidências:

![image](https://github.com/user-attachments/assets/d40e15dd-246b-47e2-bb4e-ca215ec9772a)


Resultado esperado: Deve resultar em código 400 e aparecer no body do resultado: Cannot GET /product/0

Resultado real: Resulta em código 200 para a requisição com 0 e sem body

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-006

## DEF-003 - Realizar GET em https://fakestoreapi.com/products/categories não mostra a categoria 'Sports'

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-011
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional
- Dados de teste:

Descrição da falha: 
Ao realizar a requisição GET das categorias'https://fakestoreapi.com/products/categories' a categoria 'Sports' não aparece no corpo.

Evidências:

![image](https://github.com/user-attachments/assets/ac706c11-d774-4766-9e0a-d624b3ef9fe4)

Resultado esperado: Deve resultar em código 200 e mostrar as categorias: electronics, sports, jewelery, men's clothing e women's clothing.

Resultado real: Aparece as outras categorias, mas não aparece a categoria 'Sports'.

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-011

## DEF-004 - 

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional
- Dados de teste:

Descrição da falha: 


Evidências:



Resultado esperado: 

Resultado real: 

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-

## DEF-005 - 

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional
- Dados de teste:

Descrição da falha: 


Evidências:



Resultado esperado: 

Resultado real: 

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-

## DEF-006 - 

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional
- Dados de teste:

Descrição da falha: 


Evidências:



Resultado esperado: 

Resultado real: 

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-

## DEF-007 - 

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional
- Dados de teste:

Descrição da falha: 


Evidências:



Resultado esperado: 

Resultado real: 

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-

## DEF-008 - 

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional
- Dados de teste:

Descrição da falha: 


Evidências:



Resultado esperado: 

Resultado real: 

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-

## DEF-009 - 

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional
- Dados de teste:

Descrição da falha: 


Evidências:



Resultado esperado: 

Resultado real: 

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-

## DEF-010 - 

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional
- Dados de teste:

Descrição da falha: 


Evidências:



Resultado esperado: 

Resultado real: 

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-
