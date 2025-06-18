# Sistemas-Distribuidos


### Como executar (versão distribuída) com CMD
1. Verifique que está no caminho src/main/java
2. Caso os arquivos não estejam compilados, compile: javac com/distribuidos/distribuidos/*.java
3. Inicie o RMIregistry (abrirá outro terminal que deve ser mantido aberto durante a execução): start rmiregistry (a notação pode variar em outros terminais)
   3.1. Pode acontecer do SO não encontrar o rmiregistry por não estar no seu PATH do sistema, para isso primeiro encontre e copie o endereço onde está instalado "JDK". O caminho copiado deverá ser da pasta "bin", algo como "C:\Program Files\Java\jdk-17\bin".
   3.2. Pesquise por "variáveis de ambiente" no Win + S. Na janela que abrir, clique em "variáveis de ambiente", selecione "PATH" em "variáveis do sistema" e clique em editar.
   3.3. Na nova janela, clique em "Novo" e cole o endereço do passo 3.1. Dê enter e feche todas as janelas clicando em "Ok".
5. Inicie o cliente: java -cp . com.distribuidos.distribuidos.DistribuidoCliente
6. Em outro terminal, inicie o servidor: java -cp . com.distribuidos.distribuidos.DistribuidoServidor
7. Caso seja necessário deletar as classes criadas ao compilar: del /S *.class
