import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToe {
    int bwidth = 600; // each 50px for each box
    int bheight = 650; // 50px for the text panel
    
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    JButton[][] board = new JButton[3][3];
    JButton retryButton = new JButton("Retry");  // Retry button
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;

    boolean gameOver = false;
    int turns = 0;

    TicTacToe(){
        frame.setVisible(true);
        frame.setSize(bwidth, bheight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.DARK_GRAY);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.LIGHT_GRAY);
        frame.add(boardPanel);

        for (int rw = 0; rw < 3; rw++){
            for (int cl = 0; cl < 3; cl++){
                JButton tile = new JButton();
                board[rw][cl] = tile;
                boardPanel.add(tile);

                tile.setBackground(Color.lightGray);
                tile.setForeground(Color.white);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);


                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        if (gameOver) return;
                        JButton tile = (JButton) e.getSource();
                        if (tile.getText() == ""){
                            tile.setText(currentPlayer);
                            turns++;
                            checkWinner();
                            if (!gameOver){
                                currentPlayer = currentPlayer == playerX ? playerO : playerX;
                                textLabel.setText(currentPlayer + " 's turn.");
                            }
                        }
                        
                    }
                    
                });
            }
        }

        // Configure retry button
    retryButton.setFont(new Font("Arial", Font.BOLD, 20));
    retryButton.setFocusable(false);
    retryButton.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e) {
            resetGame();
        }
        });

        buttonPanel.add(retryButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
    
    }

    

    void checkWinner(){
        //Horizontally
        for (int rw = 0; rw < 3; rw++ ){
            if (board[rw][0].getText() == "") continue;

            if (board[rw][0].getText() == board[rw][1].getText() && 
                board[rw][1].getText() == board[rw][2].getText()) {
                for (int i = 0; i < 3; i++){
                    setWinner(board[rw][i]);
                }
                gameOver = true;
                return;
               }
        }
        //Vertically
        for (int cl = 0; cl < 3; cl++ ){
            if (board[0][cl].getText() == "") continue;

            if (board[0][cl].getText() == board[1][cl].getText() && 
                board[1][cl].getText() == board[2][cl].getText()) {
                for (int i = 0; i < 3; i++){
                    setWinner(board[i][cl]);
                }
                gameOver = true;
                return;
               }
        }

        //Diagonals
        for (int i = 0; i < 2; i++) {
            // For i = 0, check the main diagonal; for i = 1, check the anti-diagonal
            if (board[0][i * 2].getText() == board[1][1].getText() && 
                board[1][1].getText() == board[2][2 - i * 2].getText() &&
                !board[0][i * 2].getText().equals("")) {
                
                // Set color for the corresponding diagonal
                for (int j = 0; j < 3; j++) {
                    setWinner(board[j][Math.abs(j - i * 2)]);
                }
                gameOver = true;
                return;
            }
        }
        

                if (turns == 9) {
                    for (int rw = 0; rw < 3; rw++ ){
                        for (int cl = 0; cl < 3; cl++ ){
                            setTie(board[rw][cl]);
                        }
                    }
                    gameOver = true;
                }
        }
    

    void setWinner(JButton tile){
        tile.setForeground(Color.GREEN);
        tile.setBackground(Color.LIGHT_GRAY);
        textLabel.setText(currentPlayer + " Won!!!");
    }

    void setTie(JButton tile){
        tile.setForeground(Color.PINK);
        tile.setBackground(Color.gray);
        textLabel.setText("Tie!");
    }

    void resetGame() {
        currentPlayer = playerX;
        turns = 0;
        gameOver = false;
        textLabel.setText("Tic-Tac-Toe");

        for (int rw = 0; rw < 3; rw++) {
            for (int cl = 0; cl < 3; cl++) {
                board[rw][cl].setText("");
                board[rw][cl].setBackground(Color.lightGray);
                board[rw][cl].setForeground(Color.white);
            }
        }
    }
}
