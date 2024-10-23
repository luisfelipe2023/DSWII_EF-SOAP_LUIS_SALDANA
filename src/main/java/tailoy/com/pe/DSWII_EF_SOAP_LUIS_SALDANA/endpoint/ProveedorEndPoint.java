package tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.com.tailoy.ws.objects.*;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.service.IProveedorService;

@Endpoint
public class ProveedorEndPoint {
    private static final String NAMESPACE_URI = "http://www.tailoy.com.pe/ws/objects";

    @Autowired
    private IProveedorService proveedorService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProveedoresRequest")
    @ResponsePayload
    public GetProveedoresResponse getProveedores(@RequestPayload GetProveedoresRequest request) {
        return proveedorService.listarProveedores();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetProveedorRequest")
    @ResponsePayload
    public GetProveedorResponse getProveedorPorId(@RequestPayload GetProveedorRequest request) {
        return proveedorService.obtenerProveedorPorId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postProveedorRequest")
    @ResponsePayload
    public PostProveedorResponse saveProveedor(@RequestPayload PostProveedorRequest request) {
        return proveedorService.crearProveedor(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putProveedorRequest")
    @ResponsePayload
    public PutProveedorResponse updateProveedor(@RequestPayload PutProveedorRequest request) {
        return proveedorService.actualizarProveedor(request);
    }
}
