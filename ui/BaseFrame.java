package ui;

import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame {

    public BaseFrame(String title) {
        setTitle(title);
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
