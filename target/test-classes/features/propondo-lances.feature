# language: pt
Funcionalidade: Propondo lances ao leilão


  Cenario: Propondo um único lance válido
    Dado um lance valido
    Quando propõe ao leilão
    Então o lance é aceito


  Cenario: Propondo vários lances válidos
    Dado um lance de 15.00 reais dado pelo usuario "Vinicius"
    E um lance de 20.00 reais dado pelo usuario "Davi"
    Quando propõe vários lances ao leilão
    Entao os lances são aceitos