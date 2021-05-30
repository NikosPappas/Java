package magicball;

import java.util.Scanner;

/**
 *
 * @author npappas
 */
public class MagicBall {

    
    private Scanner userInput;
    private String[] answers;
    public MagicBall(){
        userInput=new Scanner(System.in);
        answers=new String[10];
    }
    
    public void start(){
        fillAnswers();
        String input = showMessage();
        while(input.compareTo("exit")!=0){
            int index=getIndex();
            showAnswer(answers[index]);
            input=showMessage();
        }
        closeInput();
    }
    public void fillAnswers(){
        answers[0]="Well, I think it's not your time.";
        answers[1]="Ok.Give it a try, but be carefull.";
        answers[2]="Maybe in a month or two.";
        answers[3]="Now its the opportunity.";
        answers[4]="Can you repeate the question?";
        answers[5]="Ok.Go own.";
        answers[6]="No No No";
        answers[7]="Yes Yes Yes";
        answers[8]="Well I don't think you should try";
        answers[9]="You will have great success.";
    }
    public String showMessage(){
        String question="";
        System.out.print("Enter your question: ");
        question=userInput.nextLine();
        return question;
    }
    
    public int getIndex(){
        return (int)(Math.random()*answers.length);
    }
    
    public void showAnswer(String answer){
        System.out.println(answer);
    }
    public void closeInput(){
        userInput.close();
        System.out.println("Scanner connection closed");
    }
            /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        MagicBall mb = new MagicBall();
        mb.start();
        
    }
    
}
