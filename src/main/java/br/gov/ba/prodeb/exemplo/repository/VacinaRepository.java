package br.gov.ba.prodeb.exemplo.repository;

import br.gov.ba.prodeb.exemplo.entity.Vacina;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VacinaRepository extends MongoRepository<Vacina, String> {
}
