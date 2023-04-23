package co.edu.uniquindio.unimarket.servicios.implementaciones;

import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailServicioImp implements EmailServicio {
    private final JavaMailSender jms;
    @Override
    public boolean enviarEmail(String asunto, String contenido, String destino) throws Exception {
        MimeMessage mensaje = jms.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);
        try {
            helper.setSubject(asunto);
            helper.setText(contenido);
            helper.setTo(destino);
            helper.setFrom("no_reply@dominio.com");
            jms.send(mensaje);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}