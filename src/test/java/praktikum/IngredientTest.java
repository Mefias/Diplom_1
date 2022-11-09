package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private final Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.ingredient = new Ingredient(type, name, price);
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
            {IngredientType.FILLING, "filling name", 100.0F},
            {IngredientType.SAUCE,"sauce name", 200.0F}
        };
    }

    @Test
    public void getTypeReturnsConstructorsType() {
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void getNameReturnsConstructorsName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceReturnsConstructorsPrice() {
        assertEquals(price, ingredient.getPrice(), 0.001);
    }
}
