# Projeto 2: Testes Automatizados com Selenium e Cucumber

Este projeto utiliza **Selenium** e **Cucumber** para a automação de testes em uma aplicação Web.

## Tecnologias Utilizadas

- **Linguagem:** Java 1.8.0_341  
- **Sistema Operacional:** Windows 10 Pro, versão 22H2  
- **IDE:** Eclipse v. 2024-09 (4.33.0)  

## Objeto de Teste

A aplicação web utilizada como objeto de teste está disponível em:  
[BugBank](https://bugbank.netlify.app/)

## Estrutura do Projeto

1. **Plano de Teste:**  
   Disponível em: [Plano de Teste - Google Sheets](https://docs.google.com/spreadsheets/d/1XEPsWp-dhotqv9PFEwrm8MGEMRPnFG7glvQPSX_uEMQ/edit?usp=sharing)  
   Detalhes:
   - Escrito no formato **BDD** utilizando **Gherkin**.
   - Cada caso de teste contém:
     - ID exclusivo.
     - Funcionalidade testada.
     - Cenário (ou título).
     - Prioridade (**Alto**, **Médio**, **Baixo**).
     - Status (**OK**, **NOK**, ou **-** para não testado).
     - Observações.
   - Estrutura dos cenários:
     - **História de Usuário:**
       - **Como...** (Qualidade do usuário acessando o sistema).
       - **Quero...** (Objetivo ao utilizar o sistema).
       - **Para...** (Finalidade do uso do sistema).
     - **Critérios de Aceite:**
       - **Dado...** (Pré-condições para o teste).
       - **Quando...** (Ações realizadas no teste).
       - **Então...** (Resultado esperado).
   - Testes independentes, podendo ser executados em qualquer ordem.

2. **Relatório de Bugs:**  
   Disponível no repositório em:  
   [Reporte de Bugs.md](https://github.com/nimairodrigues/Portfolio/blob/8b2f8a468ab84d550fbf4efe007565d0cee73e64/projetoselenium/projeto2/Reporte%20de%20Bugs.md)  
   Detalhes:
   - Baseado nas recomendações do **BSTQB (CTFL Syllabus 4.0)**.
   - Contém:
     - Identificador exclusivo.
     - Título descritivo.
     - Data, organização emissora e autor.
     - Objeto e ambiente de teste.
     - Contexto do defeito.
     - Descrição da falha com passos detalhados para reprodução.
     - Resultados esperados e obtidos.
     - Severidade e prioridade.
     - Status do defeito.
     - Referências.
   - Inclui evidências como capturas de tela e vídeos.

3. **Codificação dos Testes Automatizados:**  
   Estruturado utilizando o padrão **Page Object Model (POM)** para melhor organização, leitura e manutenibilidade.
   - **Estrutura Principal:**
     - **Driver Factory:** Classe responsável pela criação do driver.
     - **BasePage:** Classe com métodos padrão para interação com as telas (e.g., clicar, digitar).
     - **BaseTest:** Classe com configurações gerais para os testes.
     - **Pages Específicas:** Extensões da `BasePage`, como `LoginPage` para funcionalidades de login.
     - **Testes Específicos:** Extensões da `BaseTest`, como `LoginTest` para validar login.
   - **Cucumber:** Implementação do BDD:
     - **Feature Files:** Arquivos `.feature` que contêm as histórias e critérios de aceite em **Gherkin**.
     - **Step Definitions:** Classes com código de execução dos cenários, utilizando POM e estendendo `BaseTest`.
     - **Runner Classes:** Configuram a execução dos testes com **JUnit**.

---

## Considerações Finais

O projeto utiliza o padrão **Page Object Model** e **Cucumber** para facilitar a escrita, leitura e execução dos testes.  
Os testes são independentes e seguem boas práticas para automação, garantindo robustez e escalabilidade.

