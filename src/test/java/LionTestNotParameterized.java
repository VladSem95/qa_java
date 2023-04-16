import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LionTestNotParameterized {
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    Feline feline = Mockito.mock(Feline.class);
    @Test
    public void getFoodLion() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = lion.getFood();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void getKittensLion() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittensCountLion = 1;
        int actualKittensCountLion = lion.getKittens();
        assertEquals(expectedKittensCountLion, actualKittensCountLion);
    }
    @Test
    public void lionSexNegative() {
        try {
            Lion lion = new Lion("Животное", feline);
            boolean expectedHasMane = false;
            boolean actualHasMane = lion.doesHaveMane();
            assertEquals(expectedHasMane, actualHasMane);
        } catch(java.lang.Exception exception) {
            System.out.println("Невозможно определить наличие гривы");
        }
    }
}