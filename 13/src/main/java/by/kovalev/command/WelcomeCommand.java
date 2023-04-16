package by.kovalev.command;

import by.kovalev.exception.IncorrectDataException;
import by.kovalev.exception.ServiceException;
import by.kovalev.model.Person;
import by.kovalev.service.PersonService;
import by.kovalev.util.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import static by.kovalev.command.grouppresons.constant.GroupConstant.LISTGROUP;

public class WelcomeCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, IncorrectDataException {
        PersonService personService = new PersonService();
        List<Person> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
}

