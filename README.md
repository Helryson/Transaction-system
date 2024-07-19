<h2>Este projeto é referente a um modelo de transação entre 2 usuários do banco de dados relacional H2.</h2>
Usuários comuns podem enviar e receber dinheiro, lojistas podem apenas receber.<br><br>
O Id é enviado através do body numa requisição post no endpoint "/envio", e o valor é enviado na mesma requição através do parâmetro value = "valor", sendo "/envio?valor=20" para enviar 20 por exemplo.<br><br>
Se a primeira entidade do body for um lojista, a transação será cancelada e uma exceção será lançada com forbidden 403. O mesmo acontece caso não haja saldo o suficiente ou o usuário não seja encontrado, com erros 401 e 404 respectivamente.<br>
