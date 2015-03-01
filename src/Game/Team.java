package game;

import java.util.ArrayList;
import java.util.List;
import strategies.*;


public class Team {
  final List<Player> team;

  public static class TeamBuilder {
      List<Player> players = new ArrayList<>();
      int def = 0;
      int coop = 0; 
      int tit = 0; 
      int ran = 0; 
      int titF = 0; 
      int less = 0; 
      int avg85 = 0; 
      int lm = 0; 
      int cmp = 0; 
      int avg50 = 0; 
      int antiTFT = 0;
      
    public TeamBuilder setDef(int def) {
      this.def = def;
        for (int i = 0; i < def; i++) {
            players.add(new Player(new Defector()));
        }
      return this;
    }    

    public TeamBuilder setCoop(int coop) {
      this.coop = coop;
        for (int i = 0; i < coop; i++) {
            players.add(new Player(new Cooperator()));
        }
      return this;
    }
    
    public TeamBuilder setTit(int tit) {
      this.tit = tit;
        for (int i = 0; i < tit; i++) {
            players.add(new Player(new TitForTat()));
        }
      return this;
    }
    
    public TeamBuilder setRan(int ran) {
      this.ran = ran;
        for (int i = 0; i < ran; i++) {
            players.add(new Player(new Random()));
        }
      return this;
    }
    
    public TeamBuilder setTitF(int titF) {
      this.titF = titF;
        for (int i = 0; i < titF; i++) {
            players.add(new Player(new TitForTatForgiver()));
        }
      return this;
    }
    
    public TeamBuilder setLess (int less) {
      this.less = less;
        for (int i = 0; i < less; i++) {
            players.add(new Player(new LessWrongWinner()));
        }
      return this;
    }
    
    public TeamBuilder setAvg85(int avg85) {
      this.avg85 = avg85;
        for (int i = 0; i < avg85; i++) {
            players.add(new Player(new Averager85()));
        }
      return this;
    }
    
    public TeamBuilder setLm(int lm) {
      this.lm = lm;
        for (int i = 0; i < lm; i++) {
            players.add(new Player(new LongMemory()));
        }
      return this;
    }
    
    public TeamBuilder setCmp(int cmp) {
      this.cmp = cmp;
        for (int i = 0; i < cmp; i++) {
            players.add(new Player(new Comparator()));
        }
      return this;
    }
    
    public TeamBuilder setAvg50(int avg50) {
      this.avg50 = avg50;
        for (int i = 0; i < avg50; i++) {
            players.add(new Player(new Averager50()));
        }
      return this;
    }
    
    public TeamBuilder setAntiTFT(int antiTFT) {
      this.antiTFT = antiTFT;
        for (int i = 0; i < antiTFT; i++) {
            players.add(new Player(new AntiTFT()));
        }
      return this;
    }
  
    public Team build() {
      return new Team(this);
    }
    
    
  }
  
    public Team(TeamBuilder team) {
        this.team = new ArrayList<>(team.players);
    }  
  
}
