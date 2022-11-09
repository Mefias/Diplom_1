package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    String ingredientTypeName;
    public IngredientTypeTest(String ingredientTypeName) {
        this.ingredientTypeName = ingredientTypeName;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void enumHasTypeName() {
        IngredientType.valueOf(ingredientTypeName);
    }
}