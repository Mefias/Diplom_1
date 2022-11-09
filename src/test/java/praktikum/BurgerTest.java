package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    @Before
    public void before() {
        burger = new Burger();
    }
    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
    @Test
    public void getPrice() {
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient1.getPrice()).thenReturn(10F);
        Mockito.when(ingredient2.getPrice()).thenReturn(20F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals(230, burger.getPrice(), 0.001);
    }
    @Test
    public void getReceipt() {
        Mockito.when(bun.getName()).thenReturn("bun name");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("sause name");
        Mockito.when(ingredient1.getPrice()).thenReturn(10F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        String ln = System.lineSeparator();
        String expected = "(==== bun name ====)"+ln
                +"= sauce sause name ="+ln
                +"(==== bun name ====)"+ln
                +ln
                +"Price: 210,000000"+ln;

        assertEquals(expected, burger.getReceipt());
    }
}
