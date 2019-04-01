#language: pt

@funcionais
Funcionalidade: Busca
  
  Como um usuario 
  Gostaria de realizar uma busca no site da SOC
  Para que eu possa encontrar algum conteudo

  Contexto:
  Dado que estou acessando a pagina de busca

    Esquema do Cenario: Deve validar regras de busca
    Quando insiro no campo "Buscar" o valor "<valor_busca>"
    E clico no icone de busca
    Entao recebo a mensagem "<mensagem>"
    E verifico a quantidade de conteudos retornados pela pagina
    
    Exemplos:
    | valor_busca            | mensagem                                                  |
    | teste                  | RESULTADO DA SUA BUSCA NO BLOG: TESTE                     |
    |                        | RESULTADO DA SUA BUSCA NO BLOG:                           |
    | teste123               | RESULTADO DA SUA BUSCA NO BLOG: TESTE123                  |