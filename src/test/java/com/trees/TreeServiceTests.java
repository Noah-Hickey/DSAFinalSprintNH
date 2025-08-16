package com.trees;

import com.model.BinarySearchTree;
import com.model.TreeResult;
import com.repository.TreeResultRepository;
import com.service.TreeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TreeServiceTests {

    @Mock
    private TreeResultRepository treeResultRepository;

    @InjectMocks
    private TreeService treeService;

    @BeforeEach
    void setUp() {
        // MockitoExtension handles this automatically
    }

    @Test
    void testProcessNumbers_ValidInput() {
        // Given
        String input = "5, 3, 7, 1, 9";
        when(treeResultRepository.save(any(TreeResult.class))).thenReturn(new TreeResult());

        // When
        String result = treeService.processNumbers(input);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("\"value\":5"));
        verify(treeResultRepository, times(1)).save(any(TreeResult.class));
    }

    @Test
    void testProcessNumbers_SingleNumber() {
        // Given
        String input = "42";
        when(treeResultRepository.save(any(TreeResult.class))).thenReturn(new TreeResult());

        // When
        String result = treeService.processNumbers(input);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("\"value\":42"));
        verify(treeResultRepository, times(1)).save(any(TreeResult.class));
    }

    @Test
    void testProcessNumbers_InvalidInput_ThrowsException() {
        // Given
        String input = "abc, def";

        // When/Then
        assertThrows(NumberFormatException.class, () -> {
            treeService.processNumbers(input);
        });
    }
}
