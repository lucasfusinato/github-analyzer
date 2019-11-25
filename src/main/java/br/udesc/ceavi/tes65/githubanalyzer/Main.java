package br.udesc.ceavi.tes65.githubanalyzer;

import br.udesc.ceavi.tes65.githubanalyzer.controller.AnalyzerController;
import br.udesc.ceavi.tes65.githubanalyzer.view.HomeView;

public class Main {
    
    public static void main(String[] args) {
        new HomeView(new AnalyzerController()).setVisible(true);
    }

}
