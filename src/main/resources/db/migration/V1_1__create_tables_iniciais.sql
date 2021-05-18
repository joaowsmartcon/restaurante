CREATE TABLE "produto" (
  "id" BIGSERIAL PRIMARY KEY,
  "descricao" varchar(200),
  "idfinalidade" bigint,
  "unidade" varchar(2),
  "custo_liquido" numeric(24,10),
  "custo_bruto" numeric(24,10),
  "preco_venda" numeric(24,10),
  "inativo" boolean,
  "data_cadastro" timestamp
);

CREATE TABLE "finalidade" (
  "id" bigint PRIMARY KEY,
  "descricao" varchar
);

CREATE TABLE "combo" (
  "id" BIGSERIAL PRIMARY KEY,
  "nome" varchar(200),
  "descricao" varchar(200),
  "valor_total" numeric(24,10)
);

CREATE TABLE "combo_produto_relacao" (
  "id" BIGSERIAL PRIMARY KEY,
  "idcombo" bigint,
  "idproduto" bigint,
  "qtde" int,
  "valor" numeric(24,10)
);

CREATE TABLE "empresa_pessoa" (
  "id" BIGSERIAL PRIMARY KEY,
  "nome" varchar(200),
  "cpf_cnpj" varchar(150),
  "data_nasc" date,
  "email" varchar(200),
  "telefone" varchar(20),
  "data_cadastro" timestamp,
  "situacao" boolean
);

CREATE TABLE "comanda" (
  "id" BIGSERIAL PRIMARY KEY,
  "idpessoa" bigint,
  "data_cadastro" timestamp,
  "desconto" numeric(24,10),
  "valor_total" numeric(24,10)
);

CREATE TABLE "comanda_produto_relacao" (
  "id" BIGSERIAL PRIMARY KEY,
  "idproduto" bigint,
  "idcomanda" bigint,
  "idcombo" bigint,
  "qtde" int,
  "valor_unitario" numeric(24,10)
);

CREATE TABLE "convenio" (
  "id" BIGSERIAL PRIMARY KEY,
  "nome" varchar(200),
  "idempresapessoa" bigint,
  "data_cadastro" timestamp,
  "data_vencimento" timestamp,
  "situacao" boolean
);

CREATE TABLE "financeiro" (
  "id" BIGSERIAL PRIMARY KEY,
  "idempresapessoa" bigint,
  "data_cadastro" timestamp,
  "data_vencimento" timestamp,
  "data_pagamento" timestamp,
  "valor_original" numeric(24,10),
  "desconto" numeric(24,10),
  "acrescimo" numeric(24,10),
  "valor_total" numeric(24,10),
  "valor_pago" numeric(24,10),
  "idtipo_recebimento" bigint,
  "idtipo_lancamento" bigint
);

CREATE TABLE "tipo_recebimento" (
  "id" bigint PRIMARY KEY,
  "descricao" varchar(200)
);

CREATE TABLE "tipo_lancamento" (
  "id" bigint PRIMARY KEY,
  "descricao" varchar(200)
);

CREATE TABLE "parcela" (
  "id" BIGSERIAL PRIMARY KEY,
  "idfinanceiro" bigint,
  "idsituacao_parcela" bigint,
  "descricao" varchar(200),
  "data_cadastro" timestamp,
  "data_vencimento" timestamp,
  "data_pagamento" timestamp,
  "valor" numeric(24,10),
  "desconto" numeric(24,10),
  "acrescimo" numeric(24,10),
  "valor_total" numeric(24,10)
);

CREATE TABLE "situacao_parcela" (
  "id" bigint PRIMARY KEY,
  "descricao" varchar(200)
);

CREATE TABLE "recibo" (
  "id" BIGSERIAL PRIMARY KEY,
  "num_recibo" varchar(100),
  "idfinanceiro" bigint,
  "descricao" varchar(200),
  "data_cadastro" timestamp,
  "data_pagamento" timestamp,
  "desconto" numeric(24,10),
  "acrescimo" numeric(24,10),
  "valor_total" numeric(24,10)
);

ALTER TABLE "recibo" ADD FOREIGN KEY ("idfinanceiro") REFERENCES "financeiro" ("id");

ALTER TABLE "comanda" ADD FOREIGN KEY ("idpessoa") REFERENCES "empresa_pessoa" ("id");

ALTER TABLE "produto" ADD FOREIGN KEY ("idfinalidade") REFERENCES "finalidade" ("id");

ALTER TABLE "parcela" ADD FOREIGN KEY ("idfinanceiro") REFERENCES "financeiro" ("id");

ALTER TABLE "combo_produto_relacao" ADD FOREIGN KEY ("idcombo") REFERENCES "combo" ("id");

ALTER TABLE "comanda_produto_relacao" ADD FOREIGN KEY ("idcombo") REFERENCES "combo" ("id");

ALTER TABLE "combo_produto_relacao" ADD FOREIGN KEY ("idproduto") REFERENCES "produto" ("id");

ALTER TABLE "convenio" ADD FOREIGN KEY ("idempresapessoa") REFERENCES "empresa_pessoa" ("id");

ALTER TABLE "comanda_produto_relacao" ADD FOREIGN KEY ("idproduto") REFERENCES "produto" ("id");

ALTER TABLE "comanda_produto_relacao" ADD FOREIGN KEY ("idcomanda") REFERENCES "comanda" ("id");

ALTER TABLE "parcela" ADD FOREIGN KEY ("idsituacao_parcela") REFERENCES "situacao_parcela" ("id");

ALTER TABLE "financeiro" ADD FOREIGN KEY ("idtipo_lancamento") REFERENCES "tipo_lancamento" ("id");

ALTER TABLE "financeiro" ADD FOREIGN KEY ("idtipo_recebimento") REFERENCES "tipo_recebimento" ("id");
