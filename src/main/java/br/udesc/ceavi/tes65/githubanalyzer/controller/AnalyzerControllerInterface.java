package br.udesc.ceavi.tes65.githubanalyzer.controller;

public interface AnalyzerControllerInterface {

    void attach(AnalyzerControllerObserver observer);

    void startUserAnalysis(String username);

}
