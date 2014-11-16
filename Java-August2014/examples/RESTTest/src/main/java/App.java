
import org.springframework.web.client.RestTemplate;
import org.springframework.http.converter.xml.Jaxb2CollectionHttpMessageConverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class App {
    
    public static void main(String[] args) {
        RestTemplate r = new RestTemplate();
        r.getMessageConverters().add(new Jaxb2CollectionHttpMessageConverter());
        
        String message = r.getForObject("http://www.thomas-bayer.com/sqlrest/CUSTOMER/1", String.class);
        
        System.out.println(message);
        
   }
    
    
}
