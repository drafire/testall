
package com.drafire.testall.webservice;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SayHelloImpl", targetNamespace = "http://webservicedemo.distributed.drafire.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SayHelloImpl {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "say", targetNamespace = "http://webservicedemo.distributed.drafire.com/", className = "com.drafire.testall.webservice.Say")
    @ResponseWrapper(localName = "sayResponse", targetNamespace = "http://webservicedemo.distributed.drafire.com/", className = "com.drafire.testall.webservice.SayResponse")
    @Action(input = "http://webservicedemo.distributed.drafire.com/SayHelloImpl/sayRequest", output = "http://webservicedemo.distributed.drafire.com/SayHelloImpl/sayResponse")
    public String say();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "eat", targetNamespace = "http://webservicedemo.distributed.drafire.com/", className = "com.drafire.testall.webservice.Eat")
    @ResponseWrapper(localName = "eatResponse", targetNamespace = "http://webservicedemo.distributed.drafire.com/", className = "com.drafire.testall.webservice.EatResponse")
    @Action(input = "http://webservicedemo.distributed.drafire.com/SayHelloImpl/eatRequest", output = "http://webservicedemo.distributed.drafire.com/SayHelloImpl/eatResponse")
    public String eat();

}
