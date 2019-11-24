package br.udesc.ceavi.tes65.githubanalyzer.model;

public class ResultAnalyzer {
    
    public String analyze(int points) {
        String analyze;
        if(points < 50) {
            analyze = "Bad";
        }
        else if(points >= 50 && points < 70) {
            analyze = "Normal";
        }
        else {
            analyze = "Good";
        }
        return analyze;
    }

}
