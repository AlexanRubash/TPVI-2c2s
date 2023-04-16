package by.kovalev.command;

import by.kovalev.exception.IncorrectDataException;
import by.kovalev.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    CommandResult execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, IncorrectDataException, ServletException, IOException, ServiceException, IncorrectDataException;
}
