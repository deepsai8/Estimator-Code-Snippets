/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Deepak
 */
//Simple modification of "FileEncrypor.java".  The
//previously encrypted "clear.txt.des" is read, decrypted
//and written back as "clear.txt.dcr"

import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;
public class FileDecryptor {
    private static String filename;
    private static String password;
    private static FileInputStream inFile;
    private static FileOutputStream outFile;
 
    /**
     * Note: All kinds of exceptions can be thrown in main.
     * See the API documentation for each method used.
     */
 
    public static void main() throws Exception
    {
 
       // File to decrypt.
 
       filename = "Estimation.sq";
 
       String password = "super_deeps";
 
       inFile = new FileInputStream(filename);
       outFile = new FileOutputStream(filename + "lite");
 
       PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
       SecretKeyFactory keyFactory =
           SecretKeyFactory.getInstance("PBEWithMD5AndDES");
       SecretKey passwordKey = keyFactory.generateSecret(keySpec);
 
       // Read in the previouly stored salt and set the iteration count.
 
       byte[] salt = new byte[8];
       inFile.read(salt);
       int iterations = 100;
 
       PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, iterations);
 
       // Create the cipher and initialize it for decryption.
 
       Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
       cipher.init(Cipher.DECRYPT_MODE, passwordKey, parameterSpec);
 
 
       byte[] input = new byte[64];
       int bytesRead;
       while ((bytesRead = inFile.read(input)) != -1)
       {
          byte[] output = cipher.update(input, 0, bytesRead);
          if (output != null)
             outFile.write(output);
       }
 
       byte[] output = cipher.doFinal();
       if (output != null)
          outFile.write(output);
 
       inFile.close();
       outFile.flush();
       outFile.close();
   }
}
