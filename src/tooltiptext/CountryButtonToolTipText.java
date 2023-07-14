package tooltiptext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import list.ButtonList;

public class CountryButtonToolTipText {
	public CountryButtonToolTipText() {
		var buttonList = ButtonList.getArr();
		int i = 0;
		try {
			BufferedReader bufReader = new BufferedReader(
					new FileReader(new File("./datafiles/CountryButtonToolTipList.txt")));
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				buttonList.get(i++).setToolTipText(line);
			}

			bufReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
