🧠 Simulador de AFD (Autômato Finito Determinístico)

Este projeto é uma aplicação em Java que permite criar e simular um AFD (Autômato Finito Determinístico) diretamente pelo terminal.

📚 Sobre o Projeto

O sistema permite que o usuário:

Defina o número de estados
Escolha o estado inicial
Informe os estados finais
Defina o alfabeto
Configure a função de transição
Teste palavras e verifique se são aceitas ou rejeitadas

Tudo isso de forma interativa via console.

⚙️ Estrutura do Projeto

O projeto está organizado nas seguintes classes:

Main → Classe principal que inicia o programa
Console → Responsável pela interação com o usuário
AFD → Representa o autômato (estados, alfabeto, transições)
Simulador → Executa a simulação das palavras no AFD
🚀 Como Executar
Pré-requisitos
Java JDK 8 ou superior
Passos
Clone o repositório:
git clone https://github.com/seu-usuario/seu-repositorio.git
Acesse a pasta do projeto:
cd seu-repositorio
Compile os arquivos:
javac *.java
Execute o programa:
java Main
🧪 Exemplo de Uso
Numero de estados: 2
Estado inicial: 0
Quantos estados finais: 1
Estado final 1: 1
Alfabeto (sem espacos, ex: ab01): ab

Defina as transicoes (-1 para indefinida):
  d(q0, a) = 1
  d(q0, b) = 0
  d(q1, a) = 1
  d(q1, b) = 0

Testando palavra:

Palavra (ou 'sair'): aba
Inicio: q0
d(q0, a) = q1
d(q1, b) = q0
d(q0, a) = q1
q1 e estado final. ACEITA.
📊 Funcionalidades

✔ Construção dinâmica do AFD
✔ Validação de símbolos da palavra
✔ Exibição da tabela de transições
✔ Simulação passo a passo
✔ Tratamento de erros (transições indefinidas, entradas inválidas)

🎯 Objetivo

Este projeto foi desenvolvido com fins educacionais para auxiliar no aprendizado de:

Teoria dos Autômatos
Linguagens Formais
Computação Teórica
🛠️ Possíveis Melhorias
Interface gráfica (GUI)
Exportação/importação de AFDs
Minimização de autômatos
Suporte a AFN (Autômato Finito Não Determinístico)
📄 Licença

Este projeto é de uso livre para fins educacionais.
