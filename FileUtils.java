/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Deepak
 */
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {
    public static boolean renameFileExtension
  (String source, String newExtension)
  {
    String target;
    String currentExtension = getFileExtension(source);

    if (currentExtension.equals("")){
      target = source + "." + newExtension;
    }
    else {
      target = source.replaceFirst(Pattern.quote("." +
          currentExtension) + "$", Matcher.quoteReplacement("." + newExtension));

    }
    return new File(source).renameTo(new File(target));
  }

  public static String getFileExtension(String f) {
    String ext = "";
    int i = f.lastIndexOf('.');
    if (i > 0 &&  i < f.length() - 1) {
      ext = f.substring(i + 1);
    }
    return ext;
  }

  public static void main(String args[]) throws Exception {
    System.out.println(
         FileUtils.renameFileExtension("C:/temp/capture.pdf", "pdfa")
         );
  }
}
