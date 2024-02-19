# Projeto 1 de testes usando Selenium:

Vídeo da execução dos testes sem o paralelismo com legenda explicativa: https://youtu.be/6kHf2t2x5ak

Vídeo da execução dos testes com o paralelismo com legenda explicativa: https://youtu.be/B-2eO2PAQ2A

Vídeo da execução dos testes com o Selenium Grid com legenda explicativa: https://youtu.be/wQ9EJVVxPhE

Objeto de teste: https://opensource-demo.orangehrmlive.com/

Criação de testes automatizados atuando na camada de testes funcionais, e2e.

Não foi preciso apagar a massa de dados, mas era recomendável.

Algumas dificuldades encontradas durante a codificação dos testes usando este site:

    1- Site instável quanto a lingua escrita.
        O site de tempos em tempos muda a lingua escrita, alterna entre ingles, alemão, espanhol e francês, 
        então ficava inviável localizar elementos por algo escrito na tela.    
        
    2- Muitos elementos com identificadores repetidos.
        Muitos elementos da tela tinham o mesmo nome de classe, o que dificultava um pouco a localização de 
        elementos específicos para a interação.

Foi utilizado algumas tecnicas como:

    Page Object.
    DriverFactory.
    Independencia entre os testes.

Contém:

    Alguns casos de testes.
    Bug report.
    Suite de testes.
    Testes paralelos.
    Testes com Selenium Grid.
