package com.portafolio.gcs;

import org.springframework.web.multipart.MultipartFile;

public class UploadObj {
	
	private String directory;
    private String subdirectory;
    private String folder;
    private MultipartFile file;
    private MultipartFile[] files;
    private String path;
    
	public String getDirectory() {
		return directory;
	}
	
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
	public String getSubdirectory() {
		return subdirectory;
	}
	
	public void setSubdirectory(String subdirectory) {
		this.subdirectory = subdirectory;
	}
	
	public String getFolder() {
		return folder;
	}
	
	public void setFolder(String folder) {
		this.folder = folder;
	}
	
	public MultipartFile getFile() {
		return file;
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	public MultipartFile[] getFiles() {
		return files;
	}
	
	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}

}
