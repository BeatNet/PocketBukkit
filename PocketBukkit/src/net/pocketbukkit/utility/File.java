package net.pocketbukkit.utility;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream; //Dont think this is needed but just in case

public class File {
  public static void createFolder(String folder) {
    File dir = new File(folder + "/");
    if(!dir.exists()) {
      dir.mkdir();
    }
  }
  
  public static void createFile(String folder, String file) {
    createFolder(folder);
    File f = new File(folder + "/" + file);
    if(!file.exists()) {
      f.createNewFile();
    }
  }
  
  public static void setProperty(String folder, String file, String propertyName, String property) {
    //TODO: Implement properties
  }
  
  public static void getProperty(String folder, String file, String propertyName) {
    //TODO: Implement properties
  }
  
  public static void checkExists(String folder, String file) {
    File f = new File(folder + "/" + file);
    if(f.exists()) {
      return true;
    }else{
      return false;
    }
  }
}
