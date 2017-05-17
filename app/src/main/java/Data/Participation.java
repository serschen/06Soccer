package Data;

/**
 * Created by Martin on 15.05.2017.
 */


public class Participation {
    private int id;
    private int idGame;
    private int idPlayer;
    private String positions;
    private String team;
    private int goalsGot = 0;
    private int goalsShotDefault = 0;
    private int goalsShotHead = 0;
    private int goalsShotHeadSnow = 0;
    private int goalsShotPenalty = 0;
    private int nutmeg = 0;


    public int getId() {return id;}
    public int getIdGame() {return idGame;}
    public int getIdPlayer() {return idPlayer;}
    public String getPositions() {return positions;}
    public String getTeam() {return team;}
    public int getGoalsGot() {return goalsGot;}
    public int getGoalsShotDefault() {return goalsShotDefault;}
    public int getGoalsShotHead() {
        return goalsShotHead;
    }
    public int getGoalsShotHeadSnow() {
        return goalsShotHeadSnow;
    }
    public int getGoalsShotPenalty() {
        return goalsShotPenalty;
    }
    public int getNutmeg() {
        return nutmeg;
    }

    public void setId (int id) {this.id = id;}
    public void setIdGame (int idGame) {this.idGame = idGame;}
    public void setIdPlayer (int idPlayer) {this.idPlayer = idPlayer;}
    public void setGoalsGot(int goalsGot) {
        this.goalsGot = goalsGot;
    }
    public void setGoalsShotDefault(int goalsShotDefault) {this.goalsShotDefault = goalsShotDefault;}
    public void setGoalsShotHead(int goalsShotHead) {this.goalsShotHead = goalsShotHead;}
    public void setGoalsShotHeadSnow(int goalsShotHeadSnow) {this.goalsShotHeadSnow = goalsShotHeadSnow;}
    public void setGoalsShotPenalty(int goalsShotPenalty) {this.goalsShotPenalty = goalsShotPenalty;}
    public void setNutmeg(int nutmeg) {this.nutmeg = nutmeg;}
    public void setTeam(String team) {this.team = team;}
    public void setPositions(String positions) {this.positions = positions;}

    public Participation(int id, int idGame, int idPlayer,String positions,String team ) {
        setId(id);
        setIdGame(idGame);
        setIdPlayer(idPlayer);
        setPositions(positions);
        setTeam(team);
    }

    /*
    public void addPlayerToTeam(Player Player,Game game, int numberTeam) throws Exception {
        if(numberTeam == 1)
        {
            Participation newParticipation = new Participation(tsParticipation.size() + 1,game.getId(),Player.getID(),Player.getPositionString(),"teamOne");
            tsParticipation.add(newParticipation);
        }

        else if(numberTeam == 2)
        {
            Participation newParticipation = new Participation(tsParticipation.size() + 1,game.getId(),Player.getID(),Player.getPositionString(),"teamTwo");
            tsParticipation.add(newParticipation);
        }
        else
        {
            throw new Exception();
        }

    }

    public void removePlayerFromTeam(Player Player , Game game) throws Exception {
            //Problem mit schleife ts durchgehen und nach playerid und gameid abfragen weil sollte unique sein
            for( Participation p : tsParticipation) {
                if (p.getIdPlayer() == Player.getID() && p.getIdGame() == game.getId()) {
                    tsParticipation.remove(p);
                }
            }
    }
     */


}
