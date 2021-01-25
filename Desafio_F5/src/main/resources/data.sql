INSERT INTO PRODUTO(nome,preço,quantidade) VALUES('Arroz',5.5,10);
INSERT INTO PRODUTO(nome,preço,quantidade) VALUES('Tomate',4,10);

INSERT INTO Cliente(nome,telefone,cpf) VALUES('Joao','88992345334','045.123.432-53');
INSERT INTO Cliente(nome,telefone,cpf) VALUES('Paulo','88995577442','123.234.345-67');

INSERT INTO Venda(CLIENTE_IDCLIENTE,PRODUTO_IDPRODUTO,quantidade) VALUES(2,1,4);

UPDATE PRODUTO SET quantidade = 6 WHERE IDPRODUTO = 1

