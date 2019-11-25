# 🕵 Github Analyzer

Github Analyzer is a tool to improve your github profile.

## Context

The whole scenario was specified in a playful way, just to allow the application of the Mockito tool in the development of unit and integration tests in a software.

## How it works

You enter a username on github, the app fetchs user data in [Github API](https://developer.github.com/v3/) and ranks profile based on how much information was fill out.

This process is divided into two steps, as follow:

### # Step 1: Score calculation

Analyzer calculates a score from user profile filled information.

| Description  | Points |
| ------------- | ------------- |
| Has name  | + 10 points  |
| Has photo  | + 10 points  |
| Has location  | + 10 points  |
| Has company name  | + 5 points  |
| Has biography  | + 10 points  |
| Has followers  | + 2 points per follower, maximum 20 points  |
| Has repositories  | + 5 points per repository, maximum 35 points  |

### # Step 2: Ranking

Based on score calculation, analyzer generates a user profile rating.

| Description  | Score |
| ------------- | ------------- |
| Bad  | Less than 50 points  |
| Normal  | From 50 to 70 points  |
| Good  | From 70 points  |

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Gson](https://rometools.github.io/rome/) - Library to read Github API json data
* [JUnit](https://rometools.github.io/rome/) - Framework to write unite tests
* [Mockito](https://rometools.github.io/rome/) - Mocking framework to help in unit tests

## Author

* **Lucas Fusinato Wilhelm Chiodini Zanis** - *Specification and development* - [lucasfusinato](https://github.com/lucasfusinato)

## License

This project is licensed under the MIT License.
