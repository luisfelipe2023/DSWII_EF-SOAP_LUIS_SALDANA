package tailoy.com.pe.DSWII_EF_SOAP_LUIS_SALDANA.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class CategoriaWsdlConfig {
    @Bean(name = "categoria")
    public DefaultWsdl11Definition productosWsdl11Definition(XsdSchema categoriaEsquema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CategoriaPort");
        wsdl11Definition.setLocationUri("/ws/categoria");
        wsdl11Definition.setTargetNamespace("http://tailoy.com.pe/ws/objects");
        wsdl11Definition.setSchema(categoriaEsquema);

        return wsdl11Definition;
    }
    @Bean
    public XsdSchema categoriaEsquema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/categoria.xsd"));
    }
}
