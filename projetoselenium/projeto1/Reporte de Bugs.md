# BUG REPORT

### 1- Mensagem embaixo do campo ID não aparece ao digitar ID 000 <h3>
# 
Código CT: 26

Título: Criar novo empregado com ID "000"

Cenário: PIM

Resultado esperado: Deve aparecer em baixo do campo de Employee ID “ID should not be less than 1” em vermelho!

Resultado atual: Mensagem esperada não aparece em baixo do campo de Employee ID, fazendo com que o empregado seja salvo normalmente mesmo com o ID inválido.

Versão do Monzilla: 122.0 (64bits)

Versão do Sistema: OrangeHRM OS 5.5

Versão do OS: Windows 10 22H2

  Passo a passo:

    1- Digito site no navegador.
    2- Faço login digitando usuário, senha e clicando em logar.
    3- Clico em PIM na barra lateral.
    4- Clico no botão de adicionar empregado.
    5- Adiciono FirstName.
    6- Adiciono LastName.
    7- Adiciono ID 000.
    8- Clico em Salvar.


Evidências: 

![id_26_criarNovoEmpregadoComId000](https://github.com/nimairodrigues/Portfolio/assets/112123854/202c42b9-04fa-47a9-a8d4-e676bdd3240c)

https://github.com/nimairodrigues/Portfolio/assets/112123854/3bc9739d-42fb-4315-ae4f-e171755fd14e

### 2- Mensagem embaixo do campo ID não aparece ao digitar um ID negativo <h3>
Código CT: 27

Título: Criar novo empregado com ID negativo

Cenário: PIM

Resultado esperado: Deve aparecer em baixo do campo de Employee ID “ID should not be less than 1” em vermelho!

Resultado atual: Mensagem esperada não aparece em baixo do campo de Employee ID, fazendo com que o empregado seja salvo normalmente mesmo com o ID inválido.

Versão do Monzilla: 122.0 (64bits)

Versão do Sistema: OrangeHRM OS 5.5

Versão do OS: Windows 10 22H2

  Passo a passo:

    1- Digito site no navegador.
    2- Faço login digitando usuário, senha e clicando em logar.
    3- Clico em PIM na barra lateral.
    4- Clico no botão de adicionar empregado.
    5- Adiciono FirstName.
    6- Adiciono LastName.
    7- Adiciono ID negativo.
    8- Clico em Salvar.

Evidências:

![id_27_criarNovoEmpregadoComIdNegativo](https://github.com/nimairodrigues/Portfolio/assets/112123854/aa467387-502d-45ae-9be2-489359f1d962)

https://github.com/nimairodrigues/Portfolio/assets/112123854/ed8155fb-4b34-4661-849a-3e21baed56ba

### 3- Mensagem embaixo do campo ID não aparece ao clicar em salvar sem digitar ID <h3>
Código CT: 28

Título: Criar novo empregado sem ID

Cenário: PIM

Resultado esperado: Deve aparecer em baixo do campo de Employee ID “Required” em vermelho.

Resultado atual: Mensagem esperada não aparece em baixo do campo de Employee ID, fazendo com que o empregado seja salvo normalmente mesmo sem ID.

Versão do Monzilla: 122.0 (64bits)

Versão do Sistema: OrangeHRM OS 5.5

Versão do OS: Windows 10 22H2

  Passo a passo:

    1- Digito site no navegador.
    2- Faço login digitando usuário, senha e clicando em logar.
    3- Clico em PIM na barra lateral.
    4- Clico no botão de adicionar empregado.
    5- Adiciono FirstName.
    6- Adiciono LastName.
    7- Clico em Salvar.

Evidências:

![id_28_criarNovoEmpregadoSemId](https://github.com/nimairodrigues/Portfolio/assets/112123854/c29e1058-4305-4713-9de4-182eb7648ee7)

https://github.com/nimairodrigues/Portfolio/assets/112123854/7e240531-57cf-40a2-a9b6-e26ff1f52a97


