Valida-CPF-Cient-Server

Descrição
Este é um projeto em Java que utiliza Sockets para validar CPFs. Consiste em uma aplicação Cliente-Servidor, em que a máquina cliente solicita ao usuário um CPF para verificação, e o servidor recebe o CPF, realiza os cálculos necessários e retorna se o CPF é válido ou inválido.

FUNCIONAMENTO: 
A máquina cliente solicita ao usuário que digite um CPF para verificação.
A máquina servidor recebe o CPF, realiza os cálculos e verifica se o número é válido ou inválido.
Se o CPF for válido, o servidor retorna a mensagem "Este CPF é válido" para o cliente.
Se o CPF for inválido, o servidor retorna a mensagem "Este CPF é inválido" para o cliente.
Classes
Classe Servidor: Responsável por receber o CPF enviado pelo cliente, realizar os cálculos e enviar o resultado de volta ao cliente.

Classe Cliente: Responsável por capturar a entrada do usuário, enviar o CPF para o servidor e exibir a resposta do servidor (se o CPF é válido ou inválido).

ALGORITMO DE VALIDAÇÃO: 

O algoritmo que verifica o CPF segue os seguintes passos:

O CPF é composto por 11 dígitos, sendo os dois últimos os dígitos verificadores.
O primeiro dígito verificador é obtido por um cálculo com base nos 9 primeiros dígitos do CPF.
O segundo dígito verificador é obtido por um cálculo com base nos 9 primeiros dígitos mais o primeiro dígito verificador.
Para cada cálculo, são utilizados multiplicadores que variam de 2 a 11.
O resultado dos cálculos é comparado com os dígitos verificadores originais para validar o CPF.

FUNCIONAMENTO DO ALGORITMO:
Obtendo o primeiro dígito verificador:

O cálculo inicia-se da direita para a esquerda, multiplicando cada dígito pelos multiplicadores de 2 a 10.
A soma dos resultados é dividida por 11.
Se o resto dessa divisão for menor que 2, o primeiro dígito verificador é 0 (zero).
Se o resto for igual ou maior que 2, o primeiro dígito verificador é o resultado de 11 subtraindo o valor do módulo da divisão.
Obtendo o segundo dígito verificador:

O cálculo inicia-se da direita para a esquerda, multiplicando cada dígito e o primeiro dígito verificador pelos multiplicadores de 2 a 11.
A soma dos resultados é dividida por 11.
Se o resto dessa divisão for menor que 2, o segundo dígito verificador é 0 (zero).
Se o resto for igual ou maior que 2, o segundo dígito verificador é o resultado de 11 subtraindo o valor do módulo da divisão.
Validação Final:

O CPF é válido se os dois dígitos verificadores calculados conferem com os dois últimos dígitos do CPF informado.

REQUISITOS:

Java Development Kit (JDK)
Git Bash (opcional)

EXECUTANDO O PROJETO:

Clone o repositório do projeto:
git clone https://github.com/seu-usuario/Valida-CPF-Cient-Server.git

Navegue até o diretório do projeto:
cd Valida-CPF-Cient-Server

Execute o servidor:
java Servidor

Em outra janela do terminal, execute o cliente:
java Cliente

Siga as instruções no cliente para digitar um CPF e ver a resposta do servidor.

NOTAS:
O programa interage com o usuário via entrada do teclado e utiliza o IP 127.0.0.1 (localhost) para comunicação entre cliente e servidor.
A porta utilizada para comunicação pode ser escolhida pelo aluno, desde que não seja uma porta reservada.
Dicas Adicionais
Caso tenha dificuldades com a validação do CPF, você pode utilizar as dicas fornecidas no apêndice deste documento para incorporá-las na classe Servidor.

CONCLUSÃO:
Este projeto implementa um sistema de validação de CPF utilizando comunicação cliente-servidor e o algoritmo de validação descrito.
