package tooltiptext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import list.ButtonList;

/**
 * 각 보드 판의 설명 tool tip을 보여주는 클래스입니다.
 * 
 * @author MsEmily1020
 * @version 1.0
 *
 */
public class CountryButtonToolTipText {
	public CountryButtonToolTipText() {
		var buttonList = ButtonList.getArr();	// 버튼의 리스트
		int i = 0;
		try {
			BufferedReader bufReader = new BufferedReader(
					new FileReader(new File("./datafiles/CountryButtonToolTipList.txt")));	// tool tip에 넣을 txt 내용 가져옴
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				buttonList.get(i++).setToolTipText(line);
			}

			bufReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ButtonList.setArr(buttonList);
	}
}
