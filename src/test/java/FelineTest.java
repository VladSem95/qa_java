import com.example.Animal;
import com.example.Feline;
import org.junit.Test;
import java.util.List;


import static org.junit.Assert.assertEquals;


public class FelineTest {
    Feline feline = new Feline();


    @Test
    public void getFoodFeline() throws Exception {
        List<String> expectedFoodFeline = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFoodFeline = feline.getFood("Хищник");
        assertEquals(expectedFoodFeline,actualFoodFeline);
    }
    @Test
    public void eatMeatFeline() throws Exception {
        List<String> actualResult = feline.eatMeat();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void getFamilyFeline() {
        String expectedFamilyFeline = "Кошачьи";
        String actualFamilyFeline = feline.getFamily();
        assertEquals(expectedFamilyFeline,actualFamilyFeline);
    }

    @Test
    public void getKittensValueFeline() {
        int kittensCount = (int) Math.random() * 8;
        int expectedKittensCount = kittensCount;
        int actualKittensCount = feline.getKittens(kittensCount);
        assertEquals(expectedKittensCount,actualKittensCount);
    }

    @Test
        public void getKittensNoValueFeline() {
        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens();
        assertEquals(expectedKittensCount,actualKittensCount);
    }
}
