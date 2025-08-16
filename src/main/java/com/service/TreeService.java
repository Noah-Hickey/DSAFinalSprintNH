package com.service;

import com.model.BinarySearchTree;
import com.model.TreeNode;
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


    public TreeNode processNumbersAndGetTree(String numbersInput) {
        try {
            System.out.println("Processing input: " + numbersInput);

            // Parse input numbers
            List<Integer> numbers = parseNumbers(numbersInput);
            System.out.println("Parsed numbers: " + numbers);

            // Create BST
            BinarySearchTree bst = new BinarySearchTree();
            for (Integer number : numbers) {
                bst.insert(number);
            }

            // Get the root node
            TreeNode rootNode = bst.getRoot();
            System.out.println("Created tree with root: " + (rootNode != null ? rootNode.getValue() : "null"));

            // Convert to JSON for database storage
            String treeJson = bst.toJson();

            // Save to database
            TreeResult treeResult = new TreeResult(numbersInput.trim(), treeJson);
            treeResultRepository.save(treeResult);
            System.out.println("Saved to database successfully");

            return rootNode;
        } catch (Exception e) {
            System.err.println("Error in processNumbersAndGetTree: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
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