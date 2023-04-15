import com.example.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.lang.Exception;
import java.util.List;


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
                {"Самка", false},
                {"Животное", false}
        };
    }

    @Test
    public void lionSex() throws Exception {
        try {
            Lion lion = new Lion(sexLion, feline);
            boolean actualHasMane = lion.doesHaveMane();
            assertEquals(expectedHasMane, actualHasMane);
        } catch (java.lang.Exception exception) {
            System.out.println("Используйте допустимые значения пола животного - самец или самка");
        }
    }
    @Test
    public void doesHaveManeLion() throws Exception {
        try {

        Lion lion = new Lion(sexLion,feline);
        boolean expectedHasManeLion = expectedHasMane;
        boolean actualHasManeLion = lion.doesHaveMane();
        assertEquals(expectedHasManeLion,actualHasManeLion);
        } catch(java.lang.Exception exception) {
            System.out.println("У данного пола невозможно определить наличие гривы");
        }
    }
}



