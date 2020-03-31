// panel for score
        JPanel scorePanel = new JPanel();
        JLabel score = new JLabel("Score: 0");
        JLabel time = new JLabel("Time : 60");
        JLabel highScore = new JLabel("High Score: 100");
        scorePanel.add(score);
        scorePanel.add(highScore);
        scorePanel.add(time);
        cardTable.add(scorePanel);
        
//panel for difficulties
        JPanel diffPanel = new JPanel();
        JButton play = new JButton("Play");
        JButton reset = new JButton("Reset");
        String difficultyChoice[] = {"Choose 
	Difficulty","Easy","Medium","Hard"};
        JComboBox difficulty = new JComboBox<>(difficultyChoice);
        diffPanel.add(difficulty);
        diffPanel.add(play);
        diffPanel.add(reset);
        cardTable.add(diffPanel);
