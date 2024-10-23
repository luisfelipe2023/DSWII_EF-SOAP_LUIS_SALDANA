package tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.tailoy.ws.objects.*;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.exception.NotFoundException;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.model.Categoria;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.repository.CategoriaRepository;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.service.ICategoriaService;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.util.convert.CategoriaConvert;

@RequiredArgsConstructor
@Service
public class CategoriaService implements ICategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaConvert categoriaConvert;

    @Override
    public GetCategoriasResponse listarCategorias() {
        GetCategoriasResponse response = new GetCategoriasResponse();
        response.getCategorias().addAll(
                categoriaConvert.mapToListCategoriaWs(categoriaRepository.findAll())
        );
        return response;
    }

    @Override
    public GetCategoriaResponse obtenerCategoriaPorId(Integer id) {
        GetCategoriaResponse response = new GetCategoriaResponse();
        Categoria categoria = categoriaRepository.findById(id).orElse(null);

        if (categoria == null) {
            throw new NotFoundException("La Categoria No existe");
        }
        Categoriaows categoriaows = categoriaConvert.mapToCategoriaWs(categoria);
        response.getCategoria().add(categoriaows);

        return response;
    }

    @Override
    public PostCategoriaResponse crearCategoria(PostCategoriaRequest request) {
        if (request.getCategoria() == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula");
        }
        Categoriaows categoriaWs = request.getCategoria();
        Categoria nuevaCategoria = categoriaConvert.mapToCategoria(categoriaWs);

        Categoria categoriaGuardada = categoriaRepository.save(nuevaCategoria);

        PostCategoriaResponse response = new PostCategoriaResponse();
        response.setCategoria(categoriaConvert.mapToCategoriaWs(categoriaGuardada));
        return response;
    }

    @Override
    public PutCategoriaResponse actualizar(PutCategoriaRequest request) {
        if (request.getCategoria() == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula");
        }
        Categoriaows categoriaWs = request.getCategoria();

        Categoria categoriaExistente = categoriaRepository.findById(categoriaWs.getId())
                .orElseThrow(() -> new NotFoundException("La categoría con el id " + categoriaWs.getId() + " no existe"));

        categoriaExistente.setNombre(categoriaWs.getNombre());
        Categoria categoriaActualizada = categoriaRepository.save(categoriaExistente);

        PutCategoriaResponse response = new PutCategoriaResponse();
        response.setCategoria(categoriaConvert.mapToCategoriaWs(categoriaActualizada));

        return response;
}
}
