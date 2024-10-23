package tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.service;

import pe.com.tailoy.ws.objects.*;

public interface ICategoriaService {
    GetCategoriasResponse listarCategorias();
    GetCategoriaResponse obtenerCategoriaPorId(Integer id);
    PostCategoriaResponse crearCategoria(PostCategoriaRequest request);
    PutCategoriaResponse actualizar(PutCategoriaRequest request);
}
