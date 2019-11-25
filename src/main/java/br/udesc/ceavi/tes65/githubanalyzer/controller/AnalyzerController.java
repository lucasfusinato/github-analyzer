package br.udesc.ceavi.tes65.githubanalyzer.controller;

import java.util.ArrayList;
import java.util.List;

import br.udesc.ceavi.tes65.githubanalyzer.api.ApiGithub;
import br.udesc.ceavi.tes65.githubanalyzer.model.GithubUser;
import br.udesc.ceavi.tes65.githubanalyzer.model.PointCalculator;
import br.udesc.ceavi.tes65.githubanalyzer.model.ResultAnalyzer;
import br.udesc.ceavi.tes65.githubanalyzer.model.UserService;

public class AnalyzerController implements AnalyzerControllerInterface {
    
    private List<AnalyzerControllerObserver> observers;
    private UserService userService;
    private PointCalculator pointCalculator;
    private ResultAnalyzer resultAnalyzer;
    
    public AnalyzerController() {
        observers = new ArrayList<>();
        userService = new UserService(new ApiGithub());
        pointCalculator = new PointCalculator();
        resultAnalyzer = new ResultAnalyzer();
    }

    @Override
    public void attach(AnalyzerControllerObserver observer) {
        observers.add(observer);
    }

    @Override
    public void startUserAnalysis(String username) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                GithubUser user = userService.search(username);
                String analysis = null;
                if(user != null) {
                    int points = pointCalculator.calculate(user);
                    String result = resultAnalyzer.analyze(points);
                    analysis = String.format("%s - %s", points, result);
                }
                notifyUserAnalysis(user, analysis);
            }
        }).start();
    }

    private void notifyUserAnalysis(GithubUser user, String analysis) {
        for(AnalyzerControllerObserver observer : observers) {
            observer.updateUserAnalysis(user, analysis);
        }
    }

}
