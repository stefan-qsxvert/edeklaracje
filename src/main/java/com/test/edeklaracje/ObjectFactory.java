
package com.test.edeklaracje;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.test.edeklaracje package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.test.edeklaracje
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendDocument }
     * 
     */
    public SendDocument createSendDocument() {
        return new SendDocument();
    }

    /**
     * Create an instance of {@link SendDocumentResponse }
     * 
     */
    public SendDocumentResponse createSendDocumentResponse() {
        return new SendDocumentResponse();
    }

    /**
     * Create an instance of {@link SendUnsignDocument }
     * 
     */
    public SendUnsignDocument createSendUnsignDocument() {
        return new SendUnsignDocument();
    }

    /**
     * Create an instance of {@link SendUnsignDocumentResponse }
     * 
     */
    public SendUnsignDocumentResponse createSendUnsignDocumentResponse() {
        return new SendUnsignDocumentResponse();
    }

    /**
     * Create an instance of {@link SendDocumentWithAttachment }
     * 
     */
    public SendDocumentWithAttachment createSendDocumentWithAttachment() {
        return new SendDocumentWithAttachment();
    }

    /**
     * Create an instance of {@link SendDocumentWithAttachmentResponse }
     * 
     */
    public SendDocumentWithAttachmentResponse createSendDocumentWithAttachmentResponse() {
        return new SendDocumentWithAttachmentResponse();
    }

    /**
     * Create an instance of {@link RequestUPO }
     * 
     */
    public RequestUPO createRequestUPO() {
        return new RequestUPO();
    }

    /**
     * Create an instance of {@link RequestUPOResponse }
     * 
     */
    public RequestUPOResponse createRequestUPOResponse() {
        return new RequestUPOResponse();
    }

}
