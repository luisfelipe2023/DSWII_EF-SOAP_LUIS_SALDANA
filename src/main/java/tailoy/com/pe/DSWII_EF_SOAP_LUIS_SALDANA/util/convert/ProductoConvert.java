package tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.util.convert;

import org.springframework.stereotype.Component;
import pe.com.tailoy.ws.objects.Productows;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.model.Categoria;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.model.Producto;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.model.Proveedor;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductoConvert {

    public Producto mapToProducto(Productows productows, Categoria categoria, Proveedor proveedor) {
        Producto producto = new Producto();
        producto.setId(productows.getId());
        producto.setNombre(productows.getNombre());
        producto.setPrecio(productows.getPrecio());
        producto.setStock(productows.getStock());

        producto.setCategoria(categoria);
        producto.setProveedor(proveedor);

        return producto;
    }

    public Productows mapToProductows(Producto producto) {
        Productows productows = new Productows();
        productows.setId(producto.getId());
        productows.setNombre(producto.getNombre());
        productows.setPrecio(producto.getPrecio());
        productows.setStock(producto.getStock());

        if (producto.getCategoria() != null) {
            productows.setCategoriaId(producto.getCategoria().getId());
        }
        if (producto.getProveedor() != null) {
            productows.setProveedorId(producto.getProveedor().getId());
        }

        return productows;
    }

    public List<Producto> mapToListProducto(List<Productows> productowsList, Categoria categoria, Proveedor proveedor) {
        List<Producto> productoList = new ArrayList<>();
        for (Productows productows : productowsList) {
            productoList.add(mapToProducto(productows, categoria, proveedor));
        }
        return productoList;
    }

    public List<Productows> mapToListProductows(List<Producto> productoList){
        List<Productows> productowsList = new ArrayList<>();
        for (Producto producto : productoList) {
            productowsList.add(mapToProductows(producto));
        }
        return productowsList;
}
}
