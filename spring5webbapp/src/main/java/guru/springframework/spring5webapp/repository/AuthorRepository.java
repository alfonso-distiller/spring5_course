package guru.springframework.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.spring5webapp.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
