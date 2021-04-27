ALTER TABLE public.comanda
    ALTER COLUMN valor_total TYPE numeric(10, 2);

ALTER TABLE public.comanda
    ALTER COLUMN desconto TYPE numeric(10, 2);
    
ALTER TABLE public.comanda_produto_relacao
    ALTER COLUMN valor_unitario TYPE numeric(10, 2);
    
ALTER TABLE public.combo
    ALTER COLUMN valor_total TYPE numeric(10, 2);
    
ALTER TABLE public.combo_produto_relacao
    ALTER COLUMN valor TYPE numeric(10, 2);

ALTER TABLE public.financeiro
    ALTER COLUMN valor_original TYPE numeric(10, 2);

ALTER TABLE public.financeiro
    ALTER COLUMN desconto TYPE numeric(10, 2);

ALTER TABLE public.financeiro
    ALTER COLUMN acrescimo TYPE numeric(10, 2);

ALTER TABLE public.financeiro
    ALTER COLUMN valor_total TYPE numeric(10, 2);

ALTER TABLE public.financeiro
    ALTER COLUMN valor_pago TYPE numeric(10, 2);
    
ALTER TABLE public.parcela
    ALTER COLUMN valor TYPE numeric(10, 2);

ALTER TABLE public.parcela
    ALTER COLUMN desconto TYPE numeric(10, 2);

ALTER TABLE public.parcela
    ALTER COLUMN acrescimo TYPE numeric(10, 2);

ALTER TABLE public.parcela
    ALTER COLUMN valor_total TYPE numeric(10, 2);
    
ALTER TABLE public.produto
    ALTER COLUMN custo_liquido TYPE numeric(10, 2);

ALTER TABLE public.produto
    ALTER COLUMN custo_bruto TYPE numeric(10, 2);

ALTER TABLE public.produto
    ALTER COLUMN preco_venda TYPE numeric(10, 2);
    
ALTER TABLE public.recibo
    ALTER COLUMN desconto TYPE numeric(10, 2);

ALTER TABLE public.recibo
    ALTER COLUMN acrescimo TYPE numeric(10, 2);

ALTER TABLE public.recibo
    ALTER COLUMN valor_total TYPE numeric(10, 2);