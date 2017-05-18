--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements 
insert into CategoriaProduto (id, nome ) values (0, 'Frios')
insert into CategoriaProduto (id, nome ) values (1, 'Laticinios')
insert into CategoriaProduto (id, nome ) values (2, 'Acougue')
insert into CategoriaProduto (id, nome ) values (3, 'Padaria')
insert into User (id, nome, email,pontuacao ) values (0, 'John Smith', 'john.smith@mailinator.com',0)
insert into User (id, nome, email,pontuacao ) values (1, 'vitor', 'vitor@vitor.com',0)
insert into Marca (id, nome,pontuacao,valido ) values (0, 'CocaCola',0,true)
insert into Marca (id, nome,pontuacao,valido ) values (1, 'Nestle',0,true)
insert into Marca (id, nome,pontuacao,valido ) values (2, 'Padim',0,true)
insert into PontoVenda (id, nome, descricao,valido,pontuacao,latitude,longitude ) values (0, 'Rondeli','Supermercado',true,0,123123,123123)
insert into PontoVenda (id, nome, descricao,valido, pontuacao,latitude,longitude ) values (1, 'Atacadao', 'Supermercado',true,0,123123,13123)
insert into UnidadeMedida (id, nome,sigla ) values (0, 'Litros','Lt')
insert into UnidadeMedida (id, nome,sigla ) values (1, 'QuiloGrama','Kg')
insert into UnidadeMedida (id, nome,sigla ) values (2, 'Centimentro','Cm')
insert into Rede (id, nome,pontuacao,valido ) values (0, 'Carrefour',0,true)
insert into Rede (id, nome,pontuacao,valido ) values (1, 'HiperCard',0,true) 
insert into Rede (id, nome,pontuacao,valido ) values (2, 'Walmart',0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (0, 'Arroz',2,2435123123,0,1,1,32,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (1, 'Feijao',2,2312255323,2,1,1,23,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (2, 'Acucar',2,9876786867,2,1,0,13,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (3, 'Pao',2,9504329349,3,1,0,12,0,true)
insert into Produto (id, nome,marca_id,codigobarra,categoriaproduto_id,unidademedida_id,user_id,qtdmedida,pontuacao,valido ) values (4, 'Leite',2,2939604033,3,0,1,123,0,true)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (0, 0, 0, 0, 1.20,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (1, 0, 1, 1, 2.50,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (2, 0, 2, 1, 3.40,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (3, 0, 3, 1, 4.30,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (4, 1, 0, 0, 1.25,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (5, 1, 1, 0, 1.23,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (6, 1, 2, 1, 5.50,true,0)
insert into PrecoProduto (id, pontovenda_id,produto_id,user_id,preco,valido,pontuacao) values (7, 1, 3, 1, 3.90,true,0)


 
