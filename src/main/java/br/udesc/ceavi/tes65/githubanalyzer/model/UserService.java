package br.udesc.ceavi.tes65.githubanalyzer.model;

import br.udesc.ceavi.tes65.githubanalyzer.api.ApiGithub;
import br.udesc.ceavi.tes65.githubanalyzer.api.ApiGithub.ApiGithubResult;

public class UserService {
    
    private ApiGithub api;
    
    public UserService(ApiGithub api) {
        this.api = api;
    }

    public GithubUser search(String username) {
        GithubUser user;
        try {
            //If username is empty the api can't be called
            if(username.isEmpty()) {
                throw new Exception("Username is empty.");
            }
            
            //Finds user data in api
            ApiGithubResult result = api.get(username);
            
            //If login is different it means that user does not exists
            if(result.login != username) {
                throw new Exception("User doesn't exists.");
            }
            
            //When everything is ok, is just read results
            user = new GithubUser(username);
            user.setName(result.name);
            user.setCompany(result.company);
            user.setFollowers(result.followers);
            user.setLocation(result.location);
            user.setPhoto(result.avatar_url);
            user.setRepositories(result.public_repos);
            user.setBiography(result.bio);
        }
        catch(Exception e) {
            user = null;
        }
        return user;
    }

}
