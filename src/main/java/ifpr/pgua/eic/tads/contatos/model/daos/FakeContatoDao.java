package ifpr.pgua.eic.tads.contatos.model.daos;

import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.Contato;

public class FakeContatoDao implements ContatoDAO {
    
    private List<Contato> lista = new ArrayList<>();

    @Override
    public Resultado<Contato> criar(Contato contato) {
        lista.add(contato);
        return Resultado.sucesso("Contato cadastrado", contato);
    }

    @Override
    public Resultado<List<Contato>> listar() {
        return Resultado.sucesso("Contatos listados", lista);
    }

}
