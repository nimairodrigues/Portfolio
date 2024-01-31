# Algumas informações sobre este projeto com o Selenium:

Vídeo da execução dos testes sem o paralelismo:

Vídeo da execução dos testes com o paralelismo:

Vídeo da execução dos testes com o Selenium Grid:

Objeto de teste: https://opensource-demo.orangehrmlive.com/

Criação de testes automatizados atuando na camada de testes funcionais, e2e.

Todos os testes estão independentes entre si.

Não foi preciso apagar a massa de dados, mas era recomendável.

Algumas dificuldades encontradas durante a codificação dos testes usando este site:

    1- Site instável quanto a lingua escrita.
        O site de tempos em tempos muda a lingua escrita, alterna entre ingles, alemão, espanhol e francês, 
        então ficava inviável localizar elementos por algo escrito na tela.    
        
    2- Muitos elementos com identificadores repetidos.
        Muitos elementos da tela tinham o mesmo nome de classe, o que dificultava um pouco a localização de 
        elementos específicos para a interação.

Foi utilizado tecnicas como:

    Page Object.
    DriverFactory.
    Independencia dos testes.

Contém:

    Alguns casos de testes.
    Bug report.
    Suite de testes.
    Testes paralelos.
    Testes com Selenium Grid.
