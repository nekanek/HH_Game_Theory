
package Strategies;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({Strategies.AntiTFTTest.class, Strategies.RandomTest.class, Strategies.IStrategyTest.class, Strategies.Averager50Test.class, Strategies.TitForTatTest.class, Strategies.LongMemoryTest.class, Strategies.TitForTatForgiverTest.class, Strategies.DefectorTest.class, Strategies.Averager85Test.class, Strategies.ComparatorTest.class, Strategies.CooperatorTest.class, Strategies.LessWrongWinnerTest.class})

public class StrategiesSuite {

    
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {

    }
    
}
