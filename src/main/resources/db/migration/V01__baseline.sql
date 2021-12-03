CREATE TABLE tb_cliente (
 	id_cliente SERIAL PRIMARY KEY,
 	nome_cliente VARCHAR(100) NOT NULL,
 	cpf_cliente VARCHAR(11) UNIQUE NOT NULL,
 	endereco_cliente VARCHAR(255) NOT NULL,
 	telefone_cliente VARCHAR(15) NOT NULL,
 	email_cliente VARCHAR(100)
);
	
INSERT INTO tb_cliente VALUES
	(DEFAULT, 'Leonny Lino', '12345678910', 'rua vasconselos da costa', '83980963287', 'leony.lino@email.com');
	
CREATE TABLE tb_responsavel(
	id_responsavel SERIAL PRIMARY KEY,
	num_mat_responsavel VARCHAR(6) NOT NULL UNIQUE, 
	nome_responsavel VARCHAR(100) NOT NULL
);

INSERT INTO tb_responsavel VALUES
	(DEFAULT, '123456', 'Técnico Responsavel 1'),
	(DEFAULT, '654321', 'Técnico Responsavel 2'),
	(DEFAULT, '145236', 'Técnico Responsavel 3'),
	(DEFAULT, '365214', 'Técnico Responsavel 4');
	
CREATE TABLE tb_ordem_servico(
	id_ordem SERIAL PRIMARY KEY,
	fl_concluido_ordem char(1) DEFAULT('N'),
	dt_inicio_servico TIMESTAMP,
	dt_fim_servico TIMESTAMP,
	fk_cliente INTEGER NOT NULL,
	fk_responsavel INTEGER,
	FOREIGN KEY (fk_cliente) REFERENCES tb_cliente (id_cliente),
	FOREIGN KEY (fk_responsavel) REFERENCES tb_responsavel (id_responsavel)
);

	
CREATE TABLE tb_equipamento (
	id_equipamento SERIAL PRIMARY KEY,
	tipo_equipamento VARCHAR(50) NOT NULL,
	marca_equipamento VARCHAR(50) NOT NULL,
	ds_problema_equipamento VARCHAR(255),
	fk_ordem_servico INTEGER NOT NULL,
	FOREIGN KEY (fk_ordem_servico) REFERENCES tb_ordem_servico (id_ordem)
);

CREATE TABLE tb_historico_acompanhamento (
	id_hist_acompanhamento SERIAL PRIMARY KEY,
	ds_observacao_hist_acompanhamento VARCHAR(255),
	dt_hist_acompanhamento TIMESTAMP NOT NULL,
	fk_ordem_servico INTEGER NOT NULL,
	FOREIGN KEY (fk_ordem_servico) REFERENCES tb_ordem_servico (id_ordem)
);


	