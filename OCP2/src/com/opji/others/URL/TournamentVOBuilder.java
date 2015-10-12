package com.opji.others.URL;

import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class TournamentVOBuilder {

	public static TournamentVO build(Element e, int year) {
		TournamentVO tournamentVO = new TournamentVO();

		tournamentVO.setYear(year);

		List<Node> listaNodos = e.childNodes();
		contruyeNodos(listaNodos, tournamentVO);
		return tournamentVO;
	}

	/*
	 * <td class="g">8</td>0 <td class="min">220</td>1 <td
	 * class="ma">64/98</td>2 <td class="per">65.3</td>3 <td
	 * class="ma">64/94</td>4 <td class="per">68.1</td>5 <td
	 * class="ma">0/4</td>6 <td class="per">0</td>7 <td class="ma">29/47</td>8
	 * <td class="per">61.7</td>9 <td class="o">23</td>10 <td
	 * class="d">33</td>11 <td class="tot">56</td>13 <td class="a">14</td>14 <td
	 * class="pf">12</td>15 <td class="t">23</td>16 <td class="st">5</td>17 <td
	 * class="bs">9</td>18 <td class="pts">157</td>
	 */
	private static void contruyeNodos(List<Node> listaNodos, TournamentVO tournamentVO) {

		String[] separa = null;
		int i = 0;

		Element[] arrList = new Element[19];
		for (Node nodo : listaNodos) {
			if (nodo instanceof Element) {
				arrList[i] = (Element) nodo;
				i++;
			}
		}

		tournamentVO.setGames(Integer.valueOf(arrList[0].text()));
		tournamentVO.setMin(Integer.valueOf(arrList[1].text()));
		separa = arrList[2].text().split("/");
		tournamentVO.setFg(Integer.valueOf(separa[0]));
		tournamentVO.setFga(Integer.valueOf(separa[1]));
		separa = arrList[4].text().split("/");
		tournamentVO.setFg2(Integer.valueOf(separa[0]));
		tournamentVO.setFga2(Integer.valueOf(separa[1]));
		separa = arrList[6].text().split("/");
		tournamentVO.setFg3(Integer.valueOf(separa[0]));
		tournamentVO.setFga3(Integer.valueOf(separa[1]));
		separa = arrList[8].text().split("/");
		tournamentVO.setFt(Integer.valueOf(separa[0]));
		tournamentVO.setFqa(Integer.valueOf(separa[1]));
		tournamentVO.setOfr(Integer.valueOf(arrList[10].text()));
		tournamentVO.setDefr(Integer.valueOf(arrList[11].text()));
		tournamentVO.setTotr(Integer.valueOf(arrList[12].text()));
		tournamentVO.setAs(Integer.valueOf(arrList[13].text()));
		tournamentVO.setPf(Integer.valueOf(arrList[14].text()));
		tournamentVO.setTo(Integer.valueOf(arrList[15].text()));
		tournamentVO.setSt(Integer.valueOf(arrList[16].text()));
		tournamentVO.setBs(Integer.valueOf(arrList[17].text()));
		tournamentVO.setPts(Integer.valueOf(arrList[18].text()));

		System.out.println(i);

	}

}
