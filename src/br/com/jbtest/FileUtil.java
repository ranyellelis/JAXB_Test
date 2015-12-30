package br.com.jbtest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	
	public static void main(String[] args) {
		File diretorio = new File("C:\\Users\\Admin\\Desktop\\xmls");
		List<File> arquivos = getListaDeArquivos(diretorio);
		System.out.println(arquivos);
	}
	 
	public static void listarArquivos(File diretorio) {
		if (diretorio.isDirectory()) {
			System.out.println("Path");
			System.out.println(diretorio.getPath());
			String[] subDirectory = diretorio.list();
			if (subDirectory != null) {
				System.out.println("Files");
				for (String dir : subDirectory) {
					listarArquivos(new File(diretorio + File.separator + dir));
					System.out.println(diretorio + File.separator + dir);
				}
			}
		}
	}
	
	public static List<File> getListaDeArquivos(File diretorio) {
		List<File> retorno = new ArrayList<File>();
		if (diretorio.isDirectory()) {
			File[] subDirectory = diretorio.listFiles();
			if (subDirectory != null && subDirectory.length > 0) {
				for (File file : subDirectory) {
					retorno.add(file);
				}
			}
		}
		return retorno;
	}
}