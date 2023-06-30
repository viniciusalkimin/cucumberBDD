package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropondoLanceSteps {

    private Leilao leilao;

    private Lance lance;
    private Lance lance2;
    private Lance lance3;

    @Dado("um lance valido")
    public void dado_um_lance_valido() {
        lance = new Lance(new Usuario("Vinicius"), BigDecimal.TEN);
        leilao = new Leilao("Carro Zero");

    }

    @Quando("propõe ao leilão")
    public void quando_propõe_o_lance() {
        leilao.propoe(lance);
    }
    @Entao("o lance é aceito")
    public void então_o_lance_é_aceito() {
        assertThat(leilao.getLances()).isNotNull();
    }


    @Dado("vários lances válidos")
    public void vários_lances_válidos() {
        lance2 = new Lance(new Usuario("Vinicius"), new BigDecimal(15L));
        lance3 = new Lance(new Usuario("Davi"),  new BigDecimal(20L));
        leilao = new Leilao("Carro ZeroKM");
    }

    @Quando("propõe vários lances ao leilão")
    public void propõe_vários_lances_ao_leilão() {
        leilao.propoe(lance2);
        leilao.propoe(lance3);
    }
    @Entao("os lances são aceitos")
    public void os_lances_são_aceitos() {
        assertThat(leilao.getLances()).isNotNull();
        assertEquals(new BigDecimal(15L), leilao.getLances().get(0).getValor());
        assertEquals(new BigDecimal(20L), leilao.getLances().get(1).getValor());
    }



}
