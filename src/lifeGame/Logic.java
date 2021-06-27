package lifeGame;

import java.util.Random;

public final class Logic {

    /**地图信息.*/
    private int[][] gameMap;
    /**地图宽，列.*/
    private int col;
    /**地图长，行.*/
    private int row;
    /**
          * 初始化.
     * @param c 矩阵行数
     * @param r 矩阵列数
     */
    public Logic(final int r, final int c) {
        row = r;
        col = c;
        gameMap = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                gameMap[i][j] = 0;
            }
        }
    }
    /**
          * 获取地图矩阵.
     * @return 地图矩阵的引用
     */
    public int[][] getGameMap() {
        return gameMap;
    }
    /**
          * 循环更新.
     */
    public void gameCycle() {
        int[][] newMap = new int[row][col]; //更新后的地图
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int num = getNeighborCount(i, j);
                if (num < 2 || num > 3) {
                    newMap[i][j] = 0;
                } else if (num == 3) {
                    newMap[i][j] = 1;
                } else {
                    newMap[i][j] = gameMap[i][j];
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                gameMap[i][j] = newMap[i][j];
            }
        }
    }
    /**
          * 随机放lifeRatio细胞.
     * @param lifeRatio 随机放置的细胞数
     */
    public void reset(final int lifeRatio) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                gameMap[i][j] = 0;
            }
        }
        Random r = new Random();
        int j = 0;
        int k = 0;
        for (int i = 0; i < lifeRatio; i++) {
            j = r.nextInt(row);
            k = r.nextInt(col);
            if (gameMap[j][k] == 1) {
                i--;
            } else {
                gameMap[j][k] = 1;
            }
        }
    }
    /**
          * 获取相邻细胞数.
     * @param r 定位细胞行数
     * @param c 定位细胞列数
     * @return 与该细胞相邻的细胞数
     */
    public int getNeighborCount(final int r, final int c) {
        int num = 0;
        //r行c列，r-1行到r+1行，c-1列到c+1列
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (r + i < 0 || r + i > row - 1
                        || c + j < 0 || c + j > col - 1) {
                    continue;
                }
                if (gameMap[r + i][c + j] == 1) {
                    num += 1;
                }
            }
        }
        //除去自己
        if (gameMap[r][c] == 1) {
            num--;
        }
        return num;
    }
    /**
          * 获取矩阵行数.
     * @return 矩阵行数
     */
    public int getCol() {
        return col;
    }
    /**
          * 获取矩阵列数.
     * @return 矩阵列数
     */
    public int getRow() {
        return row;
    }
    /**
          * 设置地图，供单元测试用.
     * @param gameMap 测试用例地图矩阵
     */
    public void setGameMap(final int[][] gameMap) {
        this.gameMap = gameMap;
    }
    /**
          * 清空成员属性，供单元测试使用.
     */
    public void clear() {
        row = 0;
        col = 0;
        gameMap = null;
    }

}
