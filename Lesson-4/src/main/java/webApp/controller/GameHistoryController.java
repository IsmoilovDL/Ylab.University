package webApp.controller;


import com.google.gson.Gson;
import game.resultIO.ReadJSON;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/history")
@CrossOrigin
public class GameHistoryController {
    private static final String FILENAME = ".\\XJSON\\";

    @GetMapping
    public String index(){
        File directory=new File(FILENAME);
        File[] files=directory.listFiles();
        List<String> list=new ArrayList<>();
        for (File name: files){
            list.add(name.getName());
        }

        Gson gson=new Gson();
        return gson.toJson(list);
    }

    @GetMapping("files")
    public String readFile(){
        ReadJSON result=new ReadJSON(FILENAME+"gameSteps_Ali_Bob1647768573148.json");
        Gson gson =new Gson();
        return gson.toJson(result);
    }
}
