
import java.util.List;


/**
 * Класс шеф-повара, отвечающий за превращение неупорядоченных наборов ингредиентов
 * в бургеры.
 */
public class Chef {

    public static List<Ingredients> order(List<Ingredients> upakovka) {

        int buns = BurgerValidator.bunCount (upakovka);

        for (int i = 0; i < upakovka.size (); i++) {
            Ingredients ingredient = upakovka.get (i);
            if (ingredient.equals (Ingredients.BUN)) {
                upakovka.remove (i);
            }
        }

        upakovka.add (0, Ingredients.BUN);
        if (buns != 2) {
            upakovka.add (upakovka.size () / 2, Ingredients.BUN);
        }
        upakovka.add (Ingredients.BUN);

        sortCheese (upakovka);
        sortSalad (upakovka);

        return upakovka;
    }

    /**
     * Находим сыр и кладем его на место.
     *
     * @param upakovka упаковка с ингредиентами.
     */
    private static void sortCheese(List<Ingredients> upakovka) {
        for (int i = 1; i < upakovka.size () - 1; i++) {
            Ingredients ingredients = upakovka.get (i);
            if (ingredients.equals (Ingredients.CHEESE)) {
                upakovka.remove (i);
                int meatIndex = upakovka.indexOf (Ingredients.MEAT);
                upakovka.add (meatIndex + 1, ingredients);
                break;
            }
        }
    }

    private static void sortSalad(List<Ingredients> upakovka) {
        for (int i = 1; i < upakovka.size () - 1; i++) {
            Ingredients ingredients = upakovka.get (i);
            if (ingredients.equals (Ingredients.SALAD)) {
                upakovka.remove (i);
                upakovka.add (upakovka.size () - 1 , ingredients);
                break;
            }
        }
    }

}
