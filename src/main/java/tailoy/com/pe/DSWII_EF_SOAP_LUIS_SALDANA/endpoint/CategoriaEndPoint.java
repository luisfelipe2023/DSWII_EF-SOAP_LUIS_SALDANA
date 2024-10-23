package tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.com.tailoy.ws.objects.*;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.service.ICategoriaService;

@Endpoint
public class CategoriaEndPoint {
    private static final String NAMESPACE_URI = "http://www.tailoy.com.pe/ws/objects";

    @Autowired
    private ICategoriaService categoriaService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCategoriasRequest")
    @ResponsePayload
    public GetCategoriasResponse getCategorias(@RequestPayload GetCategoriasRequest request) {
        return categoriaService.listarCategorias();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCategoriaRequest")
    @ResponsePayload
    public GetCategoriaResponse getCategoriaXid(@RequestPayload GetCategoriaRequest request) {
        return categoriaService.obtenerCategoriaPorId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postCategoriaRequest")
    @ResponsePayload
    public PostCategoriaResponse saveCategoria(@RequestPayload PostCategoriaRequest request) {
        return categoriaService.crearCategoria(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putCategoriaRequest")
    @ResponsePayload
    public PutCategoriaResponse updateCategoria(@RequestPayload PutCategoriaRequest request) {
        return categoriaService.actualizar(request);
    }
}