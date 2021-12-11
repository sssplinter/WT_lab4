package by.bsuir.webtech.sementsova.lab4.services;

import by.bsuir.webtech.sementsova.lab4.entity.User;
import by.bsuir.webtech.sementsova.lab4.exceptions.DBRepositoryException;
import by.bsuir.webtech.sementsova.lab4.exceptions.ServiceException;
import by.bsuir.webtech.sementsova.lab4.repository.creator.RepositoryCreator;
import by.bsuir.webtech.sementsova.lab4.repository.impl.UserRepository;
import by.bsuir.webtech.sementsova.lab4.specification.FindByIdSpecification;
import by.bsuir.webtech.sementsova.lab4.specification.user.FindByUsernameSpecification;
import by.bsuir.webtech.sementsova.lab4.specification.user.FindByUsernameAndPassword;

import java.util.Optional;

public class UserService {

    public Optional<User> findByUsernameAndPassword(String username, String password) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindByUsernameAndPassword(username, password));
        } catch (DBRepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public Optional<User> findById(Integer id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindByIdSpecification(id));
        } catch (DBRepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public Optional<User> findByUsername(String username) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindByUsernameSpecification(username));
        } catch (DBRepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public void signUpUser(Integer id, String username, String password) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            User user = new User(id, username, String.valueOf(password.hashCode()));
            userRepository.save(user);
        } catch (DBRepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

}
