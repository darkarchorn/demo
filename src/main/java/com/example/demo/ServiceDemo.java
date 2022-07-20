// Java Program to Illustrate Component class
package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.*;

// Annotation
@Component
@Service
public class ServiceDemo {
    public int factorial(int n)
    {
        // Base case
        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }
}