package hh.game;

public class Main {    

    public static void main(String[] args) {
        
        startGame("Coopers", new Team.TeamBuilder().setDef(1).setCoop(5).setTit(3).setTitF(1).build());
        startGame("Titers", new Team.TeamBuilder().setDef(1).setTit(6).setTitF(3).build());
        startGame("Rationals", new Team.TeamBuilder().setTit(3).setTitF(3).setLess(2).setAvg85(2).build());
        startGame("Ignorants", new Team.TeamBuilder().setRan(10).build());
        startGame("Balanced", new Team.TeamBuilder().setDef(1).setCoop(1).setTit(2).setRan(2).setTitF(1).setLess(1).setAvg85(2).build());
        startGame("Pure Coop", new Team.TeamBuilder().setCoop(10).build());
        startGame("Pure Tit", new Team.TeamBuilder().setTit(10).build());
        startGame("Pure Def", new Team.TeamBuilder().setDef(10).build());
        startGame("Pure Tit forgiving", new Team.TeamBuilder().setTitF(10).build());
        startGame("Pure Less", new Team.TeamBuilder().setLess(10).build());
        startGame("Pure avg85", new Team.TeamBuilder().setAvg85(10).build());
        startGame("Pure long mem", new Team.TeamBuilder().setLm(10).build());
        startGame("Pure comparators", new Team.TeamBuilder().setCmp(10).build());
        startGame("Pure avg50", new Team.TeamBuilder().setAvg50(10).build());
        startGame("Anti TFT and TFT", new Team.TeamBuilder().setTit(9).setAntiTFT(1).build());
        startGame("comps and less and long mem", new Team.TeamBuilder().setLess(3).setLm(4).setCmp(3).build());
        startGame("coops and long mem", new Team.TeamBuilder().setCoop(8).setLm(2).build());
    }
    
    private static void startGame(String label, Team team) {
        System.out.println(label);
        Game myGame = new Game(team.team, true);
        myGame.play();  
        System.out.println();
    }
}
