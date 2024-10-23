package tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.service;

import pe.com.tailoy.ws.objects.*;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.model.Producto;

import java.util.List;

public interface IProductoService {

    GetProductosResponse listarProductos();
    GetProductoResponse obtenerProductoPorId(Long id);
    PostProductResponse crearProducto(PostProductRequest request);

    PutProductResponse actualizarProducto(PutProductRequest request);

}
