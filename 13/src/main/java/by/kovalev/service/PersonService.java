package by.kovalev.service;

import by.kovalev.exception.RepositoryException;
import by.kovalev.exception.ServiceException;
import by.kovalev.model.Person;
import by.kovalev.repository.PersonRepository;
import by.kovalev.repository.RepositoryCreator;

import java.util.List;

public class PersonService {
    public List<Person> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            PersonRepository personRepository = repositoryCreator.getPersonRepository();
            return personRepository.findAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    public void save(Person person) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            PersonRepository personRepository = repositoryCreator.getPersonRepository();
            personRepository.save(person);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}