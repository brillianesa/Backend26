package com.batch26.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("form")
    public String form( Model model){
        model.addAttribute("region", new Region());
        return "region/form";
    }

    @PostMapping("save")
    public String insert(Region region){
        regionRepository.save(region);
        if(regionRepository.findById(region.getId()).isPresent()){
            return "redirect:/region";
        }
        return "region/form";
    }


}
