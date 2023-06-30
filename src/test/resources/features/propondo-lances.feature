# language: pt
Funcionalidade: Propondo lances ao leilão


  Cenario: Propondo um único lance válido
    Dado um lance valido
    Quando propõe ao leilão
    Então o lance é aceito


  Cenario: Propondo vários lances válidos
    Dado vários lances válidos
    Quando propõe vários lances ao leilão
    Entao os lances são aceitos

  Esquema do Cenario: : Propondo vários lances válidos
    Dado um lance inválido de <valor> reais
    Quando propõe ao leilão
    Entao o lance não é aceito

Exemplos:
  | valor |
  | 0     |
  |  -1   |