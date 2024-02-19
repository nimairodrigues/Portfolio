# Projeto 1 de testes usando Selenium:

Vídeo da execução dos testes sem o paralelismo com legenda explicativa: https://youtu.be/6kHf2t2x5ak

Vídeo da execução dos testes com o paralelismo com legenda explicativa: https://youtu.be/B-2eO2PAQ2A

Vídeo da execução dos testes com o Selenium Grid com legenda explicativa: https://youtu.be/wQ9EJVVxPhE

Objeto de teste: https://opensource-demo.orangehrmlive.com/

--

Criação de testes automatizados atuando na camada de testes funcionais, e2e.

Não foi preciso apagar a massa de dados, mas era recomendável.


### Algumas dificuldades encontradas durante a codificação dos testes usando este site: <h3>

    1- Site instável quanto a lingua escrita.
        O site de tempos em tempos muda a lingua escrita, alterna entre ingles, alemão, espanhol e francês, 
        então ficava inviável localizar elementos por algo escrito na tela.    
        
    2- Muitos elementos com identificadores repetidos.
        Muitos elementos da tela tinham o mesmo nome de classe, o que dificultava um pouco a localização de 
        elementos específicos para a interação.

### Foi utilizado algumas tecnicas como: <h3>

 **Page Object**: Técnica utilizada para organizar os códigos de forma que facilite a refatoração, manutenção, leitura e organização do mesmo, criando uma Classe Page para os códigos de interação com o Sistema, e uma Classe de Teste para os códigos de validação.
 
 **Driver Factory**: Técnica utilizada para organizar o código de criação de Driver, criando uma Classe específica para a criação do mesmo, facilitando a sua manutenção.
 
 **Independencia entre os testes**: Permite a execução dos testes a qualquer momento e em qualquer ordem.

### Contém: <h3>

Alguns [casos de Testes](https://github.com/nimairodrigues/Portfolio/blob/main/projetoselenium/projeto1/Casos%20de%20Testes%20em%20texto%20Markdown.md)

[Bug report](https://github.com/nimairodrigues/Portfolio/blob/main/projetoselenium/projeto1/Reporte%20de%20Bugs.md)

Suite de testes: Criação de uma Classe para agrupar as Classes de Testes com a finalidade de facilitar a execução dos testes.

Testes paralelos: Como o próprio nome diz, executa vários testes em paralelo, aumentando a velocidade de execução dos testes.

Testes com Selenium Grid: Permite a execução dos testes em máquina remota.
