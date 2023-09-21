package org.example.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class hello {

    public static void main(String[] args) {
        String templateFilePath = "template.txt";
        String outputFilePath = "GeneratedClass.java";
        String annotation = "@MyAnnotation";

        try {
            String templateContent = readTemplateFile(templateFilePath);
            String generatedCode = generateCodeWithAnnotation(templateContent, annotation);
            writeGeneratedCodeToFile(generatedCode, outputFilePath);
            System.out.println("Java code with annotation generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readTemplateFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes);
    }

    private static String generateCodeWithAnnotation(String templateContent, String annotation) {
        StringBuilder generatedCode = new StringBuilder();

        // Add the annotation to each line of the template code
        String[] lines = templateContent.split(System.lineSeparator());
        for (String line : lines) {
            generatedCode.append(annotation).append(" ").append(line).append(System.lineSeparator());
        }

        return generatedCode.toString();
    }

    private static void writeGeneratedCodeToFile(String generatedCode, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(generatedCode);
        }
    }
}