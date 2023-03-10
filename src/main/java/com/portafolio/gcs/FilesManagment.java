package com.portafolio.gcs;

import java.io.File;

public class FilesManagment {

	public static boolean DeleteDirectory(String directory) {
        boolean success = false;
        File folder = new File(directory);
        if (folder.exists() && folder.isDirectory()) {
            for (File f : folder.listFiles()) {
                if (f.delete()) {
                    System.out.println("'" + f.getName() + "' deleted successfully");
                } else {
                    System.out.println("Fail to delete '" + f.getName() + "'");
                }
                if (folder.delete()) {
                    System.out.println("Folder deleted successfully");
                } else {
                    System.out.println("Fail to delete folder");
                }

            }
        }
        return success;
    }
}
