import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Player{
    String playerName;
    Integer playerGoals;
    Integer playerAssists;
    Integer playerTotal;
    String playerTeam;
    public void calcTotal(){
        this.playerTotal=(this.playerAssists+this.playerGoals);
    }
    public void showStats(){
 System.out.println(this.playerTeam+"\n"+ this.playerName+": "+"G - "+this.playerGoals + " A - "+this.playerAssists+ " Total - "+this.playerTotal);
  
    }
}
class Team{
    String teamRating;
    String teamName;
    ArrayList<Player> playersTeam = new ArrayList<>();
    String teamBudget;
    Integer totalGoals=0;
    Integer totalAssists=0;
    Integer teamTotal;
    public void calcRating(){
         if ((this.totalGoals+this.totalAssists)>20){
                        this.teamRating="***";
        }else if((this.totalGoals+this.totalAssists)>=10){
                        this.teamRating="**";
        }else if ((this.totalGoals+this.totalAssists)>0){
                        this.teamRating="*";
        }else if((this.totalGoals+this.totalAssists)==0){
                        this.teamRating="0";
        }
    }
    public void calcTotal(){
        this.teamTotal=(this.totalGoals+this.totalAssists);
    }
    public void showStats(){
        System.out.println("REPORT: Stats per Team\n");
        System.out.println("=".repeat(10)+"\n");

        System.out.println(this.teamName +": G - "+this.totalGoals+ " A - "+this.totalAssists+ " Total - "+(this.totalAssists+totalGoals)+" Budget - $"+this.teamBudget + " Rating: "+ this.teamRating+ " Stars");
  
    }
}


public class main {
    public static void main(String[] args){
            ArrayList<Team> Teams = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
        System.out.println("TEAM ENTRY");
        System.out.println("=".repeat(10)+"\n");
            for (int i = 0; i < 3; i++) {
               System.out.println("Enter a team name: \n"); 
               Team team = new Team();
                String teamName = scanner.nextLine();
                while(teamName.length()<3){
                        System.out.println("Name too short, minimum 3 letters. Enter a team name: \n"); 
                     teamName = scanner.nextLine();
                }
                
                    team.teamName=teamName;
                    Random rand = new Random();
                    double rawRandomNum = rand.nextDouble() * 100000.01;
                    DecimalFormat randomDec = new DecimalFormat("#.00");
                    String randomNum = randomDec.format(rawRandomNum);

                    team.teamBudget=randomNum;
                    for (int d = 0; d < 4; d++) {
                        System.out.println("Enter a player name for team "+teamName+":\n");
                        Player player = new Player();
                        String playerName = scanner.nextLine();
                        while(playerName.length()<3){
                            System.out.println("Name too short, minimum 3 letters. Enter a player name: \n");
                            playerName = scanner.nextLine();
                        }
                        player.playerName = playerName;
                        System.out.println("Enter player goals for player "+playerName+":\n");
                        Integer playerGoals = scanner.nextInt();
                        while(playerGoals<0){
                                 System.out.println("Invalid number, must be 0 or greater please enter goals: \n");
                            playerGoals = scanner.nextInt();
                            
                        }
                        team.totalGoals+=playerGoals;
                        player.playerGoals=playerGoals;
                          System.out.println("Enter player assists for player "+playerName+":\n");
                        Integer playerAssists = scanner.nextInt();
                        while(playerAssists<0){
                             System.out.println("Invalid number, must be 0 or greater please enter assists: \n");
                            playerAssists = scanner.nextInt();

                        }
                        scanner.nextLine();
                        team.totalAssists+=playerAssists;
                        player.playerAssists=playerAssists;
                        team.calcTotal();
                        team.calcRating();
                        player.calcTotal();
                        player.playerTeam=team.teamName;
                        team.playersTeam.add(player);
                    }
                   
                Teams.add(team);
                
            }
            
           for (Team t: Teams){
            t.showStats();
           }
           for (Team t: Teams){
            for (Player player: t.playersTeam){
                player.showStats();
            }
           }

    }
}