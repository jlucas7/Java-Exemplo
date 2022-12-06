package br.gov.ba.prodeb.exemplo.service;

import br.gov.ba.prodeb.exemplo.entity.Vacina;
import br.gov.ba.prodeb.exemplo.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VacinaService {

    @Autowired
    VacinaRepository vacinaRepository;

    public List<Vacina> obterTodas() {
        return vacinaRepository.findAll();
    }

    public Optional<Vacina> obterVacina(String id) {
        return vacinaRepository.findById(id);
    }

    public Vacina inserirVacina(Vacina vacina) {
        vacinaRepository.insert(vacina);
        return vacina;
    }

    public Vacina atualizarVacina(Vacina vacina) throws Exception {
        Optional<Vacina> vacinaOptional = vacinaRepository.findById(vacina.getId());

        if(vacinaOptional.isEmpty()) {
            throw new Exception("Não foi possível encontrar essa vacina!");
        }

        Vacina vacinaAtualizada = vacinaOptional.get();
        vacinaAtualizada.setFabricante(vacina.getFabricante());
        vacinaAtualizada.setDataValidade(vacina.getDataValidade());
        vacinaAtualizada.setNumeroDoses(vacina.getNumeroDoses());
        vacinaAtualizada.setIntervaloMinimoDoses(vacina.getIntervaloMinimoDoses());

        vacinaRepository.save(vacinaAtualizada);

        return vacinaAtualizada;
    }

    public void removerVacina(String id) throws Exception {
        Optional<Vacina> vacinaOptional = vacinaRepository.findById(id);

        if (vacinaOptional.isEmpty()) {
            throw new Exception("Não foi possível encontrar essa vacina!");
        }

        vacinaRepository.delete(vacinaOptional.get());
    }
}
