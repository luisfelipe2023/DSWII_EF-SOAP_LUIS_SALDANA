package tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.exception;


import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
        customFaultCode = "{http://www.tailoy.com.pe/ws}001")
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message){
        super(message);
    }
}