

import java.util.List;


/**
 * Класс для проверки упаковок ингредиентов
 */
public class BurgerValidator {
    /**
     * Метод проверки, содержится ли в упаковке ингредиентов достаточное количество ингредиентов
     * для приготовления бургера (проверяется что булочек 2 или 3 и присутствует хотя бы одна котлета)
     *
     * @param upakovka
     * @return
     */
    public static boolean validate(List<Ingredients> upakovka) {
        return isEnoughBuns(upakovka)
                && upakovka.contains (Ingredients.MEAT)
                && upakovka.contains (Ingredients.CHEESE);
    }

    public static int bunCount(List<Ingredients> upakovka) {
        int bunCount = 0;

        for (Ingredients ingredients : upakovka) {
            if (ingredients.equals (Ingredients.BUN)) bunCount++;
        }
        return bunCount;
    }

    private static boolean isEnoughBuns(List<Ingredients> upakovka) {
        return bunCount (upakovka) <= 3 && bunCount (upakovka) > 1;
    }

}
