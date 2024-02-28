package com.batch26.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.batch26.backend.Model.Region;
import com.batch26.backend.Repository.RegionRepository;

@Controller
@RequestMapping("region")
public class RegionController {
    @Autowired
    private RegionRepository regionRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("regions", regionRepository.findAll());
        return "region/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false) Integer id){
        if(id != null){
            model.addAttribute("region", regionRepository.findById(id));
        }else{
            model.addAttribute("region", new Region());
        }
        return "region/form";
    }

    @PostMapping("save")
    public String insert(Region region){
        regionRepository.save(region);
        Region savedReg = regionRepository.save(region);
        if(savedReg != null){
            return "redirect:/region";
        }
        return "region/form";
    }

    @PostMapping("delete/{id}")
    public String delete(Region region){
        regionRepository.deleteById(region.getId());
        if(regionRepository.findById(region.getId()).isEmpty()){
            return "redirect:/region";
        }
        return "region/form";
    }


}
