package com.example.ws.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import jakarta.jws.WebService;
import jakarta.xml.ws.BindingType;
import jakarta.xml.ws.soap.SOAPBinding;

@WebService(portName = "TodoWebPort", serviceName = "TodoWebService", targetNamespace = "http://example.com/services/TodoWebService", endpointInterface = "com.example.ws.server.TodoWebService")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class TodoWebServiceImpl /*extends SpringBeanAutowiringSupport */implements TodoWebService {

    @Autowired
    TodoService todoService;

    @Override
    public Todo getTodo(String todoId) {
        return todoService.getTodo(todoId);
    }

}