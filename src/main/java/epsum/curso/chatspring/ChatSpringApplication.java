package epsum.curso.chatspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import epsum.curso.chatspring.ventanas.VentanaChat;
import lombok.Data;

@SpringBootApplication
@Data
public class ChatSpringApplication implements CommandLineRunner {

	@Autowired
	private VentanaChat ventanaChat;
	
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ChatSpringApplication.class);
		builder.headless(false);
		builder.run(args);
 
	}

	@Override
	public void run(String... args) throws Exception {
		
		getVentanaChat().setVisible(true);
	}
	
	

} 
