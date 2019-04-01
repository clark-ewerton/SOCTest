$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Funcionalidade-Busca.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: pt"
    }
  ],
  "line": 4,
  "name": "Busca",
  "description": "\r\nComo um usuario \r\nGostaria de realizar uma busca no site da SOC\r\nPara que eu possa encontrar algum conteudo",
  "id": "busca",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "line": 3,
      "name": "@funcionais"
    }
  ]
});
formatter.scenarioOutline({
  "line": 13,
  "name": "Deve validar regras de busca",
  "description": "",
  "id": "busca;deve-validar-regras-de-busca",
  "type": "scenario_outline",
  "keyword": "Esquema do Cenario"
});
formatter.step({
  "line": 14,
  "name": "insiro no campo \"Buscar\" o valor \"\u003cvalor_busca\u003e\"",
  "keyword": "Quando "
});
formatter.step({
  "line": 15,
  "name": "clico no icone de busca",
  "keyword": "E "
});
formatter.step({
  "line": 16,
  "name": "recebo a mensagem \"\u003cmensagem\u003e\"",
  "keyword": "Entao "
});
formatter.examples({
  "line": 18,
  "name": "",
  "description": "",
  "id": "busca;deve-validar-regras-de-busca;",
  "rows": [
    {
      "cells": [
        "valor_busca",
        "mensagem"
      ],
      "line": 19,
      "id": "busca;deve-validar-regras-de-busca;;1"
    },
    {
      "cells": [
        "teste",
        "RESULTADO DA SUA BUSCA NO BLOG: TESTE"
      ],
      "line": 20,
      "id": "busca;deve-validar-regras-de-busca;;2"
    },
    {
      "cells": [
        "",
        "RESULTADO DA SUA BUSCA NO BLOG:"
      ],
      "line": 21,
      "id": "busca;deve-validar-regras-de-busca;;3"
    },
    {
      "cells": [
        "teste123",
        "RESULTADO DA SUA BUSCA NO BLOG: TESTE123"
      ],
      "line": 22,
      "id": "busca;deve-validar-regras-de-busca;;4"
    }
  ],
  "keyword": "Exemplos"
});
formatter.background({
  "line": 10,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Contexto"
});
formatter.step({
  "line": 11,
  "name": "que estou acessando a pagina de busca",
  "keyword": "Dado "
});
formatter.match({
  "location": "BuscaSteps.que_estou_acessando_a_pagina_de_busca()"
});
formatter.result({
  "duration": 22724536620,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Deve validar regras de busca",
  "description": "",
  "id": "busca;deve-validar-regras-de-busca;;2",
  "type": "scenario",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "line": 3,
      "name": "@funcionais"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "insiro no campo \"Buscar\" o valor \"teste\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Quando "
});
formatter.step({
  "line": 15,
  "name": "clico no icone de busca",
  "keyword": "E "
});
formatter.step({
  "line": 16,
  "name": "recebo a mensagem \"RESULTADO DA SUA BUSCA NO BLOG: TESTE\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Entao "
});
formatter.match({
  "arguments": [
    {
      "val": "Buscar",
      "offset": 17
    },
    {
      "val": "teste",
      "offset": 34
    }
  ],
  "location": "BuscaSteps.insiro_no_campo_o_valor(String,String)"
});
formatter.result({
  "duration": 234854876,
  "status": "passed"
});
formatter.match({
  "location": "BuscaSteps.clico_no_icone_de_busca()"
});
formatter.result({
  "duration": 7364911643,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "RESULTADO DA SUA BUSCA NO BLOG: TESTE",
      "offset": 19
    }
  ],
  "location": "BuscaSteps.recebo_a_mensagem(String)"
});
formatter.result({
  "duration": 10912048406,
  "status": "passed"
});
formatter.background({
  "line": 10,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Contexto"
});
formatter.step({
  "line": 11,
  "name": "que estou acessando a pagina de busca",
  "keyword": "Dado "
});
formatter.match({
  "location": "BuscaSteps.que_estou_acessando_a_pagina_de_busca()"
});
formatter.result({
  "duration": 4874901914,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Deve validar regras de busca",
  "description": "",
  "id": "busca;deve-validar-regras-de-busca;;3",
  "type": "scenario",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "line": 3,
      "name": "@funcionais"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "insiro no campo \"Buscar\" o valor \"\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Quando "
});
formatter.step({
  "line": 15,
  "name": "clico no icone de busca",
  "keyword": "E "
});
formatter.step({
  "line": 16,
  "name": "recebo a mensagem \"RESULTADO DA SUA BUSCA NO BLOG:\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Entao "
});
formatter.match({
  "arguments": [
    {
      "val": "Buscar",
      "offset": 17
    },
    {
      "val": "",
      "offset": 34
    }
  ],
  "location": "BuscaSteps.insiro_no_campo_o_valor(String,String)"
});
formatter.result({
  "duration": 170798687,
  "status": "passed"
});
formatter.match({
  "location": "BuscaSteps.clico_no_icone_de_busca()"
});
formatter.result({
  "duration": 4994962636,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "RESULTADO DA SUA BUSCA NO BLOG:",
      "offset": 19
    }
  ],
  "location": "BuscaSteps.recebo_a_mensagem(String)"
});
formatter.result({
  "duration": 10210374916,
  "status": "passed"
});
formatter.background({
  "line": 10,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Contexto"
});
formatter.step({
  "line": 11,
  "name": "que estou acessando a pagina de busca",
  "keyword": "Dado "
});
formatter.match({
  "location": "BuscaSteps.que_estou_acessando_a_pagina_de_busca()"
});
formatter.result({
  "duration": 4716143723,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Deve validar regras de busca",
  "description": "",
  "id": "busca;deve-validar-regras-de-busca;;4",
  "type": "scenario",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "line": 3,
      "name": "@funcionais"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "insiro no campo \"Buscar\" o valor \"teste123\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Quando "
});
formatter.step({
  "line": 15,
  "name": "clico no icone de busca",
  "keyword": "E "
});
formatter.step({
  "line": 16,
  "name": "recebo a mensagem \"RESULTADO DA SUA BUSCA NO BLOG: TESTE123\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Entao "
});
formatter.match({
  "arguments": [
    {
      "val": "Buscar",
      "offset": 17
    },
    {
      "val": "teste123",
      "offset": 34
    }
  ],
  "location": "BuscaSteps.insiro_no_campo_o_valor(String,String)"
});
formatter.result({
  "duration": 203385467,
  "status": "passed"
});
formatter.match({
  "location": "BuscaSteps.clico_no_icone_de_busca()"
});
formatter.result({
  "duration": 5922194973,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "RESULTADO DA SUA BUSCA NO BLOG: TESTE123",
      "offset": 19
    }
  ],
  "location": "BuscaSteps.recebo_a_mensagem(String)"
});
formatter.result({
  "duration": 10725914412,
  "status": "passed"
});
});