
CREATE TABLE `duplicatas` (
  `i_duplicatas` int(15) NOT NULL AUTO_INCREMENT,
  `identificacao` varchar(10) NOT NULL,
  `valor` double zerofill NOT NULL,
  `valor_pago` double zerofill NOT NULL,
  `data_vencimento` date NOT NULL,
  `i_notas` int(15) NOT NULL,
  `data_emissao` date NOT NULL,
  PRIMARY KEY (`i_duplicatas`),
  KEY `FK_NOTAS_DUPLICATAS` (`i_notas`),
  CONSTRAINT `FK_NOTAS_DUPLICATAS` FOREIGN KEY (`i_notas`) REFERENCES `notas_fiscais` (`i_notas`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `estado` (
  `i_estado` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`i_estado`)
);

CREATE TABLE `fornecedores` (
  `i_fornecedores` int(15) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `i_pais` int(15) DEFAULT NULL,
  `i_municipio` int(15) DEFAULT NULL,
  `i_estado` int(15) DEFAULT NULL,
  `tipo_pessoa` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`i_fornecedores`),
  KEY `FK_ESTADO_FORNECEDOR` (`i_estado`),
  KEY `FK_PAIS_FORNECEDOR` (`i_pais`),
  KEY `FK_MUNICIPIO_FORNECEDOR` (`i_municipio`),
  CONSTRAINT `FK_ESTADO_FORNECEDOR` FOREIGN KEY (`i_estado`) REFERENCES `estado` (`i_estado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PAIS_FORNECEDOR` FOREIGN KEY (`i_pais`) REFERENCES `pais` (`i_pais`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_MUNICIPIO_FORNECEDOR` FOREIGN KEY (`i_municipio`) REFERENCES `municipios` (`i_municipios`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `municipios` (
  `i_municipios` int(15) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`i_municipios`)
);

CREATE TABLE `notas_fiscais` (
  `i_notas` int(15) NOT NULL AUTO_INCREMENT,
  `valor` double zerofill NOT NULL,
  `i_fornecedores` int(15) NOT NULL,
  `forma_pagamento` char(1) NOT NULL,
  `qtd_parcelas` int(11) NOT NULL,
  `data_emissao` date NOT NULL,
  PRIMARY KEY (`i_notas`)
);

CREATE TABLE `pagamentos` (
  `i_pagamentos` int(15) NOT NULL AUTO_INCREMENT,
  `i_duplicatas` int(15) NOT NULL,
  `valor` double zerofill DEFAULT NULL,
  `data_pagamento` date NOT NULL,
  PRIMARY KEY (`i_pagamentos`),
  KEY `FK_DUPLICATAS_PAGAMENTOS` (`i_duplicatas`),
  CONSTRAINT `FK_DUPLICATAS_PAGAMENTOS` FOREIGN KEY (`i_duplicatas`) REFERENCES `duplicatas` (`i_duplicatas`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `pais` (
  `i_pais` int(15) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`i_pais`)
);


