# Nutriva

## Equipe

**Nome da equipe: Nutriva**

### Integrantes

- Arthur Brugnerotto Cerqueira — RM 558836
- João Vinicius Hotz Nascimento — RM 556402
- Giovana Santos Silva — RM 558873
- Eduardo Augusto Risch — RM 555212
- Gabriel Araujo da Silva Brito — RM 558802

---

## Sobre o projeto

O **Nutriva** é uma aplicação Android desenvolvida em Kotlin com o objetivo de aproximar nutrizes dos bancos de leite e postos de coleta, facilitando o acesso a informações e orientando a usuária durante o processo de doação de leite materno.

Nesta Sprint, foi desenvolvida uma versão funcional e navegável da aplicação, utilizando dados mockados para simular o comportamento principal da solução.

O aplicativo permite realizar uma triagem online, consultar o resultado, encontrar postos de coleta e bancos de leite, visualizar informações dos locais, simular um agendamento de doação, esclarecer dúvidas frequentes e conhecer as principais etapas do processo de doação.

A proposta busca contribuir para o problema apresentado no pitch, relacionado à dificuldade de conexão entre nutrizes e pontos de coleta, além da necessidade de informações mais acessíveis sobre o processo de doação.

---

## Repositório

**GitHub:**  
https://github.com/Gihxs/Nutriva-mvp

---

## Escopo funcional e priorização

### Requisitos funcionais escolhidos

Nesta Sprint, foram escolhidos os seguintes requisitos funcionais:

- Realizar a triagem online;
- Consultar o resultado da triagem;
- Localizar bancos de leite e postos de coleta;
- Consultar informações dos postos;
- Realizar a simulação de um agendamento;
- Consultar informações sobre o processo de doação;
- Consultar dúvidas frequentes.

### Priorização

As funcionalidades foram priorizadas por representarem as principais etapas da jornada proposta pelo Nutriva, desde a verificação da possibilidade de doação até a busca por um local de coleta e o agendamento.

A escolha também considera o problema apresentado no pitch, relacionado à dificuldade de conexão entre nutrizes e bancos de leite ou postos de coleta e ao acesso às informações sobre o processo de doação.

Nesta Sprint, foram priorizadas as funcionalidades necessárias para demonstrar esse fluxo de forma funcional e navegável. Recursos previstos na solução completa, como geolocalização real, chatbot, dashboard e integrações com serviços externos, ficaram fora do escopo.

---

## Relação com o problema apresentado no pitch

O Nutriva foi desenvolvido a partir da proposta de facilitar a conexão entre nutrizes e bancos de leite ou postos de coleta, além de tornar as informações relacionadas à doação mais acessíveis.

O MVP desenvolvido nesta Sprint representa essa proposta por meio de um fluxo que permite à usuária:

**entender o próximo passo → realizar a triagem → consultar o resultado → encontrar um local → visualizar informações → simular o agendamento.**

Dessa forma, as funcionalidades escolhidas estão diretamente relacionadas ao problema apresentado nas Sprints anteriores e demonstram uma evolução da proposta conceitual para uma aplicação Android funcional e navegável.

## Fluxo principal da aplicação

```text
Tela inicial
     ↓
Triagem online
     ↓
Resultado da triagem
     │
     ├── Apta → Encontrar postos
     │              ↓
     │        Detalhes do posto
     │              ↓
     │          Agendamento
     │              ↓
     │    Agendamento confirmado
     │
     └── Não apta → Dúvidas frequentes

Além do fluxo principal, a tela inicial também permite acessar:

Tela inicial
 ├── Jornada da Nutriva
 └── Dúvidas frequentes
```
## Telas implementadas

<table>
  <tr>
    <td align="center" width="50%">
      <img src="images/Tela Inicial Nutriva.png" width="300"/><br/>
      <b>1. Tela inicial</b><br/>
      <sub>Apresenta a proposta do Nutriva e direciona a usuária para as principais ações, com destaque para "Começar minha triagem".</sub>
    </td>
    <td align="center">
      <img src="images/Tela Triagem.png" width="300"/><br/>
      <b>2. Triagem</b><br/>
      <sub>Apresenta perguntas sobre as condições necessárias para a doação. A usuária responde e consulta o resultado ao final.</sub>
    </td>
  </tr>
  <tr>
    <td align="center">
      <img src="images/Tela Triagem Preenchida.png" width="300"/><br/>
      <b>3. Triagem preenchida</b><br/>
      <sub>Mostra as respostas selecionadas antes da consulta do resultado.</sub>
    </td>
    <td align="center">
      <img src="images/Resultado Triagem Apta.png" width="300"/><br/>
      <b>4. Resultado da triagem — apta</b><br/>
      <sub>Quando as condições são atendidas, indica que a usuária está apta a seguir para o próximo passo.</sub>
    </td>
  </tr>
<tr>
    <td align="center">
      <img src="images/Resultado Triagem Não Apta.png" width="300"/><br/>
      <b>5. Resultado da triagem — não apta</b><br/>
      <sub>Contempla o cenário em que as condições não são atendidas, mostrando outra ramificação possível do fluxo.</sub>
    </td>
    <td align="center">
      <img src="images/Tela Encontrar Postos.png" width="300"/><br/>
      <b>6. Encontrar postos</b><br/>
      <sub>Lista bancos de leite e postos de coleta com dados simulados, com busca por nome do local ou CEP.</sub>
    </td>
  </tr>
  <tr>
    <td align="center">
      <img src="images/Tela Detalhes do Posto.png" width="300"/><br/>
       <b>7. Detalhes do posto</b><br/>
      <sub>Mostra endereço, horário de funcionamento, distância e telefone do posto selecionado, com opção de agendar.</sub>
    </td>
    <td align="center">
      <img src="images/Tela Agendamento.png" width="300"/><br/>
      <b>8. Agendamento</b><br/>
      <sub>Permite informar os dados para simular o agendamento; o botão de confirmação depende do preenchimento dos campos.</sub>
    </td>
  </tr>
<tr>
    <td align="center">
      <img src="images/Tela Agendamento Confirmado.png" width="300"/><br/>
      <b>9. Agendamento confirmado</b><br/>
      <sub>Apresenta a confirmação visual do agendamento após o preenchimento dos dados.</sub>
    </td>
    <td align="center">
      <img src="images/Tela Jornada da Nutriva.png" width="300"/><br/>
      <b>10. Jornada da Nutriva</b><br/>
      <sub>Mostra as principais etapas do processo de doação, da triagem até o destino final do leite doado.</sub>
    </td>
  </tr>
  <tr>
    <td align="center">
      <img src="images/Tela Dúvidas Frequentes.png" width="300"/><br/>
      <b>11. Dúvidas frequentes</b><br/>
      <sub>Reúne perguntas e respostas sobre o processo de doação, como ponto de consulta rápida.</sub>
    </td>
    <td></td>
  </tr>


</table>

---

## Navegação

A navegação entre as telas foi implementada com **Navigation Compose**, utilizando um `NavHost` com rotas para cada tela do aplicativo.

Parâmetros são passados entre telas quando necessário — por exemplo, o `postoId` do banco de leite selecionado é repassado via argumento de rota para abrir a tela de detalhes e, em seguida, direcionar o agendamento para o local correspondente.

---
## Organização do projeto

O projeto foi organizado buscando separar as responsabilidades entre interface, modelos, dados, navegação e lógica da aplicação.

A pasta `data/` reúne os dados mockados utilizados nesta Sprint — bancos de leite, postos de coleta, perguntas da triagem, etapas da jornada e perguntas frequentes —,
simulando o funcionamento da solução sem necessidade de integração com API ou backend.

**Estrutura principal:**

```text
app/
└── src/
    └── main/
        └── java/
            └── com/
                └── github/
                    └── gihxs/
                        └── nutriva_mvp/
                            ├── data/
                            │
                            ├── model/
                            │
                            ├── navigation/
                            │
                            ├── ui/
                            │   ├── components/
                            │   ├── screens/
                            │   │   ├── agendamento/
                            │   │   ├── faq/
                            │   │   ├── home/
                            │   │   ├── jornada/
                            │   │   ├── postos/
                            │   │   └── triagem/
                            │   └── theme/
                            │
                            └── viewmodel/
```
A estrutura permite separar os elementos visuais, modelos de dados, dados simulados, navegação e lógica da aplicação, facilitando a manutenção e evolução do projeto.

---

## Tecnologias utilizadas
- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **Navigation Compose**
- **ViewModel**
- **StateFlow**
- **Android Studio**
- **Git**
- **GitHub**

---

## Recursos técnicos utilizados

Durante o desenvolvimento foram aplicados conceitos estudados na disciplina, incluindo:

- Desenvolvimento em Kotlin;
- Construção de _interfaces_ com Jetpack Compose;
- Material Design;
- Navegação entre telas;
- Listas dinâmicas;
- Componentização de elementos da interface;
- Gerenciamento simples de estado;
- ViewModel;
- StateFlow;
- Passagem de parâmetros entre telas;
- Utilização de dados mockados;
- Versionamento com Git e GitHub.

---

## Ambiente de desenvolvimento

**Android Studio:** Quail 3 | 2026.1.3

O projeto foi desenvolvido utilizando Kotlin e Jetpack Compose.

## Como executar o projeto
### 1. Clonar o repositório
```bash
   git clone https://github.com/Gihxs/Nutriva-mvp.git
```
### 2. Abrir no Android Studio

Abra o projeto clonado no **Android Studio Quail 3 | 2026.1.3**.

### 3. Sincronizar o projeto

Aguarde a sincronização do Gradle e a instalação das dependências necessárias.

### 4. Executar

Inicie um emulador Android ou conecte um dispositivo físico com a depuração USB habilitada.

Depois, selecione o dispositivo no Android Studio e execute o projeto utilizando a opção Run.

> **Observação:** o emulador requer virtualização de hardware habilitada na BIOS. 
> Também é possível executar em um dispositivo físico via depuração USB.
---

