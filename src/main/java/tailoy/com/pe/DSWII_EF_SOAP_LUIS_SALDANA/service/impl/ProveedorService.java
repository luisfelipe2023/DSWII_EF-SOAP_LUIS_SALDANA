package tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tailoy.ws.objects.*;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.exception.NotFoundException;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.model.Proveedor;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.repository.ProveedorRepository;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.service.IProveedorService;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.util.convert.ProveedorConvert;

import java.util.List;
@Service
public class ProveedorService implements IProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProveedorConvert proveedorConvert;

    @Override
    public GetProveedoresResponse listarProveedores() {
        GetProveedoresResponse response = new GetProveedoresResponse();
        List<Proveedor> proveedores = proveedorRepository.findAll();
        List<Proveedorows> proveedorowsList = proveedorConvert.mapToListProveedorows(proveedores);
        response.getProveedores().addAll(proveedorowsList);
        return response;
    }

    @Override
    public GetProveedorResponse obtenerProveedorPorId(Integer id) {
        GetProveedorResponse response = new GetProveedorResponse();
        Proveedor proveedor = proveedorRepository.findById(id).orElse(null);
        if (proveedor == null) {
            throw new NotFoundException("El Proveedor no existe");
        }
        Proveedorows proveedorows = proveedorConvert.mapToProveedorows(proveedor);
        response.getProveedor().add(proveedorows);
        return  response;
    }


    @Override
    public PostProveedorResponse crearProveedor(PostProveedorRequest request) {
        Proveedorows proveedorWs = request.getProveedor();
        Proveedor nuevoProveedor = proveedorConvert.mapToProveedor(proveedorWs);
        Proveedor proveedorGuardado = proveedorRepository.save(nuevoProveedor);

        PostProveedorResponse response = new PostProveedorResponse();
        response.setProveedor(proveedorConvert.mapToProveedorows(proveedorGuardado));
        return response;
    }

    @Override
    public PutProveedorResponse actualizarProveedor(PutProveedorRequest request) {
        if (request.getProveedor() == null) {
            throw new IllegalArgumentException("El proveedor no puede ser nulo");
        }

        Proveedorows proveedorWs = request.getProveedor();
        Proveedor proveedorExistente = proveedorRepository.findById(proveedorWs.getId())
                .orElseThrow(() -> new NotFoundException("El proveedor con el id " + proveedorWs.getId() + " no existe"));

        proveedorExistente.setNombre(proveedorWs.getNombre());
        proveedorExistente.setContacto(proveedorWs.getContacto());


        Proveedor proveedorActualizado = proveedorRepository.save(proveedorExistente);

        PutProveedorResponse response = new PutProveedorResponse();
        response.setProveedor(proveedorConvert.mapToProveedorows(proveedorActualizado));
        return response;
    }
}
