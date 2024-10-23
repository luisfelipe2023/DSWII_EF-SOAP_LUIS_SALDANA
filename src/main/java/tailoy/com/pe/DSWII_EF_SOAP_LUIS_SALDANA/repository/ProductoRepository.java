package tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto , Long> {
}