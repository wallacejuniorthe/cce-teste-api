# cce-teste-api

Projeto de leitura de arquivos XML de agentes. API desenvolvida com Java 11 e SpringBoot. Por questão de simplicidade e do tempo concedido, não foram implementados alguns aspectos, como validações mais foram extensas e algumas organizações do projeto, como arquivos de configuração.

A leitura do XML foi implementada usando a biblioteca Xstream.

O armazenamento está usando o banco de dados em memória H2, configurado para ser recriado a cada execução. Quando o projeto estiver em execução,
o banco pode ser acessado com os seguintes dados:

url: http://localhost:8080/h2-console/login.jsp <br>
jdbcurl: jdbc:h2:mem:cce <br>
usuário:sa <br>
senha:sa<br>


Por questões de simplicidade, e por não ter conhecimento do domínio do negócio, foi feita uma modelagem simples, mas que atende ao solicitado.

Conforme consta do documento recebido, foi criado um endpoint para consulta de um dado consolidado, disponível em
http://localhost:8080/media/{sigla}

O endpoint acima traz a média dos valores de geração para uma região. Exemplo:
http://localhost:8080/media/SE



