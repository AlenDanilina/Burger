import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {

        List<List<Ingredients>> pileOfPackages =
                IngredientsGenerator.generatePileOfIngredients (1);

        printPile (pileOfPackages);

        for (int i = 0; i < pileOfPackages.size (); ) {
            List<Ingredients> ingredients = pileOfPackages.get (i);
            if (!BurgerValidator.validate (ingredients)) {
                throw new BurgerException ("Нет правильного бургера!");
            } else {
                i++;
            }
        }

        List<List<Ingredients>> cookedBurgers = new ArrayList<> ();
        for (List<Ingredients> unpreparedBurgers : pileOfPackages) {
            cookedBurgers.add (Chef.order (unpreparedBurgers));
        }

        System.out.println ("===========================");
        System.out.println ("Good burger: ");

        printPile (cookedBurgers);
    }

    public static void printPile(List<List<Ingredients>> list) {
        for (List<Ingredients> element : list) {
            System.out.println (element);
        }
    }
}
