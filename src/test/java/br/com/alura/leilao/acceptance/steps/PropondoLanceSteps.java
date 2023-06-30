package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropondoLanceSteps {

    private Leilao leilao;

    private Lance lance;
    private ArrayList<Lance> lista;


    @Before
    public void setup() {
        this.lista = new ArrayList<Lance>();
        this.leilao = new Leilao("Carro Zero");
    }

    @Dado("um lance valido")
    public void dado_um_lance_valido() {
        lance = new Lance(new Usuario("Vinicius"), BigDecimal.TEN);

    }

    @Quando("propõe ao leilão")
    public void quando_propõe_o_lance() {
        leilao.propoe(lance);
    }
    @Entao("o lance é aceito")
    public void então_o_lance_é_aceito() {
        assertThat(leilao.getLances()).isNotNull();
    }


    @Dado("um lance de {double} reais dado pelo usuario {string}")
    public void um_lance_de_reais_dado_pelo_usuario(Double valor, String nome)  {
        Lance lance1 = new Lance(new Usuario(nome), new BigDecimal(valor));
        lista.add(lance1);
    }

    @Quando("propõe vários lances ao leilão")
    public void propõe_vários_lances_ao_leilão() {
        lista.forEach( l -> leilao.propoe(l));
    }
    @Entao("os lances são aceitos")
    public void os_lances_são_aceitos() {
        assertThat(leilao.getLances().size()).isEqualTo(lista.size());
        assertEquals(new BigDecimal(15L), leilao.getLances().get(0).getValor());
        assertEquals(new BigDecimal(20L), leilao.getLances().get(1).getValor());
    }

    @Dado("um lance inválido de {double} reais para o usuario {string}")
    public void um_lance_inválido_de_reais(Double valor, String nome) {
        this.lance = new Lance(new BigDecimal(valor));
    }


    @Entao("o lance não é aceito")
    public void o_lance_não_é_aceito() {
        assertEquals(0, leilao.getLances().size());
    }



}
