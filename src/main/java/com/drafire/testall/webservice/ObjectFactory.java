
package com.drafire.testall.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.drafire.testall.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayResponse_QNAME = new QName("http://webservicedemo.distributed.drafire.com/", "sayResponse");
    private final static QName _Say_QNAME = new QName("http://webservicedemo.distributed.drafire.com/", "say");
    private final static QName _EatResponse_QNAME = new QName("http://webservicedemo.distributed.drafire.com/", "eatResponse");
    private final static QName _Eat_QNAME = new QName("http://webservicedemo.distributed.drafire.com/", "eat");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.drafire.testall.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayResponse }
     * 
     */
    public SayResponse createSayResponse() {
        return new SayResponse();
    }

    /**
     * Create an instance of {@link Eat }
     * 
     */
    public Eat createEat() {
        return new Eat();
    }

    /**
     * Create an instance of {@link Say }
     * 
     */
    public Say createSay() {
        return new Say();
    }

    /**
     * Create an instance of {@link EatResponse }
     * 
     */
    public EatResponse createEatResponse() {
        return new EatResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservicedemo.distributed.drafire.com/", name = "sayResponse")
    public JAXBElement<SayResponse> createSayResponse(SayResponse value) {
        return new JAXBElement<SayResponse>(_SayResponse_QNAME, SayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Say }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservicedemo.distributed.drafire.com/", name = "say")
    public JAXBElement<Say> createSay(Say value) {
        return new JAXBElement<Say>(_Say_QNAME, Say.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EatResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservicedemo.distributed.drafire.com/", name = "eatResponse")
    public JAXBElement<EatResponse> createEatResponse(EatResponse value) {
        return new JAXBElement<EatResponse>(_EatResponse_QNAME, EatResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Eat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservicedemo.distributed.drafire.com/", name = "eat")
    public JAXBElement<Eat> createEat(Eat value) {
        return new JAXBElement<Eat>(_Eat_QNAME, Eat.class, null, value);
    }

}
