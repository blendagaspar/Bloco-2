package hello.collector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping ("/segundohello")
@RestController
public class SegundohelloController {

@GetMapping
public String segundohello() {
	
	return "Objetivos desta semana será aprender sobre Spring Boot e consolidar os estudos sobre My SQL!!!";
	
	
}
}
