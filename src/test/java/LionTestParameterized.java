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
public class LionTestParam {
    private final String sexLion;
    private final boolean expectedHasMane;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    Feline feline = Mockito.mock(Feline.class);

    public LionTestParam(String sexLion, boolean expectedHasMane) {
        this.sexLion = sexLion;
        this.expectedHasMane = expectedHasMane;
    }


    @Parameterized.Parameters
    public static Object[][] getSexAndExpected() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void lionSexPositive() throws Exception {

        Lion lion = new Lion(sexLion, feline);
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(expectedHasMane, actualHasMane);
    }

    @Test
    public void getKittensLion() throws Exception {

        Lion lion = new Lion(sexLion, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittensCountLion = 1;
        int actualKittensCountLion = lion.getKittens();
        assertEquals(expectedKittensCountLion, actualKittensCountLion);
    }

    @Test
    public void getFoodLion() throws Exception {
        Lion lion = new Lion(sexLion, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = lion.getFood();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void doesHaveManeLionPositive() throws Exception {
        Lion lion = new Lion(sexLion,feline);
        boolean expectedHasManeLion = expectedHasMane;
        boolean actualHasManeLion = lion.doesHaveMane();
        assertEquals(expectedHasManeLion,actualHasManeLion);
    }
    @Test
    public void doesHaveManeLionNegative() throws Exception {
        try {
            new Lion("Животное", feline).doesHaveMane();
        } catch (java.lang.Exception exception) {
        }
    }

    @Test
    public void lionHasManeNegative() {
        try {
            Lion lion = new Lion("Животное", feline);
        } catch(java.lang.Exception exception) {
           System.out.println ("Используйте допустимые значения пола животного - самец или самка");
        }
    }
}



