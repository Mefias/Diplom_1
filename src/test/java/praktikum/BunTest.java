package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
public class BunTest {
    private final String name = "name1";
    private final float price = 10.0F;
    private Bun bun;
    @Before
    public void beforeTest() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameReturnsConstructorsName() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceReturnsConstructorsPrice() {
        assertEquals(price, bun.getPrice(), 0.001);
    }

    @RunWith(Parameterized.class)
    public static class BunParameterizedTest {
        private Bun bun;
        private final String name;
        private final float price;

        public BunParameterizedTest(String name, float price) {
            this.bun = new Bun(name, price);
            this.name = name;
            this.price = price;
        }

        @Parameterized.Parameters
        public static Object[][] getTestData() {
            return new Object[][]{
                    {"name1", (float) 0.0},
                    {"name2", (float) 1.0},
                    {"name3", (float) 200.0}
            };
        }

        @Test
        public void getNameReturnsConstructorsName() {
            assertEquals(name, bun.getName());
        }

        @Test
        public void getPriceReturnsConstructorsPrice() {
            assertEquals(price, bun.getPrice(), 0.001);
        }
    }
}
