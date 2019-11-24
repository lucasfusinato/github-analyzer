package br.udesc.ceavi.tes65.githubanalyzer.model;

import java.util.Optional;

public class PointCalculator {
    
    public int calculate(GithubUser user) {
        int points = 0;
        if(!Optional.ofNullable(user.getName()).isEmpty()) {
            points += 10;
        }
        if(!Optional.ofNullable(user.getPhoto()).isEmpty()) {
            points += 10;
        }
        if(!Optional.ofNullable(user.getLocation()).isEmpty()) {
            points += 10;
        }
        if(Optional.ofNullable(user.getCompany()).isEmpty()) {
            points += 5;
        }
        if(!Optional.ofNullable(user.getBiography()).isEmpty()) {
            points += 10;
        }
        points += Math.min(user.getFollowers() * 2, 20);
        points += Math.min(user.getRepositories() * 5, 35);
        return points;
    }

}
