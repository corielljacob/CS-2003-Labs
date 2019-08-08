package lab11;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class Assignment {
	public static void main(String[] args) {
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:S*.txt*");
		Path p1 = Paths.get("C:\\Backup\\SPEED\\SPEED_20171102_1of10.txt");
		Path filename = p1.getFileName();
		
		matcher = FileSystems.getDefault().getPathMatcher("glob:C:\\\\Backup\\\\SPEED\\\\SPEED_20171102_[1-9]of10*.txt*");
		
		if(matcher.matches(filename))
			System.out.println("hello");
		
	}
}
