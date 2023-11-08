CREATE TABLE IF NOT EXISTS `person` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `primeiro_nome` varchar(80) NOT NULL,
    `ultimo_nome` varchar(80) NOT NULL,
    `genero` varchar(10) NOT NULL,
    `endereco` varchar(80) NOT NULL,
    PRIMARY KEY (`id`)
);

