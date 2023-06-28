package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PropondoLanceSteps {

    private Leilao leilao;

    private Lance lance;

    @Dado("um lance valido")
    public void dado_um_lance_valido() {
        lance = new Lance(new Usuario("Vinicius"), BigDecimal.TEN);
    }

    @Quando("propõe o lance")
    public void quando_propõe_o_lance() {
        leilao = new Leilao("Carro Zero");
        leilao.propoe(lance);
    }
    @Entao("o lance é aceito")
    public void então_o_lance_é_aceito() {
        assertThat(leilao.getLances()).isNotNull();
    }


}
