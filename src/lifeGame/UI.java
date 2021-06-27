package lifeGame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public final class UI extends JFrame {
    /**内容窗格.*/
    private JPanel contentPane;
    /**起始横坐标.*/
    public static final int SX = 20;
    /**起始纵坐标.*/
    public static final int SY = 40;
    /**每个小方格的边长.*/
    public static final int W = 10;
    /**地图信息.*/
    private int[][] filledRect;
    /**
     * Create the frame.
     * @param map 需要画在屏幕上的地图矩阵
     */
    public UI(final int[][] map) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        filledRect = map;
    }
    /**
          * 绘制.
     * @param g 父类方法中需要
     */
    public void paint(final Graphics g) {
        try {
            for (int i = 0; i < filledRect.length; i++) {
                for (int j = 0; j < filledRect[i].length; j++) {
                    if (filledRect[i][j] == 0) {
                        g.setColor(Color.WHITE);
                    } else {
                        g.setColor(Color.BLACK);
                    }
                    g.fillRect(j * W + SX, i * W + SY, W, W); //j列，i行（j， i）
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
