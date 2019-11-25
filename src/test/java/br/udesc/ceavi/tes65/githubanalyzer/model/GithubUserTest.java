package br.udesc.ceavi.tes65.githubanalyzer.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GithubUserTest {
    
    private GithubUser user;
    
    @Before
    public void setUp() throws Exception {
        user = new GithubUser("test");
    }
    
    @Test
    public void testUsernameAccessorMethods() {
        user.setUsername("testusername");
        assertEquals("testusername", user.getUsername());
    }
    
    @Test
    public void testNameAccessorMethods() {
        user.setName("Fusinato");
        assertEquals("Fusinato", user.getName());
    }
    
    @Test
    public void testPhotoAccessorMethods() {
        user.setPhoto("photourl");
        assertEquals("photourl", user.getPhoto());
    }
    
    @Test
    public void testLocationAccessorMethods() {
        user.setLocation("Brazil");
        assertEquals("Brazil", user.getLocation());
    }
    
    @Test
    public void testCompanyAccessorMethods() {
        user.setCompany("IPM");
        assertEquals("IPM", user.getCompany());
    }
    
    @Test
    public void testFollowersAccessorMethods() {
        user.setFollowers(10);
        assertEquals(10, user.getFollowers());
    }
    
    @Test
    public void testRepositoriesAccessorMethods() {
        user.setRepositories(5);
        assertEquals(5, user.getRepositories());
    }
    
    @Test
    public void testBiographyAccessorMethods() {
        user.setBiography("Software Engineering.");
        assertEquals("Software Engineering.", user.getBiography());
    }

}
