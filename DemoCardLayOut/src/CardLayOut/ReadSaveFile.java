package CardLayOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadSaveFile {
	private static final String Word_File = "E:\\WordFile.txt";

	public static boolean saveFile(List<MyWord> list) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Word_File));
			oos.writeObject(list);
			oos.flush();
			oos.close();
			return true;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public static List<MyWord> readFile(List<MyWord> list) {
		List<MyWord> word = new ArrayList<>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Word_File));
			try {
				Object data = ois.readObject();
				word.addAll((List<MyWord>) data);
				ois.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return word;

	}

}
