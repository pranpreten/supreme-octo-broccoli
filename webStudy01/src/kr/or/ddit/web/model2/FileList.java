package kr.or.ddit.web.model2;

import java.io.File;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class FileList {
	
	File folder = new File("D:\\A_TeachingMaterial\\gitRepo\\webStudy01\\WebContent");

	File[] list = folder.listFiles();
	private String[] filenames = folder.list();
	
	
	public String[] getFileList() {
		return filenames;
	}
	
	public String[] getDetailFileList(String detail) {
		String receivedName ="D:\\A_TeachingMaterial\\\\gitRepo\\\\webStudy01\\\\WebContent\\"+detail;
		File resultFile = new File(receivedName);
		String[] result = resultFile.list();
		return result;
	}
}
