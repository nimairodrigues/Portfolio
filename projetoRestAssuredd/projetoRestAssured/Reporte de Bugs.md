# BUG REPORT

## DEF-001 - Realizar GET em https://fakestoreapi.com/products/b resulta em código 200 e sem body

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-003
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional

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

Descrição da falha: 
Ao realizar a requisição GET das categorias 'https://fakestoreapi.com/products/categories' a categoria 'Sports' não aparece no corpo.

Evidências:

![image](https://github.com/user-attachments/assets/ac706c11-d774-4766-9e0a-d624b3ef9fe4)

Resultado esperado: Deve resultar em código 200 e mostrar as categorias: electronics, sports, jewelery, men's clothing e women's clothing.

Resultado real: Aparece as outras categorias, mas não aparece a categoria 'Sports'.

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-011

## DEF-004 - o sistema está permitindo criar produto com categoria inexistente

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-022
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional

Body enviado:
```
{
    "title": "product fake",
    "price": 11.2,
    "description": "lorem ipsum set",
    "image": "productFake.jpg",
    "category": "games"
}
```
Descrição da falha: 
Ao realizar a requisição POST para criar um produto novo com categoria inexistente 'https://fakestoreapi.com/products' o produto é criado normalmente mesmo com a categoria inexistente, resultando em código 200.

Evidências:

![image](https://github.com/user-attachments/assets/1a59c2a7-2923-4c3c-adcd-367efccd3457)

Resultado esperado: Deve resultar em código 400 e aparecer no body do resultado “Category doesnt exist.”

Resultado real: Permitiu criar com sucesso, resultando em código 200.

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-022

## DEF-005 - O sistema está permitindo criar produto sem preço.

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-024
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional

Body enviado:
```
{
    "title": "spider t-shirt",
    "price": "",
    "description": "lorem ipsum set",
    "image": "spidertshirt.jpg",
    "category": "Men’s clothing"
}
```

Descrição da falha: 
O sistema está permitindo criar um novo produto sem preço ao realizar requisição POST no endpoint 'https://fakestoreapi.com/products/categories' 

Evidências:

![image](https://github.com/user-attachments/assets/a224c168-644e-4a3b-ba56-ace1996b16e5)

Resultado esperado: Deve resultar em código 400 e aparecer no body do resultado “Price cannot be empty.”

Resultado real: O sistema permite a criação do produto sem preço, resultando em código 200.

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-024

## DEF-006 - O Sistema permite a criação de produto com preço negativo

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-025
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional

Body enviado:
```
{
    "title": "spider t-shirt",
    "price": -11.2,
    "description": "lorem ipsum set",
    "image": "spidertshirt.jpg",
    "category": "Men’s clothing"
}
```

Descrição da falha: 
O sistema permite a criação de produto com preço negativo ao realizar requisição POST no endpoint 'https://fakestoreapi.com/products'

Evidências:

![image](https://github.com/user-attachments/assets/32376893-efe4-48fc-ac8c-1d1280d37914)

Resultado esperado: Deve resultar em código 400 e aparecer no body do resultado “Invalid price”

Resultado real: O sistema permite a criação com sucesso resultando em código 200.

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-025

## DEF-007 - O Sistema permite a atualização do preço de um produto para 0

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-041
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional

Body enviado:
```
{
    "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst",
    "price": 0,
    "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
    "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
    "category": "Men’s clothing"
}
```

Descrição da falha: 
O sistema permite a atualização de produto para o preço 0 ao realizar requisição PUT no endpoint 'https://fakestoreapi.com/products/1'

Evidências:

![image](https://github.com/user-attachments/assets/1420e178-4fe4-43ef-bc7b-81420094c2a9)

Resultado esperado: Deve resultar em código 400 e aparecer no body do resultado “Invalid price”

Resultado real: O sistema permitiu atualizar o preço do produto para 0 com sucesso, resultando em código 200.

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-041

## DEF-008 - O sistema está permitindo a atualização do título de um produto contendo a quantidade de caracteres maior do que o permitido.

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-046
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional

Body enviado:
```
{
    "title": "Apple MacBook Pro 13-inch M1 Chip with 8-Core CPU and 8-Core GPU, 16GB RAM, 512GB SSD - Space Gray",
    "price": 109.95,
    "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
    "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
    "category": "Men’s clothing"
}
```

Descrição da falha: 
O sistema permite a atualização do título de um produto contendo a quantidade de caracteres maior que o permitido (90) ao realizar a requisição PUT no endpoint 'https://fakestoreapi.com/products/1'

Evidências:

![image](https://github.com/user-attachments/assets/cb206b4f-e954-4c30-ac07-eb414f8fc1cd)

Resultado esperado: Deve resultar em código 400 e aparecer no body do resultado “Maximum number of characters reached.”

Resultado real: O sistema permitiu a criação com sucesso, resultando em código 200.

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-046

## DEF-009 - Sistema permitindo a atualização de produto sem imagem

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-052
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional

Body enviado:
```
{
    "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptopst",
    "price": 109.95,
    "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
    "image": "",
    "category": "Men’s clothing"
}
```

Descrição da falha: 
O sistema está permitindo a atualização de um produto sem imagem ao realizar ao realizar a requisição PUT no endpoint 'https://fakestoreapi.com/products/1' 

Evidências:

![image](https://github.com/user-attachments/assets/a336a2ec-16c2-4886-80bc-45dfc2f366dc)

Resultado esperado: Deve resultar em código 400 e aparecer no body do resultado “Image cannot be empty.”

Resultado real: O sistema permitiu a atualização com sucesso de um produto sem imagem, resultando em código 200.

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-052

## DEF-010 - Sistema resulta em código 200 e body null ao tentar deletar produto 0

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-064
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional

Descrição da falha: 
O sistema resulta em código 200 e body null ao tentar deletar um produto 0 quando realizado a requisição DELETE no endpoint 'https://fakestoreapi.com/products/0' 

Evidências:

![image](https://github.com/user-attachments/assets/e5403889-e295-4b0e-a8d2-4141c74415d9)


Resultado esperado: Deve resultar em código 404 e aparecer no body do resultado: Cannot DELETE /product/0

Resultado real: Resulta em código 200 e body 'null'

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-064

## DEF-011 - Sistema resulta em código 400 ao tentar deletar produto utilizando no id uma letra

Objeto de Teste: https://fakestoreapi.com

Ambiente de Teste: Ambiente de desenvolvimento.

Contexto do defeito:
- Caso de teste: CT-066
- Atividade de teste: Teste de sistema
- Fase do SDLC: Desenvolvimento
- Tipo de teste: Teste funcional

Descrição da falha: 
Sistema resulta em código 400 ao tentar DELETAR um produto colocando no ID uma letra realizado a requisição DELETE no endpoint 'https://fakestoreapi.com/products/a' 

Evidências:

![image](https://github.com/user-attachments/assets/808d2ed9-91ce-4ca1-a098-bde8213e73e9)

Resultado esperado: Deve resultar em código 404

Resultado real: Sistema resulta em código 400

Severidade do defeito: Baixa.

Status do defeito: Aberto.

Referências: Caso de teste CT-066

