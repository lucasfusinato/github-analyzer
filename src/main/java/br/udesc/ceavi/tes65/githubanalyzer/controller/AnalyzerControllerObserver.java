package br.udesc.ceavi.tes65.githubanalyzer.controller;

import br.udesc.ceavi.tes65.githubanalyzer.model.GithubUser;

public interface AnalyzerControllerObserver {

    void updateUserAnalysis(GithubUser user, String analysis);

}
