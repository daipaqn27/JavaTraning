/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java7nio2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import static java.nio.file.FileVisitResult.CONTINUE;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 *
 * @author PA
 */
public class FileVisitorExample {
    public static class PrintFiles extends SimpleFileVisitor<Path>{
        public FileVisitResult visitFile(Path path){
            System.out.println(path + "is file!");
            return CONTINUE;
    }
        public FileVisitResult postVisitDirectory(Path dir){
            System.out.println(dir + "is directory!");
            return CONTINUE;
        }
    }
    
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Temp");
        Files.walkFileTree(path, new PrintFiles());
    }
}
