package br.udesc.ceavi.tes65.githubanalyzer.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class PointCalculatorTest {
    
    private PointCalculator calculator = new PointCalculator();

    @Mock
    private GithubUser userMock;
    
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testIfSums10PointsWhenUserHasName() {
        int pointsWithoutName, pointsWithName;
        
        pointsWithoutName = calculator.calculate(userMock);
        
        when(userMock.getName()).thenReturn("Name");
        pointsWithName = calculator.calculate(userMock);
        
        assertEquals(10, pointsWithName - pointsWithoutName);
    }

    @Test
    public void testIfSums10PointsWhenUserHasPhoto() {
        int pointsWithoutPhoto, pointsWithPhoto;
        
        pointsWithoutPhoto = calculator.calculate(userMock);
        
        when(userMock.getPhoto()).thenReturn("photo.png");
        pointsWithPhoto = calculator.calculate(userMock);
        
        assertEquals(10, pointsWithPhoto - pointsWithoutPhoto);
    }

    @Test
    public void testIfSums10PointsWhenUserHasLocation() {
        int pointsWithoutLocation, pointsWithLocation;
        
        pointsWithoutLocation = calculator.calculate(userMock);
        
        when(userMock.getLocation()).thenReturn("City - State");
        pointsWithLocation = calculator.calculate(userMock);
        
        assertEquals(10, pointsWithLocation - pointsWithoutLocation);
    }

    @Test
    public void testIfSums5PointsWhenUserHasNotCompany() {
        int pointsWithoutCompany, pointsWithCompany;
        
        pointsWithoutCompany = calculator.calculate(userMock);
        
        when(userMock.getCompany()).thenReturn("Company");
        pointsWithCompany = calculator.calculate(userMock);
        
        assertEquals(5, pointsWithoutCompany - pointsWithCompany);
    }

    @Test
    public void testIfSums10PointsWhenUserHasBiography() {
        int pointsWithoutBiography, pointsWithBiography;
        
        pointsWithoutBiography = calculator.calculate(userMock);
        
        when(userMock.getBiography()).thenReturn("Biography");
        pointsWithBiography = calculator.calculate(userMock);
        
        assertEquals(10, pointsWithBiography - pointsWithoutBiography);
    }

    @Test
    public void testIfSums2PointsWhenUserHas1Follower() {
        int pointsWithoutFollower, pointsWith1Follower;
        
        pointsWithoutFollower = calculator.calculate(userMock);
        
        when(userMock.getFollowers()).thenReturn(1);
        pointsWith1Follower = calculator.calculate(userMock);
        
        assertEquals(2, pointsWith1Follower - pointsWithoutFollower);
    }

    @Test
    public void testIfSums20PointsWhenUserHas10Followers() {
        int pointsWithoutFollower, pointsWith10Followers;
        
        pointsWithoutFollower = calculator.calculate(userMock);
        
        when(userMock.getFollowers()).thenReturn(10);
        pointsWith10Followers = calculator.calculate(userMock);
        
        assertEquals(20, pointsWith10Followers - pointsWithoutFollower);
    }

    @Test
    public void testIfSums5PointsWhenUserHas1Repository() {
        int pointsWithoutRepository, pointsWith1Repository;
        
        pointsWithoutRepository = calculator.calculate(userMock);
        
        when(userMock.getRepositories()).thenReturn(1);
        pointsWith1Repository = calculator.calculate(userMock);
        
        assertEquals(5, pointsWith1Repository - pointsWithoutRepository);
    }

    @Test
    public void testIfSums35PointsWhenUserHas7Repositories() {
        int pointsWithoutRepository, pointsWith7Repositories;
        
        pointsWithoutRepository = calculator.calculate(userMock);
        
        when(userMock.getRepositories()).thenReturn(7);
        pointsWith7Repositories = calculator.calculate(userMock);
        
        assertEquals(35, pointsWith7Repositories - pointsWithoutRepository);
    }
    
}
