package com.service;

import com.model.BinarySearchTree;
import com.model.TreeResult;
import com.repository.TreeResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreeService {

    @Autowired
    private TreeResultRepository treeResultRepository;

    public String processNumbers(String numbersInput) {
        // Parse input numbers
        List<Integer> numbers = parseNumbers(numbersInput);

        // Create BST
        BinarySearchTree bst = new BinarySearchTree();
        for (Integer number : numbers) {
            bst.insert(number);
        }

        // Convert to JSON
        String treeJson = bst.toJson();

        // Save to database
        TreeResult treeResult = new TreeResult(numbersInput.trim(), treeJson);
        treeResultRepository.save(treeResult);

        return treeJson;
    }

    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split("[,\\s]+"))
                .filter(s -> !s.isEmpty())
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<TreeResult> getAllTreeResults() {
        return treeResultRepository.findAllByOrderByCreatedAtDesc();
    }

    public BinarySearchTree createBSTFromNumbers(List<Integer> numbers) {
        BinarySearchTree bst = new BinarySearchTree();
        for (Integer number : numbers) {
            bst.insert(number);
        }
        return bst;
    }
}