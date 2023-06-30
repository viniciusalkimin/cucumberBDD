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