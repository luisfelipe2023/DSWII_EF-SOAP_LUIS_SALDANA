package tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.tailoy.ws.objects.*;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.exception.NotFoundException;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.model.Categoria;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.model.Producto;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.model.Proveedor;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.repository.CategoriaRepository;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.repository.ProductoRepository;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.repository.ProveedorRepository;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.util.convert.ProductoConvert;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ProductService implements IProductoService {
    private final ProductoRepository productoRepository;
    private final ProductoConvert productoConvert;
    private final CategoriaRepository categoriaRepository;
    private final ProveedorRepository proveedorRepository;

    @Override
    public GetProductosResponse listarProductos() {
        GetProductosResponse getProductosResponse = new GetProductosResponse();
        getProductosResponse.getProductos().addAll(
                productoConvert.mapToListProductows(productoRepository.findAll())
        );
        return getProductosResponse;
    }

    @Override
    public GetProductoResponse obtenerProductoPorId(Long id) {
        GetProductoResponse getProductoResponse = new GetProductoResponse();
        Producto producto = productoRepository.findById(id).orElse(null);
        if(producto == null){
            throw  new NotFoundException("El Porducto con el id" + id + " no existe");
        }
        getProductoResponse.setProducto(productoConvert.mapToProductows(producto));
        return getProductoResponse;
    }

    @Override
    public PostProductResponse crearProducto(PostProductRequest request) {
        if (request.getProducto() == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        Productows productows = request.getProducto();
        Categoria categoria = categoriaRepository.findById(productows.getCategoriaId())
                .orElseThrow(() -> new NotFoundException("Categoría no encontrada"));
        Proveedor proveedor = proveedorRepository.findById(productows.getProveedorId())
                .orElseThrow(() -> new NotFoundException("Proveedor no encontrado"));
        Producto nuevoProducto = productoConvert.mapToProducto(productows, categoria, proveedor);

        Producto productoGuardado = productoRepository.save(nuevoProducto);

        PostProductResponse response = new PostProductResponse();
        response.setProducto(productoConvert.mapToProductows(productoGuardado));

        return response;
    }

    @Override
    public PutProductResponse actualizarProducto(PutProductRequest request) {
        if (request.getProducto() == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }

        Productows productows = request.getProducto();
        Producto productoExistente = productoRepository.findById(productows.getId())
                .orElseThrow(() -> new NotFoundException("El producto con el id " + productows.getId() + " no existe"));

        Categoria categoria = categoriaRepository.findById(productows.getCategoriaId())
                .orElseThrow(() -> new NotFoundException("Categoría no encontrada"));
        Proveedor proveedor = proveedorRepository.findById(productows.getProveedorId())
                .orElseThrow(() -> new NotFoundException("Proveedor no encontrado"));


        productoExistente.setNombre(productows.getNombre());
        productoExistente.setPrecio(productows.getPrecio());
        productoExistente.setStock(productows.getStock());
        productoExistente.setCategoria(categoria);
        productoExistente.setProveedor(proveedor);

        Producto productoActualizado = productoRepository.save(productoExistente);

        PutProductResponse response = new PutProductResponse();
        response.setProducto(productoConvert.mapToProductows(productoActualizado));

        return response;
    }
}
