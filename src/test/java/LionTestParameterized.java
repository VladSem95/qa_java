import com.example.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.lang.Exception;


import static org.junit.Assert.assertEquals;




@RunWith(Parameterized.class)
public class LionTestParameterized {
    private final String sexLion;
    private final boolean expectedHasMane;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    Feline feline = Mockito.mock(Feline.class);

    public LionTestParameterized(String sexLion, boolean expectedHasMane) {
        this.sexLion = sexLion;
        this.expectedHasMane = expectedHasMane;
    }


    @Parameterized.Parameters
    public static Object[][] getSexAndExpected() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void lionSexPositive() throws Exception {
            Lion lion = new Lion(sexLion, feline);
            boolean actualHasMane = lion.doesHaveMane();
            assertEquals(expectedHasMane, actualHasMane);
    }
    @Test
    public void doesHaveManeLion() throws Exception {
        Lion lion = new Lion(sexLion,feline);
        boolean expectedHasManeLion = expectedHasMane;
        boolean actualHasManeLion = lion.doesHaveMane();
        assertEquals(expectedHasManeLion,actualHasManeLion);
    }
}



