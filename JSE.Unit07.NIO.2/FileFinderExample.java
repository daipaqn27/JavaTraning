/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.java7nio2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import static java.nio.file.FileVisitResult.CONTINUE;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

/**
 *
 * @author PA
 */
public class FileFinderExample {
    public static class Finder extends SimpleFileVisitor<Path>{
        PathMatcher matcher = 
                FileSystems.getDefault().getPathMatcher("glob:*.{txt}");
        public FileVisitResult visitFile(Path path){
            if(matcher.matches(path.getFileName()))
                System.out.println("found" + path);
            return CONTINUE;
        }
    }
    
    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("C:\\Temp"), new Finder());
    }
}
