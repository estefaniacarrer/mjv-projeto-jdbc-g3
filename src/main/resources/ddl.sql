-- public.tab_professor definition

-- Drop table

-- DROP TABLE public.tab_professor;

CREATE TABLE public.tab_professor (
	id                  INTEGER         NOT NULL,
	nome                varchar(255)    NOT NULL,
	datanascimento      DATE            NOT NULL,
    cargahoraria        TIME            NOT NULL,
    valor_hora          DECIMAL(5,2)    NOT NULL,
    estrangeiro         BOOLEAN         NOT NULL,
    horasdisponiveis    INTEGER         NOT NULL,
    biografia           VARCHAR(255)    NOT NULL,
    datahoracadastro    TIMESTAMP       NOT NULL,
	CONSTRAINT tab_professor_pkey PRIMARY KEY (id)
);
