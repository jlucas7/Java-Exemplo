package br.gov.ba.prodeb.exemplo.service;

import br.gov.ba.prodeb.exemplo.entity.Pessoa;
import br.gov.ba.prodeb.exemplo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> obterTodas() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> obterPessoa(String id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa inserirPessoa(Pessoa pessoa) {
        pessoaRepository.insert(pessoa);
        return pessoa;
    }

    public Pessoa atualizarPessoa(Pessoa pessoa) throws Exception {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoa.getId());

        if(pessoaOptional.isEmpty()) {
            throw new Exception("Não foi possível encontrar essa pessoa!");
        }

        Pessoa pessoaAtualizada = pessoaOptional.get();
        pessoaAtualizada.setNome(pessoa.getNome());
        pessoaAtualizada.setIdade(pessoa.getIdade());

        pessoaRepository.save(pessoaAtualizada);

        return pessoaAtualizada;
    }

    public void removerPessoa(String id) throws Exception {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

        if (pessoaOptional.isEmpty()) {
            throw new Exception("Não foi possível encontrar essa pessoa!");
        }

        pessoaRepository.delete(pessoaOptional.get());
    }
}
