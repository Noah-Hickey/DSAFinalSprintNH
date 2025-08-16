package com.controller;

import com.model.TreeNode;
import com.model.TreeResult;
import com.service.TreeService;
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
    public ResponseEntity<TreeNode> processNumbers(@RequestParam("numbers") String numbers) {
        try {
            // Get the actual TreeNode object instead of JSON string
            TreeNode rootNode = treeService.processNumbersAndGetTree(numbers);
            return ResponseEntity.ok(rootNode);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
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