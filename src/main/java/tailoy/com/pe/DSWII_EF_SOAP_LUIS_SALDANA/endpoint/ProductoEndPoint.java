package tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.com.tailoy.ws.objects.*;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.service.IProductoService;


@Endpoint
public class ProductoEndPoint {
    private static final String NAMESPACE_URI = "http://www.tailoy.com.pe/ws/objects";

    @Autowired
    private IProductoService productoService;

    @PayloadRoot(namespace = NAMESPACE_URI , localPart = "getProductosRequest")
    @ResponsePayload
    public GetProductosResponse getProductos(@RequestPayload GetProductosRequest request){
        return productoService.listarProductos();
    }

    @PayloadRoot(namespace = NAMESPACE_URI , localPart ="GetProductoRequest" )
    @ResponsePayload
    public GetProductoResponse getProductoXid(@RequestPayload GetProductoRequest request){
        return  productoService.obtenerProductoPorId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI , localPart = "postProductRequest")
    @ResponsePayload
    public PostProductResponse saveProducto(@RequestPayload PostProductRequest request){
        return productoService.crearProducto(request);
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putProductRequest")
    @ResponsePayload
    public PutProductResponse updateProducto(@RequestPayload PutProductRequest request){
        return productoService.actualizarProducto(request);
    }

}
