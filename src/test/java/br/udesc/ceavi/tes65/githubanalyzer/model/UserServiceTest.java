package br.udesc.ceavi.tes65.githubanalyzer.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import br.udesc.ceavi.tes65.githubanalyzer.api.ApiGithub;
import br.udesc.ceavi.tes65.githubanalyzer.api.ApiGithub.ApiGithubResult;

public class UserServiceTest {
    
    private UserService service;
    
    @Mock
    private ApiGithub api;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        service = new UserService(api);
    }
    
    @Test
    public void testApiDontCalledWhenUsernameIsNull() throws Exception {
        service.search(null);
        verify(api, never()).get(null);
    }
    
    @Test
    public void testApiDontCalledWhenUsernameIsEmpty() throws Exception {
        service.search("");
        verify(api, never()).get("");
    }
    
    @Test
    public void testApiCalledWhenHasUsername() throws Exception {
        service.search("username");
        verify(api, times(1)).get("username");
    }

    @Test
    public void testReturnNullWhenApiThrowsException() throws Exception {
        doThrow(Exception.class).when(api).get("anyuser");
        GithubUser user = service.search("anyuser");
        assertEquals(null, user);
    }

    @Test
    public void testReturnNullWhenUserDoesNotExists() throws Exception {
        when(api.get("userdoesnotexists")).thenAnswer((InvocationOnMock invocation) -> new ApiGithubResult());
        GithubUser user = service.search("userdoesnotexists");
        assertEquals(null, user);
    }

    @Test
    public void testReturnDataWhenUserExists() throws Exception {
        when(api.get("testuser")).thenAnswer((InvocationOnMock invocation) -> new ApiGithubResult("testuser"));
        GithubUser user = service.search("testuser");
        assertEquals(user.getUsername(), "testuser");
    }

}
