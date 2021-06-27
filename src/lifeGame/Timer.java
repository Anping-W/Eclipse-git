package lifeGame;

public final class Timer extends Thread {

    /**游戏逻辑.*/
    private Logic logic;
    /**游戏界面.*/
    private UI frame;

    /**
          * 程序入口.
     * @param args 控制台参数
     */
    public static void main(final String[] args) {
        int row = 50;
        int col = 50;
        Logic logic = new Logic(row, col); //初始化地图行列数
        UI frame = new UI(logic.getGameMap()); //初始化窗口
        frame.setSize(row * UI.W + UI.SX + 20, col * UI.W + UI.SY + 20);
        frame.setVisible(true);
        logic.reset(row * col / 2); //随机设置细胞数
        new Timer(logic, frame).start(); //开启线程
        }

    /**
          * 初始化计时器.
     * @param l 初始化成员logic
     * @param f 初始化成员frame
     */
        public Timer(final Logic l, final UI f) {
        logic = l;
        frame = f;
    }

    /**
          * 每隔50毫秒刷新一次游戏进度.
     */
    public void run() {
        try {
            while (true) {
                frame.paint(frame.getGraphics());
                sleep(50);
                logic.gameCycle();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
