package TicTacToe.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameplay")
@CrossOrigin
public class GamePlayController {

    @GetMapping
    public String Index(){
        return "Index Page";
    }
}
