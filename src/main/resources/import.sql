-- You can use this file to load seed data into the database using SQL statements
insert into User (id, fbID, nome, email,pontuacao ) values (0,'unknow' , 'Administrador', 'adm.maisbarato@gmail.com',100)

--INICIO PONTO VENDA
insert into PontoVenda (id, nome, descricao,valido,pontuacao,latitude,longitude ) values (0, 'Rondeli','Supermercado',true,0,123123,123123)
insert into PontoVenda (id, nome, descricao,valido, pontuacao,latitude,longitude ) values (1, 'Atacadao', 'Supermercado',true,0,123123,13123)
insert into PontoVenda (id, nome, descricao,valido, pontuacao,latitude,longitude ) values (2, 'Bela Vista', 'Supermercado',true,0,123123,13123)
insert into PontoVenda (id, nome, descricao,valido, pontuacao,latitude,longitude ) values (3, 'Pao de Acucar', 'Supermercado',true,0,123123,13123)
--FIM MARCAS

--INICIO UNIDADE MEDIDA
insert into UnidadeMedida (id, nome,sigla ) values (0, 'Litro','L')
insert into UnidadeMedida (id, nome,sigla ) values (1, 'QuiloGrama','Kg')
insert into UnidadeMedida (id, nome,sigla ) values (2, 'Grama','g')
insert into UnidadeMedida (id, nome,sigla ) values (3, 'Mili Litro','Ml')
insert into UnidadeMedida (id, nome,sigla ) values (4, 'Centimentro','Cm')
--FIM UNIDADE MEDIDA

--INCIO REDE
insert into Rede (id, nome,pontuacao,valido ) values (0, 'Carrefour',0,true)
insert into Rede (id, nome,pontuacao,valido ) values (1, 'HiperCard',0,true) 
insert into Rede (id, nome,pontuacao,valido ) values (2, 'Walmart',0,true)
--FIM REDE

--INICIO MARCAS
insert into Marca (id, nome,pontuacao,valido ) values (0, 'TioJoao',0,true)
insert into Marca (id, nome,pontuacao,valido ) values (1, 'Camil',0,true)
insert into Marca (id, nome,pontuacao,valido ) values (2, 'Codil',0,true)
insert into Marca (id, nome,pontuacao,valido ) values (3, 'Pacha',0,true)
insert into Marca (id, nome,pontuacao,valido ) values (4, 'Padim',0,true)
insert into Marca (id, nome,pontuacao,valido ) values (5, 'Uniao',0,true)
insert into Marca (id, nome,pontuacao,valido ) values (6, 'Coceal',0,true)
insert into Marca (id, nome,pontuacao,valido ) values (7, 'Parmarlat',0,true)
insert into Marca (id, nome,pontuacao,valido ) values (8, 'Davaca',0,true)
insert into Marca (id, nome,pontuacao,valido ) values (9, 'Vida',0,true)
insert into Marca (id, nome,pontuacao,valido ) values (10, 'Teiu',0,true)
insert into Marca (id, nome,pontuacao,valido ) values (11, 'Ype',0,true)
insert into Marca (id, nome,pontuacao,valido ) values (12, 'Dove',0,true)
insert into Marca (id, nome,pontuacao,valido ) values (13, 'Avanco',0,true)

--FIM CATEGORIAS

--INICIO CATEGORIAS 
insert into CategoriaProduto (id, nome ) values (0, 'Alimentos')
insert into CategoriaProduto (id, nome ) values (1, 'Carnes e Frios')
insert into CategoriaProduto (id, nome ) values (2, 'Hortifruti')
insert into CategoriaProduto (id, nome ) values (3, 'Bebidas')
insert into CategoriaProduto (id, nome ) values (5, 'Produtos de Limpeza')
insert into CategoriaProduto (id, nome ) values (6, 'Higiene Pessoal')
insert into CategoriaProduto (id, nome ) values (7, 'Padaria e Laticinios')

--FIM CATEGORIAS

--INICIO PRODUTO          													id, nome,marca,codigobarra,categoria, unidademedida ,user ,qtdmedida, pontuacao, valido
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (0, 'Arroz Parbolizado',1,2435123123,0,1,0,32,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (1, 'Arroz Branco',2,2435123123,0,1,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (2, 'Arroz Branco',1,2435123123,0,1,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (3, 'Arroz Branco',4,2435123123,0,1,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (4, 'Feijao Carioca',3,2435123123,0,1,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (5, 'Feijao Carioca',4,2435123123,0,1,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (6, 'Feijao Carioca',0,2435123123,0,1,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (7, 'Feijao Carioca',1,2435123123,0,1,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (8, 'Feijao Preto',4,2312255323,0,1,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (9, 'Acucar Refinado',7,9876786867,0,1,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (10, 'Acucar Refinado',5,9876786867,0,1,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (11, 'Acucar Refinado',2,9876786867,0,1,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (12, 'Acucar Refinado',6,9876786867,0,1,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (13, 'Pao FrancÊs',5,9504329349,7,1,0,300,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (14, 'Leite Integral',7,2939604033,7,0,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (15, 'Leite Integral',8,2939604033,7,0,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (16, 'Leite Integral',9,2939604033,7,0,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (17, 'Leite Integral',9,2939604033,7,0,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (18, 'Detergente',10,2939604033,5,0,0,10,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (19, 'Detergente',11,2939604033,5,0,0,600,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (20, 'Detergente',12,2939604033,5,0,0,600,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (21, 'Detergente',13,2939604033,5,0,0,600,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (22, 'Amaciante',10,2939604033,5,0,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (23, 'Amaciante',11,2939604033,5,0,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (24, 'Amaciante',12,2939604033,5,0,0,1,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (25, 'Amaciante',13,2939604033,5,0,0,1,0,true)

--FIM PRODUTO

--FEIJÃO		   				ID        PONTO DE VENDA         PRODUTO         USUÁRIO        PREÇO
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (1, 0, 4, 0, 3.50,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (2, 1, 4, 0, 3.55,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (3, 2, 4, 0, 3.60,true,0)

insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (4, 0, 5, 0, 3.53,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (5, 1, 5, 0, 3.59,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (6, 2, 5, 0, 3.70,true,0)

insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (7, 0, 6, 0, 4.20,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (8, 1, 6, 0, 3.80,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (9, 2, 6, 0, 4.10,true,0)

insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (10, 0, 7, 0, 4.20,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (11, 1, 7, 0, 3.80,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (0, 2, 7, 0, 4.10,true,0)
--FIM FEIJÂO

--ACUCAR REFINADO 				ID        PONTO DE VENDA         PRODUTO         USUÁRIO        PREÇO
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (12, 0, 9, 0, 3.20,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (13, 1, 9, 0, 3.20,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (14, 2, 9, 0, 3.99,true,0)

insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (15, 0, 10, 0, 3.40,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (16, 1, 10, 0, 4.30,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (17, 2, 10, 0, 1.25,true,0)

insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (18, 0, 11, 0, 1.23,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (19, 1, 11, 0, 5.50,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (20, 2, 11, 0, 3.90,true,0)
--FIM ACUÇUAR REFINADO

--ARROZ							ID        PONTO DE VENDA         PRODUTO         USUÁRIO        PREÇO
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (21, 0, 0, 0, 3.20,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (22, 1, 0, 0, 3.27,true,0)
						
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (23, 0, 1, 0, 3.50,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (25, 1, 1, 0, 3.55,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (26, 2, 1, 0, 3.60,true,0)

insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (27, 0, 2, 0, 3.53,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (28, 1, 2, 0, 3.59,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (29, 2, 2, 0, 3.70,true,0)

insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (30, 0, 3, 0, 4.20,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (31, 1, 3, 0, 3.80,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (32, 2, 3, 0, 4.10,true,0)
--FIM ARROZ

--LEITE INTEGRAL							ID        PONTO DE VENDA         PRODUTO         USUÁRIO        PREÇO
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (33, 0, 14, 0, 2.20,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (34, 1, 14, 0, 2.25,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (35, 2, 14, 0, 2.27,true,0)
						
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (36, 0, 15, 0, 2.83,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (37, 1, 15, 0, 2.75,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (38, 2, 15, 0, 2.90,true,0)

insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (39, 0, 16, 0, 2.90,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (40, 1, 16, 0, 2.87,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (41, 2, 16, 0, 2.99,true,0)

insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (42, 0, 17, 0, 2.10,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (43, 1, 17, 0, 1.80,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (44, 2, 17, 0, 2.05,true,0)
--FIM LEITE INTEGRAL

--DETERGENTE							ID        PONTO DE VENDA         PRODUTO         USUÁRIO        PREÇO
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (45, 0, 18, 0, 2.10,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (46, 1, 18, 0, 2.15,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (47, 2, 18, 0, 2.20,true,0)
						
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (48, 0, 19, 0, 1.83,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (49, 1, 19, 0, 1.75,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (50, 2, 19, 0, 1.90,true,0)

insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (51, 0, 20, 0, 1.90,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (52, 1, 20, 0, 1.87,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (53, 2, 20, 0, 1.99,true,0)

insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (54, 0, 21, 0, 2.10,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (55, 1, 21, 0, 1.80,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (56, 2, 21, 0, 2.05,true,0)
--FIM DETERGENTE
 
--AMACIANTE							ID        PONTO DE VENDA         PRODUTO         USUÁRIO        PREÇO
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (57, 0, 22, 0, 3.10,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (58, 1, 22, 0, 3.15,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (59, 2, 22, 0, 3.20,true,0)
						
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (60, 0, 23, 0, 3.83,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (61, 1, 23, 0, 3.75,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (62, 2, 23, 0, 3.90,true,0)

insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (63, 0, 24, 0, 3.90,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (64, 1, 24, 0, 3.87,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (65, 2, 24, 0, 3.99,true,0)

insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (66, 0, 25, 0, 3.10,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (67, 1, 25, 0, 3.80,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (68, 2, 25, 0, 3.05,true,0)
--FIM AMACIANTE
 
