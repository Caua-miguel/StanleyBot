# Bot de Discord para gerenciamento de equipes

O StanleyBot foi criado para ajudar empresas a se organizarem na hora do preparo do café. Inicialmente o problema que me foi apresentado é o seguinte: A empresa divide as tarefas de preparo do café algumas vezes ao dia
entre os empregados dos setore, dividindo o pessoal em equipes para se organizarem. Mas esse controle e gestão dos funcinoários estava complicado por precisar gerar um pdf toda semana e alinhar com o pessoal como seria feito.

Foi ai que o StanleyBot surge para auxiliar. A ideia principal é cadastrar os funcionários em um banco de dados e gerenciar equipes com eles com simples comandos.

## Principais bibliotecas
Conforme orientações da empresa, o bot foi feito com:

- Java
- SQLite
- JDA
  
Como escolha pessoal, foi feito em java 22. Não teve nenhum critério, só não tenho muita experiencia para escolher a melhor versão.

Quanto ao SQLite, ele foi escolhido porque o bot foi feito para ser usado em um servidor local na empresa.

## Compilação

**Ainda estou trabalhando nos ajustes do ambiente para que ele rode em qualquer máquina.**

## Execução

**Ainda estou trabalhando nos ajustes do ambiente para que ele rode em qualquer máquina.**

## Comandos

Todos os comandos são executados com o prefixo "/"

Comandos exclusivos para o adminstrador do servidor:

- /criar_cargo
  - padrao
  - vazio
  - copia
  
**Execução:** Cria um cargo no servidor com as permissões de @everone, sem permissões, com as permissões de outro cargo, respectivamente.
