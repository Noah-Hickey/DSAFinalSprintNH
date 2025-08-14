package com.controller;

import com.bstapp.model.TreeResult;
import com.bstapp.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class TreeController {

    @Autowired
    private TreeService treeService;

    @GetMapping("/enter-numbers")
    public String showInputPage() {
        return "input";
    }

    @PostMapping("/process-numbers")
    @ResponseBody
    public ResponseEntity<String> processNumbers(@RequestParam("numbers") String numbers) {
        try {
            String treeJson = treeService.processNumbers(numbers);
            return ResponseEntity.ok(treeJson);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("{\"error\":\"Invalid number format\"}");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("{\"error\":\"Processing failed\"}");
        }
    }

    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
        List<TreeResult> previousTrees = treeService.getAllTreeResults();
        model.addAttribute("trees", previousTrees);
        return "previous";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/enter-numbers";
    }
}