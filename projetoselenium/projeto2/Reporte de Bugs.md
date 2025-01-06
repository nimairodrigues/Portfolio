# Relatório de Bugs

---

## Bug 001 - Campo "Nome" não é marcado como obrigatório na tela de cadastro

### **Data da Anomalia Encontrada**  
12/11/2024

### **Organização Emissora**  
Quality Assurance LTDA.

### **Autor e Cargo**  
Nimai Rodrigues, Analista de Testes (QA)

### **Objeto de Teste**  
Formulário da tela de Cadastro

### **Ambiente de Teste**  
- **Sistema Operacional:** Windows 10 Pro (64-bit) Version 22H2  
- **Navegador:** Microsoft Edge Version 131.0.2903.70 (Official build) (64-bit)

### **Contexto do Defeito**  
Ao acessar a tela de cadastro e clicar no botão "Cadastrar" sem preencher os campos, o sistema não exibe uma mensagem informando que o campo "Nome" é obrigatório.

### **Descrição da Falha**  
#### **Passo a Passo**  
1. Acessar o sistema [bugbank.netlify.app](https://bugbank.netlify.app).  
2. Clicar no botão **"Registrar"**.  
3. Clicar no botão **"Cadastrar"**.  

#### **Resultado Esperado**  
O sistema deve informar ao usuário que o campo "Nome" é obrigatório e impedir o envio do formulário enquanto o campo não for preenchido.

#### **Resultado Obtido**  
O sistema permite a submissão do formulário sem preencher o campo "Nome", sem exibir mensagens de validação.

### **Severidade do Defeito**  
**Média**  
*O defeito permite a criação de usuários sem nome, comprometendo a integridade dos dados.*

### **Prioridade de Correção**  
**Média**

### **Status do Defeito**  
**Em Aberto**

### **Evidências**  
[Link para evidência](https://github.com/user-attachments/assets/9cbb16cb-0ebd-4221-9d09-3a410c2b3149)

### **Referências**  
Caso de Teste CT-001

---

## Bug 002 - Sistema informando de forma incorreta que o campo "Nome" deve estar preenchido

### **Data da Anomalia Encontrada**  
12/11/2024

### **Organização Emissora**  
Quality Assurance LTDA.

### **Autor e Cargo**  
Nimai Rodrigues, Analista de Testes (QA)

### **Objeto de Teste**  
Formulário da tela de Cadastro

### **Ambiente de Teste**  
- **Sistema Operacional:** Windows 10 Pro (64-bit) Version 22H2  
- **Navegador:** Microsoft Edge Version 131.0.2903.70 (Official build) (64-bit)

### **Contexto do Defeito**  
Estando na tela de Cadastro, ao preencher outros dados exceto o "Nome" e clicar em "Cadastrar" o sistema exibe uma caixa de mensagem informando que o campo "Nome" não pode ser vazio.

### **Descrição da Falha**  
#### **Passo a Passo**  
1. Acessar o sistema [bugbank.netlify.app](https://bugbank.netlify.app).  
2. Clicar no botão **"Registrar"**.  
3. Preencher o campo "E-mail" com um e-mail válido.
4. Preencher o campo "Senha" com uma senha válida.
5. Preencher o campo "Confirmação senha" com uma senha válida.
6. Clicar no botão **"Cadastrar"**.

#### **Resultado Esperado**  
O sistema deveria informar que o campo "Nome" não pode ser vazio embaixo do próprio campo em vermelho.

#### **Resultado Obtido**  
O sistema informa que o campo "Nome" não pode ser vazio abrindo uma caixa de texto.

### **Severidade do Defeito**  
**Baixa**  

### **Prioridade de Correção**  
**Baixa**  

### **Status do Defeito**  
**Em Aberto**

### **Evidências**  

https://github.com/user-attachments/assets/e00997ce-639b-4d1f-917d-65ba091afedd

### **Referências**  
Caso de Teste CT-011.

---

## Bug 003 - Sistema permitindo a transferência de valores sem dados

### **Data da Anomalia Encontrada**  
12/11/2024

### **Organização Emissora**  
Quality Assurance LTDA.

### **Autor e Cargo**  
Nimai Rodrigues, Analista de Testes (QA)

### **Objeto de Teste**  
Tela de transferência.

### **Ambiente de Teste**  
- **Sistema Operacional:** Windows 10 Pro (64-bit) Version 22H2  
- **Navegador:** Microsoft Edge Version 131.0.2903.70 (Official build) (64-bit)

### **Contexto do Defeito**  
Na tela de transferência, ao tentar enviar valores sem nenhum dado clicando em "Transferir agora", os campos "Número da conta", "Dígito" e "Descrição" não estão obrigatórios, permitindo o envio de valores sem preencher estes campos.

### **Descrição da Falha**  
#### **Passo a Passo**  
1. Acessar o sistema [bugbank.netlify.app](https://bugbank.netlify.app).  
2. Digitar no campo "E-mail" um e-mail válido.
3. Digitar no campo "Senha" a senha válida correspondente.
4. Clicar no botão "Acessar"
5. Clicar no botão de "Transferência"
6. Clicar no botão "Transferir agora"

#### **Resultado Esperado**  
O sistema deveria informar que os campos "Número da conta", "Dígito" e "Descrição" são obrigatórios e impedindo de finalizar a transferência.

#### **Resultado Obtido**  
O sistema não está bloqueando o envio de valores com os campos "Número da conta", "Dígito" e "Descrição" vazios.

### **Severidade do Defeito**  
**Média**  

### **Prioridade de Correção**  
**Média**  

### **Status do Defeito**  
**Em aberto**

### **Evidências**  

https://github.com/user-attachments/assets/21a83e15-80f1-4631-a48f-434839f0dc4a

### **Referências**  
Caso de Teste CT-014.

---

## Bug 004 - Sistema permitindo transferir valores sem preencher dados da conta

### **Data da Anomalia Encontrada**  
12/11/2024

### **Organização Emissora**  
Quality Assurance LTDA.

### **Autor e Cargo**  
Nimai Rodrigues, Analista de Testes (QA)

### **Objeto de Teste**  
Formulário da tela de Cadastro

### **Ambiente de Teste**  
- **Sistema Operacional:** Windows 10 Pro (64-bit) Version 22H2  
- **Navegador:** Microsoft Edge Version 131.0.2903.70 (Official build) (64-bit)

### **Contexto do Defeito**  
O sistema está permitindo a transferência de valores sem preencher os dados da conta a ser transferida.

### **Descrição da Falha**  
#### **Passo a Passo**  
1. Acessar o sistema [bugbank.netlify.app](https://bugbank.netlify.app).  
2. Digitar no campo "E-mail" um e-mail válido.
3. Digitar no campo "Senha" a senha válida correspondente.
4. Clicar no botão "Acessar"
5. Clicar no botão de "Transferência"
6. Digitar no campo "Valor de tranferência" um valor válido.
7. Digitar no campo "Descrição" uma descrição válida.
8. Clicar no botão "Transferir agora"

#### **Resultado Esperado**  
O sistema deveria informar que o campo "Número da conta" e "Dígito" não podem ser vazios embaixo do próprio campo em vermelho.

#### **Resultado Obtido**  
O sistema informa que o campo "Número da conta" e "Dígito" não pode ser vazio abrindo uma caixa de texto.

### **Severidade do Defeito**  
**Média**  

### **Prioridade de Correção**  
**Média**  

### **Status do Defeito**  
**Em aberto**

### **Evidências**  

https://github.com/user-attachments/assets/ed5d0178-c7fc-4cfb-ae31-53560c9edb87

### **Referências**  
Caso de Teste CT-015.

---

## Bug 005 - Mensagem incorreta ao tentar transferir valores sem preencher "Valor da transferência"

### **Data da Anomalia Encontrada**  
12/11/2024

### **Organização Emissora**  
Quality Assurance LTDA.

### **Autor e Cargo**  
Nimai Rodrigues, Analista de Testes (QA)

### **Objeto de Teste**  
Formulário da tela de Cadastro

### **Ambiente de Teste**  
- **Sistema Operacional:** Windows 10 Pro (64-bit) Version 22H2  
- **Navegador:** Microsoft Edge Version 131.0.2903.70 (Official build) (64-bit)

### **Contexto do Defeito**  
Estando na tela de transferência, ao tentar realizar uma transferência sem digitar o valor da transferência, a mensagem que aparece abaixo do campo "Valor da Transferência" está incorreta.

### **Descrição da Falha**  
#### **Passo a Passo**  
1. Acessar o sistema [bugbank.netlify.app](https://bugbank.netlify.app).  
2. Digitar no campo "E-mail" um e-mail válido.
3. Digitar no campo "Senha" a senha válida correspondente.
4. Clicar no botão "Acessar".
5. Clicar no botão de "Transferência".
6. Digitar no campo "Número da conta" um número de conta válido.
7. Digitar no campo "Dígito" um dígito válido correspondente.
8. Digitar no campo "Descrição" uma descrição válida.
9. Clicar no botão "Transferir agora"

#### **Resultado Esperado**  
O sistema deveria exibir "Campo obrigatório" abaixo do campo "Valor da transferência" ao finalizar uma transferência sem o valor preenchido.

#### **Resultado Obtido**  
O sistema exibe uma mensagem incorreta ao finalizar uma transferência sem o valor preenchido.

### **Severidade do Defeito**  
**Baixa**  

### **Prioridade de Correção**  
**Baixa**  

### **Status do Defeito**  
**Em aberto**

### **Evidências**  

https://github.com/user-attachments/assets/1879037c-909f-45f7-8fdd-bb1af2a272bd

### **Referências**  
Caso de Teste CT-016.

---

## Bug 006 - Sistema permitindo digitar letras no campo "Número da conta"

### **Data da Anomalia Encontrada**  
12/11/2024

### **Organização Emissora**  
Quality Assurance LTDA.

### **Autor e Cargo**  
Nimai Rodrigues, Analista de Testes (QA)

### **Objeto de Teste**  
Formulário da tela de Cadastro

### **Ambiente de Teste**  
- **Sistema Operacional:** Windows 10 Pro (64-bit) Version 22H2  
- **Navegador:** Microsoft Edge Version 131.0.2903.70 (Official build) (64-bit)

### **Contexto do Defeito**  
O sistema está permitindo escrever letras e outros caracteres no campo "Número da conta" e finalizar a transferência, com o dinheiro indo pra conta vazia.

### **Descrição da Falha**  
#### **Passo a Passo**  
1. Acessar o sistema [bugbank.netlify.app](https://bugbank.netlify.app).  
2. Digitar no campo "E-mail" um e-mail válido.
3. Digitar no campo "Senha" a senha válida correspondente.
4. Clicar no botão "Acessar".
5. Clicar no botão de "Transferência".
6. Digitar no campo "Número da conta" um número de conta contendo uma letra.
7. Digitar no campo "Dígito" um dígito válido.
8. Digitar no campo "Valor de tranferência" um valor válido.
9. Digitar no campo "Descrição" uma descrição válida.
10. Clicar no botão "Transferir agora"

#### **Resultado Esperado**  
O sistema não deveria permitir digitar letras no campo "Número da conta".

#### **Resultado Obtido**  
O sistema está permitindo digitar letras no campo "Número da conta" e enviar valores.

### **Severidade do Defeito**  
**Média**  

### **Prioridade de Correção**  
**Média**  

### **Status do Defeito**  
**Em aberto**

### **Evidências**  

https://github.com/user-attachments/assets/32a7bcfe-3700-4ef8-854e-10eb6f1ef431

### **Referências**  
Caso de Teste CT-018.

---
