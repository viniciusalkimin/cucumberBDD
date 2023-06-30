# language: pt
Funcionalidade: Propondo lances ao leilão


  Cenario: Propondo um único lance válido
    Dado um lance valido
    Quando propõe ao leilão
    Então o lance é aceito


  Cenario: Propondo vários lances válidos
    Dado um lance de 15.0 reais dado pelo usuario "Vinicius"
    E um lance de 20.0 reais dado pelo usuario "Davi"
    Quando propõe vários lances ao leilão
    Entao os lances são aceitos

  Esquema do Cenario: Propondo lance inválido
    Dado um lance inválido de <valor> reais para o usuario '<usuario>'
    Quando propõe ao leilão
    Entao o lance não é aceito

Exemplos:
  | valor | nome     |
  | 0     | Vinicius |
  | -1    | Davi     |