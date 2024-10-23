package tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.util.convert;

import org.springframework.stereotype.Component;
import pe.com.tailoy.ws.objects.Proveedorows;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.model.Proveedor;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProveedorConvert {


    public Proveedor mapToProveedor(Proveedorows proveedorows) {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(proveedorows.getId());
        proveedor.setNombre(proveedorows.getNombre());
        proveedor.setContacto(proveedorows.getContacto());
        return proveedor;
    }


    public Proveedorows mapToProveedorows(Proveedor proveedor) {
        Proveedorows proveedorows = new Proveedorows();
        proveedorows.setId(proveedor.getId());
        proveedorows.setNombre(proveedor.getNombre());
        proveedorows.setContacto(proveedor.getContacto());
        return proveedorows;
    }


    public List<Proveedor> mapToListProveedor(List<Proveedorows> proveedorowsList) {
        List<Proveedor> proveedores = new ArrayList<>();
        for (Proveedorows proveedorows : proveedorowsList) {
            proveedores.add(mapToProveedor(proveedorows));
        }
        return proveedores;
    }


    public List<Proveedorows> mapToListProveedorows(List<Proveedor> proveedores) {
        List<Proveedorows> proveedorowsList = new ArrayList<>();
        for (Proveedor proveedor : proveedores) {
            proveedorowsList.add(mapToProveedorows(proveedor));
        }
        return proveedorowsList;
    }
}
