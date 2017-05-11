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


 
