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
    public void catEatMeat() throws Exception {
        this.predator = feline;
            Mockito.when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            List<String>actualEatCat = predator.eatMeat();
            List<String>expectedEatCat = List.of("Животные", "Птицы", "Рыба");
            assertEquals(expectedEatCat,actualEatCat);
    }
}
