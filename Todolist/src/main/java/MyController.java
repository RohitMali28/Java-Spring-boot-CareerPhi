import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapp")
public class MyController {
    @GetMapping("/")
    public String home() {
        return "Welcome to the Todo List Application!";
    }
}