

INSERT INTO LEILAO (descricao, valorminimo, status) VALUES ('leilao de carros', 10000, 'Aberto');
INSERT INTO LEILAO (descricao, valorminimo, status) VALUES ('leilao de gatos', 100, 'Fechado');

INSERT INTO CONCORRENTE (cpf, nome) VALUES ('12345678977', 'Antonio santos');
INSERT INTO CONCORRENTE (cpf, nome) VALUES ('12345678900', 'Ricardo santos');

INSERT INTO LANCE (leilao_id, concorrente_id, valor) 
VALUES 
    ((SELECT id FROM LEILAO WHERE descricao = 'leilao de gatos'), 
     (SELECT id FROM CONCORRENTE WHERE nome = 'Ricardo santos'), 
     5000);


INSERT INTO LANCE (leilao_id, concorrente_id, valor) 
VALUES 
    ((SELECT id FROM LEILAO WHERE descricao = 'leilao de carros'), 
     (SELECT id FROM CONCORRENTE WHERE nome = 'Antonio santos'), 
     100);