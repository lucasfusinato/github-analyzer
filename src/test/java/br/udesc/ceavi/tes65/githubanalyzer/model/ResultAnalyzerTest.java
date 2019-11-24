package br.udesc.ceavi.tes65.githubanalyzer.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class ResultAnalyzerTest {

    private ResultAnalyzer analyzer = new ResultAnalyzer();

    @Test
    public void testIfAnalyzeAsBadIfHasTo50Points() {
        int points;
        String analyze;
        
        points = 0;
        analyze = analyzer.analyze(points);
        assertEquals("Bad", analyze);

        points = 50;
        analyze = analyzer.analyze(points);
        assertNotEquals("Bad", analyze);
    }

    @Test
    public void testIfAnalyzeAsNormalIfHasFrom50To70Points() {
        int points;
        String analyze;
        
        points = 50;
        analyze = analyzer.analyze(points);
        assertEquals("Normal", analyze);

        points = 70;
        analyze = analyzer.analyze(points);
        assertNotEquals("Normal", analyze);
    }

    @Test
    public void testIfAnalyzeAsGoodIfHasFrom70Points() {
        int points;
        String analyze;
        
        points = 70;
        analyze = analyzer.analyze(points);
        assertEquals("Good", analyze);

        points = 100;
        analyze = analyzer.analyze(points);
        assertEquals("Good", analyze);
    }

}
