package br.edu.aesa.service;

import br.edu.aesa.model.Veiculo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VeiculoService {
    private final Map<Integer, Veiculo> veiculos = new HashMap<>();

    public boolean cadastrar(Veiculo veiculo) {
        if (veiculo == null || veiculo.getId() <= 0 || veiculos.containsKey(veiculo.getId())) {
            return false;
        }
        veiculos.put(veiculo.getId(), veiculo);
        return true;
    }

    public Veiculo buscarPorId(int id) {
        return veiculos.get(id);
    }

    public List<Veiculo> listarTodos() {
        return new ArrayList<>(veiculos.values());
    }

    public boolean atualizar(int id, Veiculo novosDados) {
        if (novosDados == null || !veiculos.containsKey(id)) {
            return false;
        }
        novosDados.setId(id);
        veiculos.put(id, novosDados);
        return true;
    }

    public boolean remover(int id) {
        if (!veiculos.containsKey(id)) {
            return false;
        }
        veiculos.remove(id);
        return true;
    }
}
