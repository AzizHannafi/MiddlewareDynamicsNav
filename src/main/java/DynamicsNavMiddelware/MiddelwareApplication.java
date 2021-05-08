package DynamicsNavMiddelware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages={"Controller", "Services","Ntlm","Configuration","Entity"},
					   exclude={SecurityAutoConfiguration.class})
public class MiddelwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiddelwareApplication.class, args);
		System.out.println("Connection succeeded  Nice \n"
				+ "Server working at http://localhost:8000");
	}

}
