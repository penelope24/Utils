package fy.jp;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.io.InputStream;

public class JPHelper {

    public static CompilationUnit getCompilationUnit(InputStream in) {
        try {
            CompilationUnit cu;
            try {
                cu = StaticJavaParser.parse(in);
                return cu;
            }
            finally {
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static CompilationUnit getCompilationUnit(String input) {
        try {
            CompilationUnit cu;
            cu = StaticJavaParser.parse(new File(input));
            return cu;
        } catch (Exception e) {
            System.out.println("issue file : " + input);
//            e.printStackTrace();
        }
        return null;
    }
}
