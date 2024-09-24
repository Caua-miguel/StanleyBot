# Bot de Discord para gerenciamento de equipes.

O StanleyBot foi criado para ajudar empresas a se organizarem na hora do preparo do café. Inicialmente, o problema que me foi apresentado é o seguinte: A empresa divide as tarefas de preparo do café algumas vezes ao dia.
entre os empregados dos setores, dividindo o pessoal em equipes para se organizarem. Mas esse controle e gestão dos funcionários estava complicado por precisar gerar um PDF toda semana e alinhar com o pessoal como seria feito.

Foi aí que o StanleyBot surge para auxiliar. A ideia principal é cadastrar os funcionários em um banco de dados e gerenciar equipes com eles com simples comandos.

## Principais bibliotecas.
Conforme orientações da empresa, o bot foi feito com:

- Java.
- SQLite.
- JDA
  
Como escolha pessoal, foi feito em Java 22. Não teve nenhum critério, só não tenho muita experiência para escolher a melhor versão.

Quanto ao SQLite, ele foi escolhido porque o bot foi feito para ser usado em um servidor local na empresa.

## Compilação.

Ainda estou trabalhando nos ajustes do ambiente para que ele rode em qualquer máquina.

## Execução

Ainda estou trabalhando nos ajustes do ambiente para que ele rode em qualquer máquina.

## Comandos.

Todos os comandos são executados com o prefixo "/"

### Comandos exclusivos para o administrador do servidor:

- /criar_cargo_
  - padrao
  - vazio
  - copia
  
**Execução:** Cria um cargo no servidor com as permissões de @everone, sem permissões, com as permissões de outro cargo, respectivamente.

- /adicionar_
- /atualizar_
- /remover_
  
    - funcionairo
    - tarefa
    - time
      
- /adicionar_func_ao_time

**Execução:** Manipula os dados dentro do banco de dados.

- /escolher_time_da_semana

**Execução:** A partir do momento em que o administrador usar o comando, o bot vai selecionar um time cadastrado para ser o time responsável pelo café na semana. A cada 7 dias, o bot muda o time selecionado para um novo time. Quando acabarem os times, ele.
volta para o primeiro time cadastrado.

- /iniciar

**Execução:** Traz as instruções iniciais do bot.
  
- /inserir_dados_iniciais

**Execução:** Inserção em massa de usuários nas tabelas. Feito através de um upload de arquivo.

### Comandos para @everyone

- /listar_
  - cargos
  - tarefas
  - times
  - funcionarios_do_time
  - funcionarios

**Execução:** Retorna uma lista com o que foi solicitado. Por exemplo, "/listar_times" vai trazer uma lista com o nome dos times cadastrados.

- /cronometro

**Execução:** Gera uma mensagem de aviso com o tempo determinado pelo usuário. Por exemplo, "/cronometro 1" vai fazer com que o bot aguarde 1 minuto decorrido do momento em que a mensagem foi enviada e vai retornar uma mensagem de aviso de que o tempo acabou.

- /help

**Execução:** Gera uma mensagem longa com o funcionamento de todos os comandos.

- /ping

**Execução:** Retorna o ping de rede do bot.

- /reportar_falta

**Execução:** Serve apenas para o usuário solicitar para a equipe que ajude a repor algum recurso. Com o comando, o bot manda uma mensagem no canal, avisando a todos que o item especificado pelo usuário está em falta.

- /time_da_semana

**Execução:** Retorna o time seleciona na semana.

## Exemplos

**Alguns comandos:**


<img src="https://github.com/user-attachments/assets/c65e3a51-4648-4bf6-b2ee-f19e8004f385" width="700" height="400" alt="image">






