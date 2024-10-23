package tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.util.convert;

import org.springframework.stereotype.Component;
import pe.com.tailoy.ws.objects.Categoriaows;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.model.Categoria;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaConvert {
    public Categoria mapToCategoria(Categoriaows categoriaWs) {
        Categoria categoria = new Categoria();
        categoria.setId(categoriaWs.getId());
        categoria.setNombre(categoriaWs.getNombre());
        return categoria;
    }

    public Categoriaows mapToCategoriaWs(Categoria categoria) {
        Categoriaows categoriaWs = new Categoriaows();
        categoriaWs.setId(categoria.getId());
        categoriaWs.setNombre(categoria.getNombre());
        return categoriaWs;
    }

    public List<Categoria> mapToListCategoria(List<Categoriaows> categoriaWsList) {
        List<Categoria> categoriaList = new ArrayList<>();
        for (Categoriaows categoriaWs : categoriaWsList) {
            categoriaList.add(mapToCategoria(categoriaWs));
        }
        return categoriaList;
    }

    public List<Categoriaows> mapToListCategoriaWs(List<Categoria> categoriaList) {
        List<Categoriaows> categoriaWsList = new ArrayList<>();
        for (Categoria categoria : categoriaList) {
            categoriaWsList.add(mapToCategoriaWs(categoria));
        }
        return categoriaWsList;
    }
}
