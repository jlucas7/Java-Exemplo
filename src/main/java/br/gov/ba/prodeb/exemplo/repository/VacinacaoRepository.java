package br.gov.ba.prodeb.exemplo.repository;

import br.gov.ba.prodeb.exemplo.entity.Pessoa;
import br.gov.ba.prodeb.exemplo.entity.Vacinacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface VacinacaoRepository extends MongoRepository<Vacinacao, String> {
    @Query("{ $and: [ { $max: \"$id\" }, { 'pessoa.id': { $regex: ?0, $options: 'i' } } ] }")
    Optional<Vacinacao> findByPessoa(String id);
}
