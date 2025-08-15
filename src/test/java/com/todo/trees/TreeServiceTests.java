package com.todo.trees;

import com.model.BinarySearchTree;
import com.service.TreeService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TreeServiceTests {

    @Test
    void testBinarySearchTreeInsertion() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        assertNotNull(bst.getRoot());
        assertEquals(5, bst.getRoot().getValue());
    }

    @Test
    void testInOrderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        List<Integer> result = bst.inOrderTraversal();
        assertEquals(Arrays.asList(3, 5, 7), result);
    }

    @Test
    void testNumbersParsing() {
        TreeService service = new TreeService();
    }
}

