public class SortPackages {

    public static String sort(int width, int height, int length, int mass) {
        int volume = width * height * length;
        boolean isBulky = volume >= 1_000_000 || width >= 150 || height >= 150 || length >= 150;
        boolean isHeavy = mass >= 20;
        if (isBulky && isHeavy)
            return "REJECTED";
        if (isBulky || isHeavy)
            return "SPECIAL";
        return "STANDARD";
    }

    public static void main(String[] args) {
        System.out.println(sort(10, 10, 10, 5));

        // STANDARD
        System.out.println(sort(200, 10, 10, 5));

        // // SPECIAL
        System.out.println(sort(10, 10, 10, 25));

        // / SPECIAL
        System.out.println(sort(200, 200, 200, 25));
        // / REJECTED
    }
}