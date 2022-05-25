# Cypress

O foco de um teste de sistema deve se concentrar na interação entre os componentes. Assim como o [Selenium](https://www.selenium.dev) o [Cypress](https://www.cypress.io) é uma ferramenta que permite que a construção de testes de sistemas com interface Web. Porém, por ser uma ferramenta baseada no [NodeJS](https://nodejs.org), o Cypress fornece uma curva de aprendizado bastante interessante.

O Cypress pode ser instalado por meio de do [npm](https://www.npmjs.com):

    npm install -g cypress

Uma vez instalado, o cypress pode ser utilizado por meio do comando:

    cypress open

Depois de aberto, o Cypress mostra uma tela onde podemos selecionar o projeto que iremos realizar testes e também criar novos testes, a figura 1 ilustra essa tela:

<center>
  <img src="img/cypress.png" alt="Cypress" width="50%" height="50%" border=0 style="border:0; text-decoration:none; outline:none" /><br/>
  Figura 1 - Cypress
</center>

Quando criamos um novo teste, no botão "New Spec File", o Cypress abre um navegador capaz de gravar e rodar os testes, conforme apresenta a imagem 2.

<center>
<img src="img/test.png" alt="Cypress" width="50%" height="50%" border=0 style="border:0; text-decoration:none; outline:none" /><br/>
Figura 2 - Navegador Chrome com o Cypress
</center>

## Criando um teste

A forma mais fácil de se criar um teste é interagir com a interface para poder gravar. Para isso, se faz necessário habilitar uma funcionalidade chamada Cypress Studio. Crie o arquivo chamado `cypress.json` caso ele ainda não existe e, adicione o seguinte comando:

```json
{
  "experimentalStudio": true
}
```

Além de permitir gravar a interação com a página, o Cypress Studio também permite que você crie assertivas.

## Rodando os testes

Dependendo da aplicação, temos que iniciar um servidor HTTP para podermos rodar os testes. Existe um pacote do npm chamado [http-server](https://www.npmjs.com/package/http-server) que pode auxiliar nessa função. O trecho abaixo apresenta um exemplo de configuração de um projeto node (package.json) onde o servidor HTTP está configurado para rodar quando o comando `npm start` for chamado (na linha de comando e no mesmo diretório de um projeto node).

Outra dica. Dependendo da aplicação, você deve esperar que o servidor HTTP suba para que os testes possam ser executados. Existe um outro pacote npm chamado [start-server-and-test](https://www.npmjs.com/package/start-server-and-test) que espera que um servidor esteja pronto para depois iniciar os testes. Novamente, observe o código abaixo, quando o comando `npm test` for executado, o script `start-server-and-test` irá dar um `start` em um servidor HTTP, esperar que a URL `http://localhost:8080` esteja disponível e depois executar os testes por meio do comando `cy:run`.

```json
{
  "scripts": {
    "start": "http-server",
    "cy:run": "cypress run --browser chrome",
    "test": "start-server-and-test start http://localhost:8080 cy:run"
  },
  "devDependencies": {
    "cypress": "^9.1.1",
    "start-server-and-test": "^1.14.0"
  },
  "dependencies": {
    "http-server": "^14.0.0"
  }
}
```

Se você estiver num projeto node configurado adequadamente, para executar os testes na linha de comando basta digitar:

    npm test

## Exemplo de código 💡

Um exemplo de projeto node simples que utiliza o Cypress pode ser encontrado em:

```sh
  git clone -b dev https://github.com/rodrigoprestesmachado/vvs
  code exemplos/cypress
```

# Referências 📚

Cypress. Disponível em: [https://www.cypress.io](https://www.cypress.io)

<center>
<a href="https://rpmhub.dev" target="blanck"><img src="../imgs/logo.png" alt="Rodrigo Prestes Machado" width="3%" height="3%" border=0 style="border:0; text-decoration:none; outline:none"></a><br/>
<a rel="license" href="http://creativecommons.org/licenses/by/4.0/">Creative Commons Atribuição 4.0 Internacional</a>
</center>