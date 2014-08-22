/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.file;

import java.io.File;

public class PluginFile {
public static void createFolder(String folder) {
    File dir = new File(folder + "/"); //For some reason Eclipse is throwing an error for this
    if(!dir.exists()) {
      dir.mkdir();
    }
  }
  
  public static void createFile(String folder, String file) {
    createFolder(folder);
    File finalLocation = new File(folder + file);
    if(!finalLocation.exists()) {
      finalLocation.mkdir();
    }
  }
  
  public static void setProperty(String folder, String file, String propertyName, String property) {
    //TODO: Implement properties
  }
  
  public static void getProperty(String folder, String file, String propertyName) {
    //TODO: Implement properties
  }
  
  public static boolean checkExists(String folder, String file) {
    File finalLocation = new File(folder + "/" + file);
    if(finalLocation.exists()) {
      return true;
    }else{
      return false;
    }
  }
}
