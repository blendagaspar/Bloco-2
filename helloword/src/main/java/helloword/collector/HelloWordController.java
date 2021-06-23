package helloword.collector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/helloword")
@RestController
public class HelloWordController {
@GetMapping
	public String helloword() {
	
	
	return " A habilidade que eu usei para fazer esta atividade foi"
			+ "  a persistencia e a mentalidade de crescimento";	
	
	
}
	
	
}
