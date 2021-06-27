package lifeGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LogicTest {
	private static Logic logic = new Logic(1,1);

	@Before
	public void setUp() throws Exception {
		logic.clear();
	}

	@Test
	public void testLogic() {
		logic = new Logic(10, 5);
		assertEquals(10, logic.getRow());
		assertEquals(5, logic.getCol());
		assertEquals(10, logic.getGameMap().length);
		
		for(int i = 0; i < logic.getGameMap().length; i++) {
			assertEquals(5, logic.getGameMap()[i].length);
			for(int j = 0; j < logic.getGameMap()[i].length; j++) {
				assertEquals(0, logic.getGameMap()[i][j]);
			}
		}
	}

	@Test
	public void testGameCycle() {
		logic = new Logic(3, 3);
		int map[][] = {{1, 1, 1},{0, 0, 1},{1, 0, 0}};
		logic.setGameMap(map);
		logic.gameCycle();
		assertEquals(0, logic.getGameMap()[0][0]);
		assertEquals(1, logic.getGameMap()[0][1]);
		assertEquals(1, logic.getGameMap()[0][2]);
		assertEquals(1, logic.getGameMap()[1][0]);
		assertEquals(0, logic.getGameMap()[1][1]);
		assertEquals(1, logic.getGameMap()[1][2]);
		assertEquals(0, logic.getGameMap()[2][0]);
		assertEquals(0, logic.getGameMap()[2][1]);
		assertEquals(0, logic.getGameMap()[2][2]);
		logic.gameCycle();
		assertEquals(0, logic.getGameMap()[0][0]);
		assertEquals(1, logic.getGameMap()[0][1]);
		assertEquals(1, logic.getGameMap()[0][2]);
		assertEquals(0, logic.getGameMap()[1][0]);
		assertEquals(0, logic.getGameMap()[1][1]);
		assertEquals(1, logic.getGameMap()[1][2]);
		assertEquals(0, logic.getGameMap()[2][0]);
		assertEquals(0, logic.getGameMap()[2][1]);
		assertEquals(0, logic.getGameMap()[2][2]);
		logic.gameCycle();
		assertEquals(0, logic.getGameMap()[0][0]);
		assertEquals(1, logic.getGameMap()[0][1]);
		assertEquals(1, logic.getGameMap()[0][2]);
		assertEquals(0, logic.getGameMap()[1][0]);
		assertEquals(1, logic.getGameMap()[1][1]);
		assertEquals(1, logic.getGameMap()[1][2]);
		assertEquals(0, logic.getGameMap()[2][0]);
		assertEquals(0, logic.getGameMap()[2][1]);
		assertEquals(0, logic.getGameMap()[2][2]);
	}

	@Test
	public void testReset() {
		logic = new Logic(2,2);
		logic.reset(4);
		int alive = 0;
		for (int i = 0; i < logic.getGameMap().length; i++) {
			for (int j = 0; j < logic.getGameMap()[i].length; j++) {
				if (logic.getGameMap()[i][j] == 1)
					alive++;
			}
		}
		assertEquals(4,alive);
	}

	@Test
	public void testGetNeighborCount() {
		logic = new Logic(3,3);
		int map[][] = new int[3][3];
		for(int i = 0; i < map.length; i++) {			
			map[i][i] = 1;
		
		}
		logic.setGameMap(map);
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(i == 2 && j != 1 || i == 0 && j != 1)
					assertEquals(1,logic.getNeighborCount(i, j));
				else assertEquals(2,logic.getNeighborCount(i, j));
			}
		}
	}

}
