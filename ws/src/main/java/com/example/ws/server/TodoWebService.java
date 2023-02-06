package com.example.ws.server;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService(targetNamespace = "http://example.com/todo")
public interface TodoWebService {

    @WebMethod
    @WebResult(name = "todo")
    Todo getTodo(@WebParam(name = "todoId") String todoId);

}