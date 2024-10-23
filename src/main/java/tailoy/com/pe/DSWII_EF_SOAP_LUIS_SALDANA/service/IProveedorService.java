package tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.service;

import pe.com.tailoy.ws.objects.*;

public interface IProveedorService {
    GetProveedoresResponse listarProveedores();
    GetProveedorResponse obtenerProveedorPorId(Integer id);
    PostProveedorResponse crearProveedor(PostProveedorRequest request);
    PutProveedorResponse actualizarProveedor(PutProveedorRequest request);
}
