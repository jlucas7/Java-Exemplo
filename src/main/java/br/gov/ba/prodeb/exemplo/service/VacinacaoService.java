package br.gov.ba.prodeb.exemplo.service;

import br.gov.ba.prodeb.exemplo.entity.Vacinacao;
import br.gov.ba.prodeb.exemplo.repository.VacinacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacinacaoService {

    @Autowired
    VacinacaoRepository vacinacaoRepository;

    public List<Vacinacao> obterTodas() {
        return vacinacaoRepository.findAll();
    }

    public Optional<Vacinacao> obterVacinacao(String id) {
        return vacinacaoRepository.findById(id);
    }

    public Vacinacao inserirVacinacao(Vacinacao vacinacao) {
        //Optional<Vacinacao> maxVacinacao = vacinacaoRepository.findByPessoa(vacinacao.getPessoa().getId());

        //Vacinacao result = maxVacinacao.get();
//        result.setDataVacinacao(vacinacao.getDataVacinacao());
//        result.setDose(vacinacao.getDose());
//        result.setPessoa(vacinacao.getPessoa());
//        result.setVacina(vacinacao.getVacina());

        //return result;
        vacinacaoRepository.insert(vacinacao);
        return vacinacao;
    }

    public Vacinacao atualizarVacinacao(Vacinacao vacinacao) throws Exception {
        Optional<Vacinacao> vacinacaoOptional = vacinacaoRepository.findById(vacinacao.getId());

        if(vacinacaoOptional.isEmpty()) {
            throw new Exception("Não foi possível encontrar esse Registro!");
        }

        Vacinacao vacinacaoAtualizada = vacinacaoOptional.get();
        vacinacaoAtualizada.setDataVacinacao(vacinacao.getDataVacinacao());
        vacinacaoAtualizada.setDose(vacinacao.getDose());
        vacinacaoAtualizada.setPessoa(vacinacao.getPessoa());
        vacinacaoAtualizada.setVacina(vacinacao.getVacina());

        vacinacaoRepository.save(vacinacaoAtualizada);

        return vacinacaoAtualizada;
    }

    public void removerVacinacao(String id) throws Exception {
        Optional<Vacinacao> vacinacaoOptional = vacinacaoRepository.findById(id);

        if (vacinacaoOptional.isEmpty()) {
            throw new Exception("Não foi possível encontrar esse Registro!");
        }

        vacinacaoRepository.delete(vacinacaoOptional.get());
    }
}
