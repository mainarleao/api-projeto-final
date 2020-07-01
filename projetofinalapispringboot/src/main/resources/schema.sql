DROP TABLE IF EXISTS hospede;

CREATE TABLE hospede (
        id_hospede BIGINT AUTO_INCREMENT NOT NULL,
        nome VARCHAR(200) NOT NULL,
        idade TINYINT(2) NOT NULL,
        telefone VARCHAR(12) NOT NULL,
        CPF BIGINT(12) NOT NULL,
        RG VARCHAR(20) NOT NULL,
        check_in DATE NOT NULL,
        check_out DATE NOT NULL,
        PRIMARY KEY (id_hospede));