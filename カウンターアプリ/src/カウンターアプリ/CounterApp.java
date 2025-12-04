package カウンターアプリ;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CounterApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("カウンター");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("0000");
        label.setFont(new Font("SansSerif", Font.BOLD, 36));

        JButton countBtn = new JButton("カウント");
        JButton resetBtn = new JButton("リセット");

        // カウンター変数
        final int[] counter = {0};

        // カウントボタン
        countBtn.addActionListener(e -> {
            if (counter[0] < 9999) {
                counter[0]++;
            }
            label.setText(String.format("%04d", counter[0]));
        });

        // リセットボタン
        resetBtn.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(
                    frame,
                    "カウンターをリセットしますか？",
                    "確認",
                    JOptionPane.YES_NO_OPTION
            );

            if (result == JOptionPane.YES_OPTION) {
                counter[0] = 0;
                label.setText("0000");
            }
        });

        frame.add(label);
        frame.add(countBtn);
        frame.add(resetBtn);
        frame.setVisible(true);
    }
}
