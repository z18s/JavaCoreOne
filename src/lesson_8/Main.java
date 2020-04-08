package lesson_8;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
//        SwingUtilities.invokeLater(GameWindow::new);
        GameWindow gameWindow = new GameWindow();
    }
}

class GameWindow extends JFrame {

    private int fieldSize;
    private JPanel gameField;
    private JPanel sizePanel;
    JButton restartGame;
    JButton quit;
    JButton[][] buttons;

    public GameWindow() {
        setTitle(TicTacToe.NAME);
        setIconImage(new ImageIcon("src\\lesson_8\\icon.png").getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 300, 250, 250);
        setResizable(false);
        initMenu();
        selectSize();
        setVisible(true);
    }

    public void initMenu() {
        JToolBar toolBar = new JToolBar();
        JPanel toolPanel = new JPanel();

        restartGame = new JButton("Restart");
        restartGame.setFocusPainted(false);
        restartGame.setContentAreaFilled(false);
        restartGame.setEnabled(false);
        restartGame.addActionListener(e -> {
            gameField.setVisible(false);
            restartGame.setEnabled(false);
            selectSize();
        });


        quit = new JButton("Quit");
        quit.setFocusPainted(false);
        quit.setContentAreaFilled(false);
        quit.addActionListener(e -> System.exit(0));

        toolPanel.add(restartGame);
        toolPanel.add(quit);
        toolBar.add(toolPanel);
        toolBar.setFloatable(false);

        JLabel footerText = new JLabel("Your turn.");

        add(toolBar, BorderLayout.NORTH);
        add(footerText, BorderLayout.SOUTH);
    }

    public void initGame() {
        TicTacToe ttt = new TicTacToe(fieldSize);

        User user = ttt.getUser();

        gameField = new JPanel();
        gameField.setLayout(new GridLayout(fieldSize, fieldSize));

        buttons = new JButton[fieldSize][fieldSize];
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                JButton button = new JButton(String.valueOf(Mark.NONE.getTitle()));
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22 - fieldSize));
                button.setFocusPainted(false);
                button.setContentAreaFilled(false);
                int finalI = i;
                int finalJ = j;
                button.addActionListener(e -> {
                    if (((JButton) e.getSource()).getText().equals(Mark.NONE.getTitle())) {
                        // >>>>>gameWindow<<<<<
                        ttt.userMove(gameWindow, finalJ, finalI);
                        button.setText(user.getMark().getTitle());
                        user.setMoved(false);
                        try {
                            // >>>>>gameWindow<<<<<
                            ttt.computerMove(gameWindow, fieldSize);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (!((JButton) e.getSource()).getText().equals(Mark.NONE.getTitle())) {
                        button.setContentAreaFilled(true);
                        button.setBackground(Color.LIGHT_GRAY);
                    }
                });

                buttons[i][j] = button;
                gameField.add(buttons[i][j]);
            }
        }

        add(gameField, BorderLayout.CENTER);

        gameField.setVisible(true);
    }

    public void selectSize() {
        sizePanel = new JPanel(new GridLayout(0, 1, 0, 0));
        sizePanel.setBorder(BorderFactory.createTitledBorder("Select field size"));

        String[] sizeLabels = {"3 x 3", "4 x 4", "5 x 5"};
        ButtonGroup sizeButtons = new ButtonGroup();
        for (String sizeLabel : sizeLabels) {
            JRadioButton radio = new JRadioButton(sizeLabel);
            sizePanel.add(radio);
            sizeButtons.add(radio);
            radio.setFocusPainted(false);
            radio.addActionListener(e -> {
                fieldSize = Integer.parseInt(String.valueOf(radio.getText().charAt(0)));
            });
        }

        JButton sizeConfirm = new JButton("Ок");
        sizeConfirm.setFocusPainted(false);
        sizeConfirm.setContentAreaFilled(false);
        sizeConfirm.addActionListener(e -> {
            sizePanel.setVisible(false);
            restartGame.setEnabled(true);
            initGame();
        });

        sizePanel.add(sizeConfirm);
        add(sizePanel, BorderLayout.CENTER);

        sizePanel.setVisible(true);
    }

//    public JButton getButton(int i, int j) {
//        return buttons[i][j];
//    }

    public void setButton(int i, int j, String str) {
        buttons[i][j].setText(str);
        //repaint();
    }
}