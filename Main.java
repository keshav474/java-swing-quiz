package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

class Quiz extends JFrame implements ActionListener{

    String[] questions = 	{
            "Who is the author of the book 'Nineteen Eighty Four'?",
            "Who has written the book 'My Frozen Turbulence in Kashmir'?",
            "Which was the 1st non Test playing country to beat India in an international match?",
            "Who was the first Indian to win an olympics athletics  gold?",
            "Who was the first Indian to win the World Amateur Billiards title?",
    };
    String[][] options = 	{
            {"Thomas Hardy","Emile Zola","George Orwell","Walter Scott"},
            {"M.J Akbar","Jagmohan","J.Nehru","Anees Jung"},
            {"USA","Kenya","Sri Lanka","Afghanistan"},
            {"Neeraj Chopra","Abhinav Bindra","PV Sindhu","Milka Singh"},
            {"Geet Sethi","Manoj Kathori","Keshav Gupta","Wilson Jones"}
    };
    char[] answers = {'C', 'B', 'C', 'A', 'D' };
    String naam;
    char answer;
    int index=0;
    int correct_guesses =0;
    int total_questions = questions.length;
    int result;
    int seconds=10;

    JTextField name= new JTextField();
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton Button0 = new JButton("Start Test");
    JButton Button1 = new JButton();
    JButton Button2 = new JButton();
    JButton Button3 = new JButton();
    JButton Button4 = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();
    JTextField creator = new JTextField();

    Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if(seconds<=0) {
                displayAnswer();
            }
        }
    });



    public Quiz() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650,700);
        getContentPane().setBackground(new Color(255,255,255));
        setLayout(null);
        setResizable(false);

        textfield.setBounds(0,0,650,50);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(50,50,200));
        textfield.setFont(new Font("New Roman",Font.BOLD,30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea.setBounds(0,50,650,100);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25,25,25));
        textarea.setForeground(new Color(25,255,0));
        textarea.setFont(new Font("NEW ROMAN",Font.BOLD,25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);

        Button1.setBounds(0,150,100,100);
        Button1.setFont(new Font("NEW ROMAN",Font.BOLD,35));
        Button1.setFocusable(false);
        Button1.addActionListener(this);
        Button1.setText("A");

        Button2.setBounds(0,250,100,100);
        Button2.setFont(new Font("NEW ROMAN",Font.BOLD,35));
        Button2.setFocusable(false);
        Button2.addActionListener(this);
        Button2.setText("B");

        Button3.setBounds(0,350,100,100);
        Button3.setFont(new Font("NEW ROMAN",Font.BOLD,35));
        Button3.setFocusable(false);
        Button3.addActionListener(this);
        Button3.setText("C");

        Button4.setBounds(0,450,100,100);
        Button4.setFont(new Font("NEW ROMAN",Font.BOLD,35));
        Button4.setFocusable(false);
        Button4.addActionListener(this);
        Button4.setText("D");

        answer_labelA.setBounds(125,150,500,100);
        answer_labelA.setBackground(new Color(50,50,50));
        answer_labelA.setForeground(new Color(25,255,0));
        answer_labelA.setFont(new Font("NEW ROMAN",Font.PLAIN,35));

        answer_labelB.setBounds(125,250,500,100);
        answer_labelB.setBackground(new Color(50,50,50));
        answer_labelB.setForeground(new Color(25,255,0));
        answer_labelB.setFont(new Font("NEW ROMAN",Font.PLAIN,35));

        answer_labelC.setBounds(125,350,500,100);
        answer_labelC.setBackground(new Color(50,50,50));
        answer_labelC.setForeground(new Color(25,255,0));
        answer_labelC.setFont(new Font("NEW ROMAN",Font.PLAIN,35));

        answer_labelD.setBounds(125,450,500,100);
        answer_labelD.setBackground(new Color(50,50,50));
        answer_labelD.setForeground(new Color(25,255,0));
        answer_labelD.setFont(new Font("NEW ROMAN",Font.PLAIN,35));

        seconds_left.setBounds(535,510,100,150);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(0,255,255));
        seconds_left.setFont(new Font("NEW ROMAN",Font.BOLD,60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_label.setBounds(535,475,100,25);
        time_label.setBackground(new Color(50,50,50));
        time_label.setForeground(new Color(255,0,0));
        time_label.setFont(new Font("NEW ROMAN",Font.PLAIN,16));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("timer ");

        setVisible(true);

//        add(time_label);
//        add(seconds_left);
//        add(answer_labelA);
//        add(answer_labelB);
//        add(answer_labelC);
//        add(answer_labelD);
//        add(Button1);
//        add(Button2);
//        add(Button3);
//        add(Button4);
//        add(textarea);
//        add(textfield);
//            timer.stop();

        setVisible(true);

        nextQuestion();


    }

//    public void info(){
////        timer.stop();
//        name.setBackground(Color.BLACK);
//        name.setForeground(Color.green);
//        name.setFont(new Font("consoals",Font.PLAIN,35));
//        name.setPreferredSize(new Dimension(325,60));
//        name.setBounds(81,370,325,60);
//        Button0.addActionListener(this);
//        Button0.setBounds(575,450,75,100);
//        Button0.setFont(new Font("NEW ROMAN",Font.BOLD,5));
//
//        add(name);
//        add(Button0);
//
//    }
//    public void actionPerfomed(ActionEvent e)
//    {
//        if(e.getSource()==Button0)
//        {
//            naam=name.getText();
//            timer.start();
//        add(time_label);
//        add(seconds_left);
//        add(answer_labelA);
//        add(answer_labelB);
//        add(answer_labelC);
//        add(answer_labelD);
//        add(Button1);
//        add(Button2);
//        add(Button3);
//        add(Button4);
//        add(textarea);
//        add(textfield);
////        setVisible(true);
////        nextQuestion();
//        }
//    }


    public void nextQuestion() {

        add(time_label);
        add(seconds_left);
        add(answer_labelA);
        add(answer_labelB);
        add(answer_labelC);
        add(answer_labelD);
        add(Button1);
        add(Button2);
        add(Button3);
        add(Button4);
        add(textarea);
        add(textfield);
        setVisible(true);

        Button0.setBounds(0,650,0,0);
        name.setBounds(0,650,0,0);
        if(index>=total_questions) {
            results();
        }
        else {
            textfield.setText("Question "+(index+1));
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();
        }


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        Button0.setBounds(0,650,0,0);
        name.setBounds(0,650,0,0);
        Button1.setEnabled(false);
        Button2.setEnabled(false);
        Button3.setEnabled(false);
        Button4.setEnabled(false);

        if(e.getSource()==Button1) {
            answer= 'A';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource()==Button2) {
            answer= 'B';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource()==Button3) {
            answer= 'C';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource()==Button4) {
            answer= 'D';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        displayAnswer();
    }
    public void displayAnswer() {

        timer.stop();
        Button0.setBounds(0,650,0,0);
        name.setBounds(0,650,0,0);
        Button1.setEnabled(false);
        Button2.setEnabled(false);
        Button3.setEnabled(false);
        Button4.setEnabled(false);

        if(answers[index] != 'A')
            answer_labelA.setForeground(new Color(255,0,0));
        if(answers[index] != 'B')
            answer_labelB.setForeground(new Color(255,0,0));
        if(answers[index] != 'C')
            answer_labelC.setForeground(new Color(255,0,0));
        if(answers[index] != 'D')
            answer_labelD.setForeground(new Color(255,0,0));

        Timer pause = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                answer_labelA.setForeground(new Color(25,255,0));
                answer_labelB.setForeground(new Color(25,255,0));
                answer_labelC.setForeground(new Color(25,255,0));
                answer_labelD.setForeground(new Color(25,255,0));

                answer = ' ';
                seconds=10;
                seconds_left.setText(String.valueOf(seconds));
                Button1.setEnabled(true);
                Button2.setEnabled(true);
                Button3.setEnabled(true);
                Button4.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }
    public void results(){
        Button0.setBounds(0,650,0,0);
        name.setBounds(0,650,0,0);

        Button1.setBounds(0,0,0,0);
        Button2.setBounds(0,0,0,0);
        Button3.setBounds(0,0,0,0);
        Button4.setBounds(0,0,0,0);

        number_right.setBounds(0,225,650,100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(25,255,0));
        number_right.setFont(new Font("NEW ROMAN",Font.BOLD,50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(0,325,650,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("NEW ROMAN",Font.BOLD,20));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        result = (int)((correct_guesses/(double)total_questions)*100);

        textfield.setBackground(Color.WHITE);
        textfield.setBounds(0,50,650,50);
        textfield.setText("RESULT");

        textarea.setBounds(0,0,0,0);
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");
        seconds_left.setBounds(535,510,0,0);
        time_label.setBounds(535,475,0,0);

        creator.setBounds(0,630,200,20);
        creator.setFont(new Font("algerian",Font.BOLD,15));
        creator.setEnabled(false);
        creator.setBackground(Color.BLACK);
        creator.setForeground(Color.CYAN);

        creator.setText("made by Keshav Gupta");
        number_right.setText("correct answers ("+correct_guesses+"/"+total_questions+")");
        if(correct_guesses==questions.length)
            percentage.setText(result+"% marks  Great job!!");
        else
            percentage.setText(result+"% marks    try to score better next time");


        add(number_right);
        add(percentage);
        add(creator);

    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        Quiz a=new Quiz();
    }
}
