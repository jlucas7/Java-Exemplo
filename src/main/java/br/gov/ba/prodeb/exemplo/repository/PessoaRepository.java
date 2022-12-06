package br.gov.ba.prodeb.exemplo.repository;

import br.gov.ba.prodeb.exemplo.entity.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {
}
