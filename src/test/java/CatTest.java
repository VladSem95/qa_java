import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)

public class CatTest {
    @Mock
    private Feline feline;
    private Predator predator;


    @Test
    public void catGetSound() {

        Cat cat = new Cat(feline);
        String expectedGetSound = "Мяу";
        String actualGetSound = cat.getSound();
        assertEquals(expectedGetSound, actualGetSound);
    }

    @Test
    public void catEatMeat() {
        Cat cat = new Cat(feline);
        try {
            Mockito.when(predator.eatMeat()).thenReturn(feline.eatMeat());
            Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            predator.eatMeat();
        } catch(java.lang.Exception exception) {

        }
    }
    @Test
    public void catGetFoodException() throws Exception {

        Cat cat = new Cat(feline);
        try {
            List<String> actualFoodCat = cat.getFood();
        }
        catch (NullPointerException exception) {
        }
    }
}
