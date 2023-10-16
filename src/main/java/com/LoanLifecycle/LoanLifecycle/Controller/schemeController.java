package com.LoanLifecycle.LoanLifecycle.Controller;
import com.LoanLifecycle.LoanLifecycle.Entity.SchemeEntity;
import com.LoanLifecycle.LoanLifecycle.Service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Scheme")
public class schemeController {

    @Autowired
    private SchemeService schemeService;

    @GetMapping
    public List<SchemeEntity> getAllScheme(){
        return schemeService.getAllSchemes();
    }

    @GetMapping("/{SchemeId}")
    public SchemeEntity GetSchemeById( @PathVariable int SchemeId){
       return schemeService.getSchemeId(SchemeId);

    }

    @PostMapping
    public String SaveScheme(@RequestBody SchemeEntity schemeData){
        return schemeService.SaveScheme(schemeData);

    }

    @PutMapping("{SchemeId}")
    public String UpdateScheme(@PathVariable int SchemeId,@RequestBody SchemeEntity schemeData){
        schemeService.updateScheme(SchemeId,schemeData);
        return "Updated Scheme";
    }

    @DeleteMapping("{SchemeId}")
    public String DeleteScheme(@PathVariable int SchemeId){
        schemeService.DeleteScheme(SchemeId);
        return "Scheme Deleted";
    }


}
